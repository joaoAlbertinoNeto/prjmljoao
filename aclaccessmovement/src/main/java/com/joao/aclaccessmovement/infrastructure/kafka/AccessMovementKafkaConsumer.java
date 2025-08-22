package com.joao.aclaccessmovement.infrastructure.kafka;

import com.joao.aclaccessmovement.model.rest.AccessMovementResponse;

import com.joao.aclaccessmovement.application.ServiceMovement;
import com.joao.aclaccessmovement.model.db.AccessMovementRecordDB;
import com.joao.aclaccessmovement.model.ports.out.HandleMovementDb;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.joao.aclaccessmovement.model.rest.projetojoao.AccessMovementRecordRest;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Consumer Kafka para processar eventos de movimento de acesso
 */
@Component
public class AccessMovementKafkaConsumer {

    @Autowired
    private ServiceMovement movementService;

    private static final Logger logger = LoggerFactory.getLogger(AccessMovementKafkaConsumer.class);

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private HandleMovementDb handlerDb;

    /**
     * Consumer para eventos de criação de movimento de acesso
     */
    @KafkaListener(
            topics = "${kafka.topics.access-movement-created}",
            groupId = "${kafka.consumer.group-id}",
            containerFactory = "kafkaListenerContainerFactory"
    )
    public void handleAccessMovementCreated(
            @Payload String message,
            @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
            @Header(KafkaHeaders.RECEIVED_PARTITION) int partition,
            @Header(KafkaHeaders.OFFSET) long offset) {
        
        logger.info("Received message from topic: {}, partition: {}, offset: {}", topic, partition, offset);
        logger.info("Message content: {}", message);

        try {
            // Deserializar a mensagem para um Map


            var eventData = objectMapper.readValue(message, AccessMovementRecordRest.class);
            
            // Processar o evento
            processAccessMovementCreated( eventData);
            
            logger.info("Successfully processed access movement created event", eventData);
            
        } catch (JsonProcessingException e) {
            logger.error("Error deserializing message: {}", e.getMessage(), e);
        } catch (Exception e) {
            logger.error("Error processing access movement created event: {}", e.getMessage(), e);
        }
    }

    /**
     * Mapeia os dados do evento para AccessMovementResponse
     */
    private AccessMovementResponse mapToAccessMovementResponse(Map<String, Object> eventData) {
        String status = (String) eventData.get("status");
        return new AccessMovementResponse(status);
    }

    /**
     * Processa evento de criação
     */
    private void processAccessMovementCreated( AccessMovementRecordRest eventData) {
    
        var dbRecord = modelMapper.map(eventData, AccessMovementRecordDB.class);
        handlerDb.save(dbRecord);
       
    }
}

