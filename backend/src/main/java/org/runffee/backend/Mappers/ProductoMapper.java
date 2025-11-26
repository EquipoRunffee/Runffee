package org.runffee.backend.Mappers;

import org.mapstruct.Mapper;
import org.runffee.backend.DTO.ListaProductoDTO;
import org.runffee.backend.modelos.Producto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductoMapper {
    List<ListaProductoDTO> ProductoToListDTO(List<Producto> producto);
}
