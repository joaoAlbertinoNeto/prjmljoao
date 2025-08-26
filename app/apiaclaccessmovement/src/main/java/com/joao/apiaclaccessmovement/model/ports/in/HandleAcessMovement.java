package com.joao.apiaclaccessmovement.model.ports.in;

import com.joao.apiaclaccessmovement.model.db.AccessMovementRecordDB;
import com.joao.apiaclaccessmovement.model.rest.AccessMovementApiResponse;
import com.joao.apiaclaccessmovement.model.rest.AccessMovementRecordSimple;

public interface HandleAcessMovement{
    public AccessMovementApiResponse<AccessMovementRecordDB> save(AccessMovementRecordSimple movement);
    public Double checkMoove(String msisdn , String codNumberCurrent);
}