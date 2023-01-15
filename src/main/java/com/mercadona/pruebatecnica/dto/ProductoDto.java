package com.mercadona.pruebatecnica.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Builder
@Data
public class ProductoDto {

    @NotNull
    private Long id;

    @NotNull
    @Size(min = 5, max = 5)
    private String codigoProducto;

    private String nombre;

    private Integer cantidad;
}
