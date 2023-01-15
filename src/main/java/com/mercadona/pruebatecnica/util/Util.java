package com.mercadona.pruebatecnica.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Util {

    public String obtenerCodigoProveedorFromEAN(String codigoEAN) {
        return codigoEAN.substring(0, 7);
    }

    public String obtenerCodigoProductoFromEAN(String codigoEAN) {
        return codigoEAN.substring(7, 12);
    }

    public String obtenerCodigoDestinoFromEAN(String codigoEAN) {
        return codigoEAN.substring(12);
    }
}
