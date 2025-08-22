# ====== stage 1: runtime (slim) ======
FROM python:3.12-slim AS runtime

# Evita bytecode e força logs a irem pro stdout/stderr
ENV PYTHONDONTWRITEBYTECODE=1 \
    PYTHONUNBUFFERED=1 \
    PIP_NO_CACHE_DIR=1 \
    # caminho padrão do seu modelo .joblib (ajuste se precisar)
    MODEL_PATH=/models/modelo_fraude2.joblib

# Dependências do sistema (compilar wheels leves e libs nativas do numpy/pandas)
RUN apt-get update && apt-get install -y --no-install-recommends \
    build-essential \
    curl \
    && rm -rf /var/lib/apt/lists/*

WORKDIR /app

COPY requirements.txt .

# Instala dependências Python
RUN pip install --upgrade pip && pip install -r requirements.txt

# Copia o código e o modelo
# (ajuste o nome do arquivo principal; aqui assumo main.py com "app = FastAPI(...)")
COPY . .
# Garanta que o modelo exista no caminho definido (ou ajuste o ENV acima)
# Ex.: COPY modelo_fraude2.joblib /models/modelo_fraude2.joblib

# Usuário não-root
RUN useradd -m appuser
USER appuser

EXPOSE 8000

# Healthcheck simples (usa /healthz da sua API)
HEALTHCHECK --interval=30s --timeout=3s --start-period=10s --retries=3 \
  CMD curl -fsS http://localhost:8000/healthz || exit 1

# Suba com uvicorn (ajuste "main:app" se seu arquivo/app tiver outro nome)
CMD ["python", "-m", "uvicorn", "main:app", "--host", "0.0.0.0", "--port", "8000"]
