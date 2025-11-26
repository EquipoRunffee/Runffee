package org.runffee.backend.Mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.runffee.backend.DTO.CafeteriaProductosDTO;
import org.runffee.backend.modelos.Cafeteria;

@Mapper(componentModel = "spring")
public interface CafeteriaMapper {
    CafeteriaProductosDTO toDTO(Cafeteria cafeteria);
}
