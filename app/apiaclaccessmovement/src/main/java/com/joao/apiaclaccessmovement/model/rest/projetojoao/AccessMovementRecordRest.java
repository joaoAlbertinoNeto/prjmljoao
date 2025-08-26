package com.joao.apiaclaccessmovement.model.rest.projetojoao;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;


public class AccessMovementRecordRest {

    @JsonAlias("tipo_produto")
    @JsonProperty("tipo_produto")
    private String tipoProduto;


    @JsonAlias("tipo_pessoa")
    @JsonProperty("tipo_pessoa")
    private String tipoPessoa;
    
    private Integer mes;

    @JsonAlias("populacao_estimada_numerica2")
    @JsonProperty("populacao_estimada_numerica2")
    private Double populacaoEstimadaNumerica2;
    
    private String uf;
    private String empresa;
    
    @JsonProperty("tecnologia_geracao")
    private String tecnologiaGeracao;
    
    @JsonProperty("modalidade_cobranca")
    private String modalidadeCobranca;
    
    @JsonProperty("populacao_estimada_numerica")
    private Double populacaoEstimadaNumerica;
    
    @JsonProperty("grupo_economico")
    private String grupoEconomico;
    
    @JsonProperty("populacao_estimada")
    private String populacaoEstimada;
    
    private String municipio;
    
    @JsonProperty("codigo_ibge_municipio")
    private Integer codigoIbgeMunicipio;
    
    private Double latitude;
    private String cnpj;
    
    @JsonProperty("porte_prestadora")
    private String portePrestadora;
    
    private Double longitude;
    private String tecnologia;
    private Integer acessos;
    
    @JsonProperty("populacao_estimada_numerica3")
    private Double populacaoEstimadaNumerica3;
    
    @JsonProperty("codigo_nacional")
    private Integer codigoNacional;
    
    @JsonProperty("codigo_nacional_chip")
    private Integer codigoNacionalChip;
    
    private Integer ano;

    private String msisdn;
    
    // Construtor padrão
    public AccessMovementRecordRest() {}
    
    // Construtor com todos os campos
    public AccessMovementRecordRest(String tipoProduto, String tipoPessoa, Integer mes,
                                    Double populacaoEstimadaNumerica2, String uf, String empresa,
                                    String tecnologiaGeracao, String modalidadeCobranca,
                                    Double populacaoEstimadaNumerica, String grupoEconomico,
                                    String populacaoEstimada, String municipio, Integer codigoIbgeMunicipio,
                                    Double latitude, String cnpj, String portePrestadora,
                                    Double longitude, String tecnologia, Integer acessos,
                                    Double populacaoEstimadaNumerica3, Integer codigoNacional,
                                    Integer codigoNacionalChip, Integer ano , String msisdn) {
        this.tipoProduto = tipoProduto;
        this.tipoPessoa = tipoPessoa;
        this.mes = mes;
        this.populacaoEstimadaNumerica2 = populacaoEstimadaNumerica2;
        this.uf = uf;
        this.empresa = empresa;
        this.tecnologiaGeracao = tecnologiaGeracao;
        this.modalidadeCobranca = modalidadeCobranca;
        this.populacaoEstimadaNumerica = populacaoEstimadaNumerica;
        this.grupoEconomico = grupoEconomico;
        this.populacaoEstimada = populacaoEstimada;
        this.municipio = municipio;
        this.codigoIbgeMunicipio = codigoIbgeMunicipio;
        this.latitude = latitude;
        this.cnpj = cnpj;
        this.portePrestadora = portePrestadora;
        this.longitude = longitude;
        this.tecnologia = tecnologia;
        this.acessos = acessos;
        this.populacaoEstimadaNumerica3 = populacaoEstimadaNumerica3;
        this.codigoNacional = codigoNacional;
        this.codigoNacionalChip = codigoNacionalChip;
        this.ano = ano;
        this.msisdn = msisdn;
    }
    
    // Getters e Setters
    public String getTipoProduto() {
        return tipoProduto;
    }
    
    public void setTipoProduto(String tipoProduto) {
        this.tipoProduto = tipoProduto;
    }
    
    public String getTipoPessoa() {
        return tipoPessoa;
    }
    
    public void setTipoPessoa(String tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }
    
    public Integer getMes() {
        return mes;
    }
    
    public void setMes(Integer mes) {
        this.mes = mes;
    }
    
    public Double getPopulacaoEstimadaNumerica2() {
        return populacaoEstimadaNumerica2;
    }
    
    public void setPopulacaoEstimadaNumerica2(Double populacaoEstimadaNumerica2) {
        this.populacaoEstimadaNumerica2 = populacaoEstimadaNumerica2;
    }
    
    public String getUf() {
        return uf;
    }
    
