package com.joao.apiaclaccessmovement.model.rest.projetojoao;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class Response {
    private List<Integer> predictions;
    private List<Double> probabilities;

    @JsonProperty("applied_threshold")
    private Double appliedThreshold;
}