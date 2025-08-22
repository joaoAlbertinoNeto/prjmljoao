package com.joao.aclaccessmovement.model.ports.in;

import com.joao.aclaccessmovement.model.db.AccessMovementRecordDB;
import com.joao.aclaccessmovement.model.rest.AccessMovementApiResponse;
import com.joao.aclaccessmovement.model.rest.AccessMovementRecordSimple;

public interface HandleAcessMovement{
    public AccessMovementApiResponse<AccessMovementRecordDB> save(AccessMovementRecordSimple movement);
    public Double checkMoove(String msisdn , String codNumberCurrent);
}