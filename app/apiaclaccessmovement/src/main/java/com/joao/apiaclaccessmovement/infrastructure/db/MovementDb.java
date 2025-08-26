package com.joao.apiaclaccessmovement.infrastructure.db;

import java.util.List;
import java.util.logging.Logger;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.joao.apiaclaccessmovement.model.db.AccessMovementRecordDB;
import com.joao.apiaclaccessmovement.model.ports.out.HandleMovementDb;

import lombok.extern.slf4j.Slf4j;


@Component
public class MovementDb implements HandleMovementDb {



    @Autowired
    private MovementRespository movementRespository;

    @Override
    public void save(AccessMovementRecordDB accessMovementRecord) {
        try{
            var saved = movementRespository.save(accessMovementRecord);
            System.out.println("saved object : "+saved);
        }catch(Exception e){
            System.err.println("Catch some err: {}"+e.getLocalizedMessage());
        }
    }

    @Override
    public List<AccessMovementRecordDB> findByMsisdn(String msisdn, String codNumberCurrent) {
        return movementRespository.findAllByMsisdnAndCodigoNacional(msisdn , Integer.parseInt(codNumberCurrent));
    }
    
}