    public void setUf(String uf) {
        this.uf = uf;
    }
    
    public String getEmpresa() {
        return empresa;
    }
    
    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }
    
    public String getTecnologiaGeracao() {
        return tecnologiaGeracao;
    }
    
    public void setTecnologiaGeracao(String tecnologiaGeracao) {
        this.tecnologiaGeracao = tecnologiaGeracao;
    }
    
    public String getModalidadeCobranca() {
        return modalidadeCobranca;
    }
    
    public void setModalidadeCobranca(String modalidadeCobranca) {
        this.modalidadeCobranca = modalidadeCobranca;
    }
    
    public Double getPopulacaoEstimadaNumerica() {
        return populacaoEstimadaNumerica;
    }
    
    public void setPopulacaoEstimadaNumerica(Double populacaoEstimadaNumerica) {
        this.populacaoEstimadaNumerica = populacaoEstimadaNumerica;
    }
    
    public String getGrupoEconomico() {
        return grupoEconomico;
    }
    
    public void setGrupoEconomico(String grupoEconomico) {
        this.grupoEconomico = grupoEconomico;
    }
    
    public String getPopulacaoEstimada() {
        return populacaoEstimada;
    }
    
    public void setPopulacaoEstimada(String populacaoEstimada) {
        this.populacaoEstimada = populacaoEstimada;
    }
    
    public String getMunicipio() {
        return municipio;
    }
    
    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }
    
    public Integer getCodigoIbgeMunicipio() {
        return codigoIbgeMunicipio;
    }
    
    public void setCodigoIbgeMunicipio(Integer codigoIbgeMunicipio) {
        this.codigoIbgeMunicipio = codigoIbgeMunicipio;
    }
    
    public Double getLatitude() {
        return latitude;
    }
    
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }
    
    public String getCnpj() {
        return cnpj;
    }
    
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    
    public String getPortePrestadora() {
        return portePrestadora;
    }
    
    public void setPortePrestadora(String portePrestadora) {
        this.portePrestadora = portePrestadora;
    }
    
    public Double getLongitude() {
        return longitude;
    }
    
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
    
    public String getTecnologia() {
        return tecnologia;
    }
    
    public void setTecnologia(String tecnologia) {
        this.tecnologia = tecnologia;
    }
    
    public Integer getAcessos() {
        return acessos;
    }
    
    public void setAcessos(Integer acessos) {
        this.acessos = acessos;
    }
    
    public Double getPopulacaoEstimadaNumerica3() {
        return populacaoEstimadaNumerica3;
    }
    
    public void setPopulacaoEstimadaNumerica3(Double populacaoEstimadaNumerica3) {
        this.populacaoEstimadaNumerica3 = populacaoEstimadaNumerica3;
    }
    
    public Integer getCodigoNacional() {
        return codigoNacional;
    }
    
    public void setCodigoNacional(Integer codigoNacional) {
        this.codigoNacional = codigoNacional;
    }
    
    public Integer getCodigoNacionalChip() {
        return codigoNacionalChip;
    }
    
    public void setCodigoNacionalChip(Integer codigoNacionalChip) {
        this.codigoNacionalChip = codigoNacionalChip;
    }
    
    public Integer getAno() {
        return ano;
    }
    
    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }
    
    @Override
    public String toString() {
        return "AccessMovementRecord{" +
                "tipoProduto='" + tipoProduto + '\'' +
                ", tipoPessoa='" + tipoPessoa + '\'' +
                ", mes=" + mes +
                ", populacaoEstimadaNumerica2=" + populacaoEstimadaNumerica2 +
                ", uf='" + uf + '\'' +
                ", empresa='" + empresa + '\'' +
                ", tecnologiaGeracao='" + tecnologiaGeracao + '\'' +
                ", modalidadeCobranca='" + modalidadeCobranca + '\'' +
                ", populacaoEstimadaNumerica=" + populacaoEstimadaNumerica +
                ", grupoEconomico='" + grupoEconomico + '\'' +
                ", populacaoEstimada='" + populacaoEstimada + '\'' +
                ", municipio='" + municipio + '\'' +
                ", codigoIbgeMunicipio=" + codigoIbgeMunicipio +
                ", latitude=" + latitude +
                ", cnpj='" + cnpj + '\'' +
                ", portePrestadora='" + portePrestadora + '\'' +
                ", longitude=" + longitude +
                ", tecnologia='" + tecnologia + '\'' +
                ", acessos=" + acessos +
                ", populacaoEstimadaNumerica3=" + populacaoEstimadaNumerica3 +
                ", codigoNacional=" + codigoNacional +
                ", codigoNacionalChip=" + codigoNacionalChip +
                ", ano=" + ano +
                '}';
    }
    

}
