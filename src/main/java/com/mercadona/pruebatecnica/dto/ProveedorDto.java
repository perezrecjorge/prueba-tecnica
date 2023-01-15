package com.mercadona.pruebatecnica.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Builder
@Data
public class ProveedorDto {

    @NotNull
    private Long id;

    @NotNull
    @Size(min = 7, max = 7)
    private String codigoProveedor;

    private String nombre;

}
