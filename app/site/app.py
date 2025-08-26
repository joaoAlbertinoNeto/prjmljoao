import streamlit as st
import asyncio
from confluent_kafka import Producer
import json
import requests

# Configuração Kafka (ajuste conforme necessário)
KAFKA_BOOTSTRAP_SERVERS = 'localhost:29092'
KAFKA_TOPIC = 'movements'

producer = Producer({'bootstrap.servers': KAFKA_BOOTSTRAP_SERVERS})

# Estado inicial do evento fixo
fixedEvt = {
    "tipo_produto": "Móvel",
    "tipo_pessoa": "Física",
    "mes": 8,
    "populacao_estimada_numerica2": 15000.0,
    "uf": "SP",
    "empresa": "EMPRESA X",
    "tecnologia_geracao": "4G",
    "modalidade_cobranca": "Pré-pago",
    "populacao_estimada_numerica": 15000.0,
    "grupo_economico": "GRUPO A",
    "populacao_estimada": "15000",
    "municipio": "São Paulo",
    "codigo_ibge_municipio": 3550308,
    "latitude": -23.5505,
    "cnpj": "00000000000191",
    "porte_prestadora": "Grande",
    "longitude": -46.6333,
    "tecnologia": "LTE",
    "acessos": 1,
    "populacao_estimada_numerica3": 15000.0,
    "codigo_nacional": 13,   # será atualizado pelo campo DDD
    "codigo_nacional_chip": 11,
    "ano": 2025,
    "msisdn": "11987654321",  # será atualizado pelo campo Número
}

async def enviar_evento_kafka(evento):
    producer.produce(KAFKA_TOPIC, value=json.dumps(evento))
    print("Evento enviado para o Kafka:", evento)
    producer.flush()

def post_evento(evento):
    loop = asyncio.new_event_loop()
    loop.run_until_complete(enviar_evento_kafka(evento))
    loop.close()

# Configuração da página
st.set_page_config(page_title="Operadora de Planos", page_icon="📱", layout="centered")

# ==========================
# TOPO: Campos de DDD e Número
# ==========================
st.markdown("### Dados do Usuário")
col1, col2 = st.columns(2)
with col1:
    ddd = st.text_input("DDD", value="11")
with col2:
    numero = st.text_input("Número", value="987654321")

# Atualiza os valores no evento fixo
fixedEvt["codigo_nacional"] = int(ddd) if ddd.isdigit() else 0
fixedEvt["msisdn"] = numero if ddd and numero else ""

# ==========================
# Dados dos planos
# ==========================
planos_pos = [
    {"nome": "Pós 20GB", "preco": "R$ 79,90/mês", "descricao": "20GB de internet, ligações ilimitadas, SMS ilimitado."},
    {"nome": "Pós 50GB", "preco": "R$ 119,90/mês", "descricao": "50GB de internet, ligações ilimitadas, SMS ilimitado, roaming nacional."},
]

planos_pre = [
    {"nome": "Pré 5GB", "preco": "R$ 29,90/mês", "descricao": "5GB de internet, 100 minutos de ligações."},
    {"nome": "Pré 10GB", "preco": "R$ 39,90/mês", "descricao": "10GB de internet, 200 minutos de ligações."},
]

# Menu lateral
menu_opcoes = ("Home", "Planos Pré", "Planos Pós", "Usuário", "Login", "Fale Conosco")
menu = st.sidebar.radio("Menu", menu_opcoes)

# Posta evento no Kafka ao navegar
if menu != "Login":
    post_evento(fixedEvt)

# ==========================
# Telas
# ==========================
if menu == "Home":
    st.title("Operadora de Planos Móveis")
    st.write("Bem-vindo à nossa operadora! Escolha entre planos pós-pagos e pré-pagos.")
    st.image("https://images.unsplash.com/photo-1511707171634-5f897ff02aa9?auto=format&fit=crop&w=800&q=80", caption="Conecte-se com o melhor plano!")

elif menu == "Planos Pré":
    st.header("Planos Pré-Pagos")
    for plano in planos_pre:
        st.subheader(plano["nome"])
        st.write(plano["preco"])
        st.write(plano["descricao"])
        st.markdown("---")

elif menu == "Planos Pós":
    st.header("Planos Pós-Pagos")
    for plano in planos_pos:
        st.subheader(plano["nome"])
        st.write(plano["preco"])
        st.write(plano["descricao"])
        st.markdown("---")

elif menu == "Usuário":
    st.header("Editar Senha do Usuário")
    with st.form("form_editar_senha"):
        usuario = st.text_input("Usuário")
        senha_atual = st.text_input("Senha atual", type="password")
        nova_senha = st.text_input("Nova senha", type="password")
        confirmar_senha = st.text_input("Confirme a nova senha", type="password")
        editar = st.form_submit_button("Alterar Senha")
        if editar:
            if nova_senha != confirmar_senha:
                st.error("A nova senha e a confirmação não coincidem.")
            elif not usuario or not senha_atual or not nova_senha:
                st.error("Preencha todos os campos.")
            else:
                st.success(f"Senha alterada com sucesso para o usuário {usuario}! (Simulação)")

elif menu == "Login":
    st.header("Login do Usuário")
    st.write("Informe seus dados para acessar sua conta.")
    import requests
    with st.form("form_login"):
        usuario = st.text_input("Usuário")
        senha = st.text_input("Senha", type="password")
        logar = st.form_submit_button("Entrar")
        if logar:
            if not usuario or not senha:
                st.error("Preencha todos os campos.")
            else:
                # Chamada à API
                url = f"http://localhost:8080/api/v1/movement/predict?msisdn={numero}&codNumberCurrent={ddd}"
                try:
                    response = requests.get(url)
                    if response.status_code == 200:
                        result = float(response.text.strip())
                        if result == 1.0:
                            st.warning("Faça Biometria para segurança")
                        else:
                            st.success(f"Bem-vindo, {usuario}!")
                    else:
                        st.error("Erro ao consultar API de predição.")
                except Exception as e:
                    st.error(f"Erro na requisição: {e}")
                    
elif menu == "Fale Conosco":
    st.header("Fale Conosco")
    with st.form("form_contato"):
        nome = st.text_input("Nome")
        email = st.text_input("Email")
        plano_interesse = st.selectbox("Plano de interesse", [p["nome"] for p in planos_pos + planos_pre])
        mensagem = st.text_area("Mensagem")
        enviado = st.form_submit_button("Enviar")
        if enviado:
            st.success(f"Obrigado, {nome}! Recebemos sua mensagem sobre o plano {plano_interesse}.")
