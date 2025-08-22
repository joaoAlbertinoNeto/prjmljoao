package com.joao.aclaccessmovement.infrastructure.kafka;

import com.joao.aclaccessmovement.model.rest.AccessMovementApiResponse;
import com.joao.aclaccessmovement.model.rest.AccessMovementResponse;
import com.joao.aclaccessmovement.model.db.AccessMovementRecordDB;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Service para processar eventos de movimento de acesso
 */
@Service
public class AccessMovementEventProcessor {

    private static final Logger logger = LoggerFactory.getLogger(AccessMovementEventProcessor.class);

    /**
     * Processa evento de criação de movimento de acesso
     */
    public void processCreatedEvent(AccessMovementResponse response, Map<String, Object> eventData) {
        logger.info("Processing created event with status: {}", response.getStatus());
        
        // Aqui você pode implementar a lógica de negócio específica
        // Por exemplo: salvar no banco, enviar notificação, atualizar cache, etc.
        
        switch (response.getStatus()) {
            case "created":
                logger.info("Access movement record was successfully created");
                // Implementar lógica de sucesso
                break;
            case "error":
                logger.error("Error occurred during access movement creation");
                // Implementar lógica de erro
                break;
            default:
                logger.warn("Unknown status for access movement creation: {}", response.getStatus());
        }
    }

    /**
     * Processa evento de atualização de movimento de acesso
     */
    public void processUpdatedEvent(AccessMovementApiResponse<AccessMovementRecordDB> response, Map<String, Object> eventData) {
        logger.info("Processing updated event with status: {}", response.getStatus());
        logger.info("Message: {}", response.getMessage());
        
        if (response.getData() != null) {
            logger.info("Updated record ID: {}", response.getData().getId());
            // Implementar lógica específica para o registro atualizado
        }
        
        // Aqui você pode implementar a lógica de negócio específica
        // Por exemplo: atualizar cache, enviar notificação, etc.
    }

    /**
     * Processa evento de exclusão de movimento de acesso
     */
    public void processDeletedEvent(AccessMovementResponse response, Map<String, Object> eventData) {
        logger.info("Processing deleted event with status: {}", response.getStatus());
        
        // Aqui você pode implementar a lógica de negócio específica
        // Por exemplo: limpar cache, enviar notificação, etc.
        
        switch (response.getStatus()) {
            case "success":
                logger.info("Access movement record was successfully deleted");
                // Implementar lógica de sucesso
                break;
            case "error":
                logger.error("Error occurred during access movement deletion");
                // Implementar lógica de erro
                break;
            default:
                logger.warn("Unknown status for access movement deletion: {}", response.getStatus());
        }
    }

    /**
     * Valida se o evento contém dados válidos
     */
    public boolean isValidEvent(Map<String, Object> eventData) {
        if (eventData == null || eventData.isEmpty()) {
            logger.warn("Event data is null or empty");
            return false;
        }
        
        if (!eventData.containsKey("status")) {
            logger.warn("Event data does not contain status field");
            return false;
        }
        
        return true;
    }

    /**
     * Extrai informações úteis do evento
     */
    public void extractEventInfo(Map<String, Object> eventData) {
        logger.info("Event data keys: {}", eventData.keySet());
        
        if (eventData.containsKey("timestamp")) {
            logger.info("Event timestamp: {}", eventData.get("timestamp"));
        }
        
        if (eventData.containsKey("correlationId")) {
            logger.info("Event correlation ID: {}", eventData.get("correlationId"));
        }
        
        if (eventData.containsKey("source")) {
            logger.info("Event source: {}", eventData.get("source"));
        }
    }
}
