package com.joao.apiaclaccessmovement.model.rest;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Modelo simples que representa um registro de movimento de acesso
 * Baseado nos dados fornecidos pela Anatel
 */
public class AccessMovementRecordSimple {

    private Long id;

    @JsonProperty("tipo_produto")
    private String tipoProduto;

    @JsonProperty("tipo_pessoa")
    private String tipoPessoa;


    private Integer mes;
    private BigDecimal populacaoEstimadaNumerica2;
    private String uf;
    private String empresa;
    private String tecnologiaGeracao;
    private String modalidadeCobranca;
    private BigDecimal populacaoEstimadaNumerica;
    private String grupoEconomico;
    private String populacaoEstimada;
    private String municipio;
    private Long codigoIbgeMunicipio;
    private BigDecimal latitude;
    private String cnpj;
    private String portePrestadora;
    private BigDecimal longitude;
    private String tecnologia;
    private Long acessos;
    private BigDecimal populacaoEstimadaNumerica3;
    private Integer codigoNacional;
    private Integer codigoNacionalChip;
    private Integer ano;
    private String msisdn;

    // Construtores
    public AccessMovementRecordSimple() {
    }

    public AccessMovementRecordSimple(String tipoProduto, String tipoPessoa, Integer mes, 
                                     BigDecimal populacaoEstimadaNumerica2, String uf, String empresa,
                                     String tecnologiaGeracao, String modalidadeCobranca,
                                     BigDecimal populacaoEstimadaNumerica, String grupoEconomico,
                                     String populacaoEstimada, String municipio, Long codigoIbgeMunicipio,
                                     BigDecimal latitude, String cnpj, String portePrestadora,
                                     BigDecimal longitude, String tecnologia, Long acessos,
                                     BigDecimal populacaoEstimadaNumerica3, Integer codigoNacional,
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
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public BigDecimal getPopulacaoEstimadaNumerica2() {
        return populacaoEstimadaNumerica2;
    }

    public void setPopulacaoEstimadaNumerica2(BigDecimal populacaoEstimadaNumerica2) {
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

    public BigDecimal getPopulacaoEstimadaNumerica() {
        return populacaoEstimadaNumerica;
    }

    public void setPopulacaoEstimadaNumerica(BigDecimal populacaoEstimadaNumerica) {
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

    public Long getCodigoIbgeMunicipio() {
        return codigoIbgeMunicipio;
    }

    public void setCodigoIbgeMunicipio(Long codigoIbgeMunicipio) {
        this.codigoIbgeMunicipio = codigoIbgeMunicipio;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
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

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public String getTecnologia() {
        return tecnologia;
    }

    public void setTecnologia(String tecnologia) {
        this.tecnologia = tecnologia;
    }

    public Long getAcessos() {
        return acessos;
    }

    public void setAcessos(Long acessos) {
        this.acessos = acessos;
    }

    public BigDecimal getPopulacaoEstimadaNumerica3() {
        return populacaoEstimadaNumerica3;
    }

    public void setPopulacaoEstimadaNumerica3(BigDecimal populacaoEstimadaNumerica3) {
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
        return "AccessMovementRecordSimple{" +
                "id=" + id +
                ", tipoProduto='" + tipoProduto + '\'' +
                ", tipoPessoa='" + tipoPessoa + '\'' +
                ", mes=" + mes +
                ", uf='" + uf + '\'' +
                ", empresa='" + empresa + '\'' +
                ", tecnologiaGeracao='" + tecnologiaGeracao + '\'' +
                ", modalidadeCobranca='" + modalidadeCobranca + '\'' +
                ", grupoEconomico='" + grupoEconomico + '\'' +
                ", municipio='" + municipio + '\'' +
                ", codigoIbgeMunicipio=" + codigoIbgeMunicipio +
                ", cnpj='" + cnpj + '\'' +
                ", portePrestadora='" + portePrestadora + '\'' +
                ", tecnologia='" + tecnologia + '\'' +
                ", acessos=" + acessos +
                ", codigoNacional=" + codigoNacional +
                ", codigoNacionalChip=" + codigoNacionalChip +
                ", ano=" + ano +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccessMovementRecordSimple that = (AccessMovementRecordSimple) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (tipoProduto != null ? !tipoProduto.equals(that.tipoProduto) : that.tipoProduto != null) return false;
        if (tipoPessoa != null ? !tipoPessoa.equals(that.tipoPessoa) : that.tipoPessoa != null) return false;
        if (mes != null ? !mes.equals(that.mes) : that.mes != null) return false;
        if (uf != null ? !uf.equals(that.uf) : that.uf != null) return false;
        if (empresa != null ? !empresa.equals(that.empresa) : that.empresa != null) return false;
        if (cnpj != null ? !cnpj.equals(that.cnpj) : that.cnpj != null) return false;
        if (codigoIbgeMunicipio != null ? !codigoIbgeMunicipio.equals(that.codigoIbgeMunicipio) : that.codigoIbgeMunicipio != null) return false;
        if (codigoNacional != null ? !codigoNacional.equals(that.codigoNacional) : that.codigoNacional != null) return false;
        if (codigoNacionalChip != null ? !codigoNacionalChip.equals(that.codigoNacionalChip) : that.codigoNacionalChip != null) return false;
        return ano != null ? ano.equals(that.ano) : that.ano == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (tipoProduto != null ? tipoProduto.hashCode() : 0);
        result = 31 * result + (tipoPessoa != null ? tipoPessoa.hashCode() : 0);
        result = 31 * result + (mes != null ? mes.hashCode() : 0);
        result = 31 * result + (uf != null ? uf.hashCode() : 0);
        result = 31 * result + (empresa != null ? empresa.hashCode() : 0);
        result = 31 * result + (cnpj != null ? cnpj.hashCode() : 0);
        result = 31 * result + (codigoIbgeMunicipio != null ? codigoIbgeMunicipio.hashCode() : 0);
        result = 31 * result + (codigoNacional != null ? codigoNacional.hashCode() : 0);
        result = 31 * result + (codigoNacionalChip != null ? codigoNacionalChip.hashCode() : 0);
        result = 31 * result + (ano != null ? ano.hashCode() : 0);
        return result;
    }
}
