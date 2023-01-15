package com.mercadona.pruebatecnica.mapper;

import com.mercadona.pruebatecnica.dto.ProductoDto;
import com.mercadona.pruebatecnica.entity.ProductoEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ProductoMapper {

    public ProductoDto mapProductoDtoFromEntity(ProductoEntity productoEntity) {
        return ProductoDto.builder()
                .id(productoEntity.getId())
                .codigoProducto(productoEntity.getCodigoProducto())
                .nombre(productoEntity.getNombre())
                .cantidad(productoEntity.getCantidad())
                .build();
    }

    public ProductoEntity mapProductoEntityFromDTO(ProductoDto productoDto) {
        return ProductoEntity.builder()
                .id(productoDto.getId())
                .codigoProducto(productoDto.getCodigoProducto())
                .nombre(productoDto.getNombre())
                .cantidad(productoDto.getCantidad())
                .build();
    }

}
