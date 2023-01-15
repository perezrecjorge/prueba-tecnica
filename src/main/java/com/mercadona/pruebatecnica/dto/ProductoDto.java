package com.mercadona.pruebatecnica.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ProductoDto {

    private Long id;

    private String codigoProducto;

    private String nombre;

    private Integer cantidad;
}
