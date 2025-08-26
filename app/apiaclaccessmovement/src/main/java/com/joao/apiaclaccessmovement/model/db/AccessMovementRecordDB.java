package com.joao.apiaclaccessmovement.model.db;

import jakarta.persistence.*;
import java.math.BigDecimal;

/**
 * Entidade que representa um registro de movimento de acesso
 * Baseado nos dados fornecidos pela Anatel
 */
@Entity
@Table(name = "access_movement_records")
public class AccessMovementRecordDB {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tipo_produto", nullable = false)
    private String tipoProduto;

    @Column(name = "tipo_pessoa", nullable = false)
    private String tipoPessoa;

    @Column(name = "mes", nullable = false)
    private Integer mes;

    @Column(name = "populacao_estimada_numerica2", precision = 15, scale = 2)
    private BigDecimal populacaoEstimadaNumerica2;

    @Column(name = "uf", length = 2, nullable = false)
    private String uf;

    @Column(name = "empresa", nullable = false)
    private String empresa;

    @Column(name = "tecnologia_geracao", nullable = false)
    private String tecnologiaGeracao;

    @Column(name = "modalidade_cobranca", nullable = false)
    private String modalidadeCobranca;

    @Column(name = "populacao_estimada_numerica", precision = 15, scale = 2)
    private BigDecimal populacaoEstimadaNumerica;

    @Column(name = "grupo_economico", nullable = false)
    private String grupoEconomico;

    @Column(name = "populacao_estimada")
    private String populacaoEstimada;

    @Column(name = "municipio", nullable = false)
    private String municipio;

    @Column(name = "codigo_ibge_municipio", nullable = false)
    private Integer codigoIbgeMunicipio;

    @Column(name = "latitude", precision = 10, scale = 6)
    private BigDecimal latitude;

    @Column(name = "cnpj", length = 14, nullable = false)
    private String cnpj;

    @Column(name = "porte_prestadora", nullable = false)
    private String portePrestadora;

    @Column(name = "longitude", precision = 10, scale = 6)
    private BigDecimal longitude;

    @Column(name = "tecnologia", nullable = false)
    private String tecnologia;

    @Column(name = "acessos", nullable = false)
    private Integer acessos;

    @Column(name = "populacao_estimada_numerica3", precision = 15, scale = 2)
    private BigDecimal populacaoEstimadaNumerica3;

    @Column(name = "codigo_nacional", nullable = false)
    private Integer codigoNacional;

    @Column(name = "codigo_nacional_chip", nullable = false)
    private Integer codigoNacionalChip;

    @Column(name = "ano", nullable = false)
    private Integer ano;

    @Column(name = "msisdn", nullable = false)
    private String msisdn;

    public AccessMovementRecordDB(){

    }

   

    public AccessMovementRecordDB(String tipoProduto, String tipoPessoa, Integer mes,
                                  BigDecimal populacaoEstimadaNumerica2, String uf, String empresa,
                                  String tecnologiaGeracao, String modalidadeCobranca,
                                  BigDecimal populacaoEstimadaNumerica, String grupoEconomico,
                                  String populacaoEstimada, String municipio, Integer codigoIbgeMunicipio,
                                  BigDecimal latitude, String cnpj, String portePrestadora,
                                  BigDecimal longitude, String tecnologia, Integer acessos,
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
        this.msisdn = msisdn;
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

    public Integer getCodigoIbgeMunicipio() {
        return codigoIbgeMunicipio;
    }

    public void setCodigoIbgeMunicipio(Integer codigoIbgeMunicipio) {
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

    public Integer getAcessos() {
        return acessos;
    }

    public void setAcessos(Integer acessos) {
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
        return "AccessMovementRecord{" +
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

        AccessMovementRecordDB that = (AccessMovementRecordDB) o;

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
