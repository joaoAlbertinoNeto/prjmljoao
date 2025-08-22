import os
from typing import Any, Dict, List, Optional
import logging

import numpy as np
import pandas as pd
from fastapi import FastAPI, HTTPException
from pydantic import BaseModel , ConfigDict
from joblib import load

MODEL_PATH = os.getenv("MODEL_PATH", "modelo_fraude2.joblib")

# Carrega uma única vez na subida
bundle = load(MODEL_PATH)
clf = bundle["clf"]
colunas_treino = bundle["colunas_treino"]  
  # você salvou assim antes

app = FastAPI(title="Channel Biometry Refactor Predict v1", version="1.0.0")

# Configuração do logger
logging.basicConfig(
    level=logging.DEBUG,
    format='%(asctime)s - %(levelname)s - %(message)s'
)
logger = logging.getLogger(__name__)

class Record(BaseModel):
    model_config = ConfigDict(extra='allow')
    tipo_produto: Optional[str] = None
    tipo_pessoa: Optional[str] = None
    mes: Optional[int] = None
    populacao_estimada_numerica2: Optional[float] = None
    uf: Optional[str] = None
    empresa: Optional[str] = None
    tecnologia_geracao: Optional[str] = None
    modalidade_cobranca: Optional[str] = None
    populacao_estimada_numerica: Optional[float] = None
    grupo_economico: Optional[str] = None
    populacao_estimada: Optional[str] = None
    municipio: Optional[str] = None
    codigo_ibge_municipio: Optional[int] = None
    latitude: Optional[float] = None
    cnpj: Optional[str] = None
    fraude: Optional[int] = None
    porte_prestadora: Optional[str] = None
    longitude: Optional[float] = None
    tecnologia: Optional[str] = None
    acessos: Optional[int] = None
    populacao_estimada_numerica3: Optional[float] = None
    codigo_nacional: Optional[int] = None
    codigo_nacional_chip: Optional[int] = None
    ano: Optional[int] = None

class PredictRequest(BaseModel):
    records: List[Record]
    # threshold opcional (default 0.5 ou 0.2 como você usou)
    threshold: Optional[float] = 0.2

class PredictResponse(BaseModel):
    predictions: List[int]
    probabilities: List[float]
    applied_threshold: float

@app.get("/healthz")
def health():
    return {"status": "ok"}

@app.post("/predict", response_model=PredictResponse)
def predict(req: PredictRequest):
    logger.debug(f"Recebida requisição com {len(req.records)} registros")
    if not req.records:
        raise HTTPException(status_code=400, detail="records vazio")

    rows = [r.model_dump() for r in req.records]
    df = pd.DataFrame(rows)
    df.columns = df.columns.astype(str)

    # 0) Remova alvo se vier por engano
    if "fraude" in df.columns:
        df = df.drop(columns=["fraude"])

    # 1) Garanta colunas base necessárias para a engenharia
    for c in ["acessos", "populacao_estimada_numerica3",
              "codigo_nacional", "codigo_nacional_chip",
              "ano"]:
        if c not in df.columns:
            df[c] = pd.NA

    # 2) Conserte tipos mínimos p/ criar features (valores não numéricos -> NaN)
    for c in ["acessos", "populacao_estimada_numerica3", "codigo_nacional",
              "codigo_nacional_chip", "ano"]:
        df[c] = pd.to_numeric(df[c], errors="coerce")

    # 3) Recrie as features exatamente como no treino
    df["acessos_por_populacao"] = df["acessos"] / df["populacao_estimada_numerica3"]
    df["diferenca_codigos"] = (df["codigo_nacional"] - df["codigo_nacional_chip"]).abs()

    # 4) Remova as colunas cruas removidas no treino
    cols_drop = ["codigo_nacional_chip", "codigo_nacional", "acessos", "populacao_estimada_numerica3"]
    df = df.drop(columns=[c for c in cols_drop if c in df.columns])

    # 5) Garanta 'ano' numérico e impute NaN com 0 como no treino
    if "ano" in df.columns:
        df["ano"] = pd.to_numeric(df["ano"], errors="coerce").fillna(0)

    # 6) One-hot das demais (igual ao treino: get_dummies padrão)
    df = pd.get_dummies(df)

    # 7) Alinhe às colunas do treino (adiciona faltantes com 0 e ordena)
    df = df.reindex(columns=colunas_treino, fill_value=0)

    # 8) Predição
    try:
        # Depois do get_dummies E ANTES do reindex
        cols_current = set(df.columns)
        cols_train = set(colunas_treino)

        missing_in_train = sorted(cols_current - cols_train)    # serão descartadas no reindex
        unused_now = sorted(cols_train - cols_current)          # vão entrar como 0 no reindex

        logger.debug(f"Total cols atuais (pré-reindex): {len(cols_current)}")
        logger.debug(f"Não existem no treino (serão descartadas): {missing_in_train[:50]}")
        logger.debug(f"Do treino mas ausentes agora (entrarão como 0): {unused_now[:50]}")

        # Depois do reindex
        nz = df.reindex(columns=colunas_treino, fill_value=0)
        nz_cols = nz.columns[(nz != 0).any(axis=0)]
        logger.debug(f"Colunas != 0 depois do reindex ({len(nz_cols)}): {list(nz_cols)[:40]}")
        proba = clf.predict_proba(df)[:, 1]
    except Exception as e:
        logger.exception("Falha no predict_proba. Verifique alinhamento de colunas e dtypes.")
        raise HTTPException(status_code=500, detail=str(e))

    threshold = float(req.threshold if req.threshold is not None else 0.2)
    preds = (proba >= threshold).astype(int).tolist()

    return PredictResponse(
        predictions=preds,
        probabilities=proba.tolist(),
        applied_threshold=threshold
    )