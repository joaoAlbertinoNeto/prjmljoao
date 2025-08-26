package com.joao.apiaclaccessmovement.model.map;

import com.joao.apiaclaccessmovement.model.db.AccessMovementRecordDB;
import com.joao.apiaclaccessmovement.model.rest.projetojoao.AccessMovementData;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface AccessMovementMapper {

    // Mapeia lista de AccessMovementRecord para AccessMovementData (threshold não é mapeado)
    @Mapping(target = "threshold", ignore = true)
    AccessMovementData toAccessMovementData(List<AccessMovementRecordDB> records);

    // Apenas mapeia os records de volta, sem threshold
    List<AccessMovementRecordDB> toAccessMovementRecordList(AccessMovementData data);
}
