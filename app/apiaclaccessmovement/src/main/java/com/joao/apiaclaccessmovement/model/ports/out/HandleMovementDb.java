 package com.joao.apiaclaccessmovement.model.ports.out;

import java.util.List;

import com.joao.apiaclaccessmovement.model.db.AccessMovementRecordDB;

public interface HandleMovementDb {

    public void save (AccessMovementRecordDB accessMovementRecord) ;
    public List<AccessMovementRecordDB> findByMsisdn (String msisdn, String codNumberCurrent) ;
 }