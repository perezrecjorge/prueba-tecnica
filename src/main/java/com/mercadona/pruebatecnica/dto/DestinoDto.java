package com.mercadona.pruebatecnica.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class DestinoDto {

    private Long id;

    private String codigoDestino;

    private String destino;

    private String ciudad;

}
