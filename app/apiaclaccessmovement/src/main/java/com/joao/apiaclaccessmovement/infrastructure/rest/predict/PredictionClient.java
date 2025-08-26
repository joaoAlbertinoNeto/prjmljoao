package com.joao.apiaclaccessmovement.infrastructure.rest.predict;

import com.joao.apiaclaccessmovement.model.rest.projetojoao.AccessMovementData;
import com.joao.apiaclaccessmovement.model.rest.projetojoao.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "predictionClient", url = "${prediction.service.url}")
public interface PredictionClient {

    @PostMapping("/predict")
    Response predict(@RequestBody AccessMovementData request);
}
