package com.joao.apiaclaccessmovement.model.rest.projetojoao;

import java.util.List;

/**
 * Classe que representa a estrutura principal de dados de movimento de acesso
 * Contém a lista de registros e o threshold
 */
public class AccessMovementData {
    
    private List<AccessMovementRecordRest> records;
    private Double threshold;
    
    // Construtor padrão
    public AccessMovementData() {}
    
    // Construtor com todos os campos
    public AccessMovementData(List<AccessMovementRecordRest> records, Double threshold) {
        this.records = records;
        this.threshold = threshold;
    }
    
    // Getters e Setters
    public List<AccessMovementRecordRest> getRecords() {
        return records;
    }
    
    public void setRecords(List<AccessMovementRecordRest> records) {
        this.records = records;
    }
    
    public Double getThreshold() {
        return threshold;
    }
    
    public void setThreshold(Double threshold) {
        this.threshold = threshold;
    }
    
    @Override
    public String toString() {
        return "AccessMovementData{" +
                "records=" + records +
                ", threshold=" + threshold +
                '}';
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        AccessMovementData that = (AccessMovementData) o;
        
        if (records != null ? !records.equals(that.records) : that.records != null) return false;
        return threshold != null ? threshold.equals(that.threshold) : that.threshold == null;
    }
    
    @Override
    public int hashCode() {
        int result = records != null ? records.hashCode() : 0;
        result = 31 * result + (threshold != null ? threshold.hashCode() : 0);
        return result;
    }
}
