package com.mercadona.pruebatecnica.mapper;

import com.mercadona.pruebatecnica.dto.ProveedorDto;
import com.mercadona.pruebatecnica.entity.ProveedorEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ProveedorMapper {

    public ProveedorDto mapProveedorDtoFromEntity(ProveedorEntity proveedorEntity) {
        return ProveedorDto.builder()
                .id(proveedorEntity.getId())
                .codigoProveedor(proveedorEntity.getCodigoProveedor())
                .nombre(proveedorEntity.getNombre())
                .build();
    }

    public ProveedorEntity mapProveedorEntityFromDTO(ProveedorDto proveedorDto) {
        return ProveedorEntity.builder()
                .id(proveedorDto.getId())
                .codigoProveedor(proveedorDto.getCodigoProveedor())
                .nombre(proveedorDto.getNombre())
                .build();
    }

}
