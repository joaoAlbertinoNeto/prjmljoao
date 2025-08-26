package com.joao.apiaclaccessmovement.infrastructure.rest;

import com.joao.apiaclaccessmovement.application.ServiceMovement;
import com.joao.apiaclaccessmovement.model.rest.AccessMovementApiResponse;
import com.joao.apiaclaccessmovement.model.rest.AccessMovementRecordSimple;
import com.joao.apiaclaccessmovement.model.db.AccessMovementRecordDB;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/movement")
@RequiredArgsConstructor
public class AccessMovementController {

    @Autowired
    private  ServiceMovement service;

    @PostMapping
    public ResponseEntity<AccessMovementApiResponse<AccessMovementRecordDB>> save(
            @RequestBody AccessMovementRecordSimple movement) {
        var response = service.save(movement);
        if (response == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(response);
    }

    @GetMapping("/predict")
    public ResponseEntity<Double> predict(
            @RequestParam String msisdn,
            @RequestParam String codNumberCurrent) {
        var probability = service.checkMoove(msisdn, codNumberCurrent);
        return ResponseEntity.ok(probability);
    }
}
