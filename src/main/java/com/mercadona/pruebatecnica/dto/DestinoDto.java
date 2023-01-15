package com.mercadona.pruebatecnica.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Builder
@Data
public class DestinoDto {

    @NotNull
    private Long id;

    @NotNull
    @Size(min = 1, max = 1)
    private String codigoDestino;

    private String destino;

}
