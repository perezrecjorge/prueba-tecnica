package com.mercadona.pruebatecnica.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class SalidaConsultaEAN {

    private ProductoDto producto;

    private ProveedorDto proveedor;

    private DestinoDto destino;

}
