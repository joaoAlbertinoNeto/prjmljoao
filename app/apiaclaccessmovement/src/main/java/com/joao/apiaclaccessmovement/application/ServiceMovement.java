package com.joao.apiaclaccessmovement.application;

import com.joao.apiaclaccessmovement.infrastructure.rest.predict.PredictionClient;
import com.joao.apiaclaccessmovement.model.rest.projetojoao.AccessMovementRecordRest;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.joao.apiaclaccessmovement.model.db.AccessMovementRecordDB;
import com.joao.apiaclaccessmovement.model.ports.in.HandleAcessMovement;
import com.joao.apiaclaccessmovement.model.ports.out.HandleMovementDb;
import com.joao.apiaclaccessmovement.model.rest.AccessMovementApiResponse;
import com.joao.apiaclaccessmovement.model.rest.AccessMovementRecordSimple;
import com.joao.apiaclaccessmovement.model.rest.projetojoao.AccessMovementData;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class ServiceMovement implements  HandleAcessMovement{

    private final HandleMovementDb handlerDb;

    private final ModelMapper mapper;

    //private final AccessMovementMapper mapperInstruct;

    private final PredictionClient predictionClient;

    @Override
    public AccessMovementApiResponse<AccessMovementRecordDB> save(AccessMovementRecordSimple movement) {
        try{
            var record = mapper.map(movement, AccessMovementRecordDB.class);
            handlerDb.save(record);
            return AccessMovementApiResponse.created(record);
        }catch(Exception e){
            System.err.println("Catch some err : {}"+e.getLocalizedMessage());
        }
        return null;
    }

    @Override
    public Double checkMoove(String msisdn , String codNumberCurrent) {

        try {
            var list = handlerDb.findByMsisdn(msisdn, codNumberCurrent);
            var accessCount = 0;
            for (AccessMovementRecordDB record : list) {
                accessCount += 1;
            }

            var recordItem = list.get(0);
            recordItem.setAcessos(accessCount);


            var recordRequest = mapper.map(recordItem, AccessMovementRecordRest.class);

            var data = new AccessMovementData();
            data.setRecords(List.of(recordRequest));
            data.setThreshold(0.2); 


            var responsePredict = predictionClient.predict(data);
            return responsePredict.getProbabilities().get(0);

            //return (double) 0;
        }catch (Exception e){
            System.err.println("Catch some err : {} "+e.getLocalizedMessage());
        }
        return (double) 1;

    }

}