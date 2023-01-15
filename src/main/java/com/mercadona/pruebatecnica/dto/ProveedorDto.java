package com.mercadona.pruebatecnica.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ProveedorDto {

    private Long id;

    private String codigoProveedor;

    private String nombre;

}
