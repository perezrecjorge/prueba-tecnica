package com.mercadona.pruebatecnica.mapper;

import com.mercadona.pruebatecnica.dto.DestinoDto;
import com.mercadona.pruebatecnica.entity.DestinoEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class DestinoMapper {

    public DestinoDto mapDestinoDtoFromEntity(DestinoEntity destinoEntity) {
        return DestinoDto.builder()
                .id(destinoEntity.getId())
                .codigoDestino(destinoEntity.getCodigoDestino())
                .destino(destinoEntity.getDestino())
                .build();
    }

    public DestinoEntity mapDestinoEntityFromDTO(DestinoDto destinoDto) {
        return DestinoEntity.builder()
                .id(destinoDto.getId())
                .codigoDestino(destinoDto.getCodigoDestino())
                .destino(destinoDto.getDestino())
                .build();
    }

}
