package com.joao.apiaclaccessmovement.infrastructure.db;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.joao.apiaclaccessmovement.model.db.AccessMovementRecordDB;

@Repository
public interface MovementRespository extends JpaRepository<AccessMovementRecordDB,Long> {

    public List<AccessMovementRecordDB> findAllByMsisdnAndCodigoNacional(String msisdn , Integer codigoNacional);
    
}
