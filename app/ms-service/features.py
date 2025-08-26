from sklearn.base import BaseEstimator, TransformerMixin

import logging


logger = logging.getLogger(__name__)

class FeatureMaker(BaseEstimator, TransformerMixin):
    def __init__(self):
        pass

    def fit(self, X, y=None):
        return self

    def transform(self, X):
        logger.debug("Iniciando transformação de features")
        logger.debug(f"Shape do DataFrame de entrada: {X.shape}")
        logger.debug(f"Colunas disponíveis: {X.columns.tolist()}")
        
        X = X.copy()
        
        # Debug antes da primeira operação
        logger.debug("Valores antes do cálculo acessos_por_populacao:")
        logger.debug(f"acessos: {X['acessos'].head()}")
        logger.debug(f"populacao_estimada_numerica3: {X['populacao_estimada_numerica3'].head()}")
        
        try:
            X['acessos_por_populacao'] = X['acessos'] / X['populacao_estimada_numerica3']
            logger.debug(f"acessos_por_populacao calculado: {X['acessos_por_populacao'].head()}")
        except Exception as e:
            logger.error(f"Erro no cálculo de acessos_por_populacao: {str(e)}")
            logger.error(f"Tipos - acessos: {X['acessos'].dtype}, pop: {X['populacao_estimada_numerica3'].dtype}")
            raise

        try:
            X['diferenca_codigos'] = (X['codigo_nacional'] - X['codigo_nacional_chip']).abs()
            logger.debug(f"diferenca_codigos calculado: {X['diferenca_codigos'].head()}")
        except Exception as e:
            logger.error(f"Erro no cálculo de diferenca_codigos: {str(e)}")
            logger.error(f"Tipos - codigo_nacional: {X['codigo_nacional'].dtype}, chip: {X['codigo_nacional_chip'].dtype}")
            raise

        colunas_para_remover = ['codigo_nacional_chip','codigo_nacional','acessos','populacao_estimada_numerica3']
        logger.debug(f"Removendo colunas: {colunas_para_remover}")
        
        return X.drop(columns=colunas_para_remover, errors='ignore')