package com.joao.aclaccessmovement.model.rest;

/**
 * Classe de resposta REST para operações de movimento de acesso
 */
public class AccessMovementResponse {
    
    private String status;
    
    // Construtores
    public AccessMovementResponse() {
    }
    
    public AccessMovementResponse(String status) {
        this.status = status;
    }
    
    // Método estático para criar resposta de sucesso
    public static AccessMovementResponse created() {
        return new AccessMovementResponse("created");
    }
    
    public static AccessMovementResponse success() {
        return new AccessMovementResponse("success");
    }
    
    public static AccessMovementResponse error() {
        return new AccessMovementResponse("error");
    }
    
    // Getters e Setters
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    @Override
    public String toString() {
        return "AccessMovementResponse{" +
                "status='" + status + '\'' +
                '}';
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        AccessMovementResponse that = (AccessMovementResponse) o;
        
        return status != null ? status.equals(that.status) : that.status == null;
    }
    
    @Override
    public int hashCode() {
        return status != null ? status.hashCode() : 0;
    }
}
