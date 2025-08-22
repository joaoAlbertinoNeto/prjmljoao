package com.joao.aclaccessmovement.model.rest;

import java.time.LocalDateTime;

/**
 * Classe de resposta REST mais completa para operações de movimento de acesso
 * Pode incluir dados, mensagens e timestamps
 */
public class AccessMovementApiResponse<T> {
    
    private String status;
    private String message;
    private T data;
    private LocalDateTime timestamp;
    
    // Construtores
    public AccessMovementApiResponse() {
        this.timestamp = LocalDateTime.now();
    }
    
    public AccessMovementApiResponse(String status) {
        this();
        this.status = status;
    }
    
    public AccessMovementApiResponse(String status, String message) {
        this(status);
        this.message = message;
    }
    
    public AccessMovementApiResponse(String status, String message, T data) {
        this(status, message);
        this.data = data;
    }
    
    // Métodos estáticos para criar respostas comuns
    public static <T> AccessMovementApiResponse<T> created() {
        return new AccessMovementApiResponse<>("created", "Registro criado com sucesso");
    }
    
    public static <T> AccessMovementApiResponse<T> created(T data) {
        return new AccessMovementApiResponse<>("created", "Registro criado com sucesso", data);
    }
    
    public static <T> AccessMovementApiResponse<T> success() {
        return new AccessMovementApiResponse<>("success", "Operação realizada com sucesso");
    }
    
    public static <T> AccessMovementApiResponse<T> success(T data) {
        return new AccessMovementApiResponse<>("success", "Operação realizada com sucesso", data);
    }
    
    public static <T> AccessMovementApiResponse<T> error(String message) {
        return new AccessMovementApiResponse<>("error", message);
    }
    
    public static <T> AccessMovementApiResponse<T> notFound() {
        return new AccessMovementApiResponse<>("error", "Registro não encontrado");
    }
    
    public static <T> AccessMovementApiResponse<T> validationError(String message) {
        return new AccessMovementApiResponse<>("error", "Erro de validação: " + message);
    }
    
    // Getters e Setters
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
    public T getData() {
        return data;
    }
    
    public void setData(T data) {
        this.data = data;
    }
    
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
    
    @Override
    public String toString() {
        return "AccessMovementApiResponse{" +
                "status='" + status + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                ", timestamp=" + timestamp +
                '}';
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        AccessMovementApiResponse<?> that = (AccessMovementApiResponse<?>) o;
        
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (message != null ? !message.equals(that.message) : that.message != null) return false;
        if (data != null ? !data.equals(that.data) : that.data != null) return false;
        return timestamp != null ? timestamp.equals(that.timestamp) : that.timestamp == null;
    }
    
    @Override
    public int hashCode() {
        int result = status != null ? status.hashCode() : 0;
        result = 31 * result + (message != null ? message.hashCode() : 0);
        result = 31 * result + (data != null ? data.hashCode() : 0);
        result = 31 * result + (timestamp != null ? timestamp.hashCode() : 0);
        return result;
    }
}
