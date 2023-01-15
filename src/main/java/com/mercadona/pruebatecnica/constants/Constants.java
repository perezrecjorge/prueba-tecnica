package com.mercadona.pruebatecnica.constants;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Constants {

    @UtilityClass
    public class Endpoint {

        private final String ID = "/{id}";
        public final String API_VERSION = "/v1";

        @UtilityClass
        public class Producto {
            public final String PRODUCTOS = API_VERSION + "/productos";
            public final String PRODUCTOS_ID = ID;
        }

        @UtilityClass
        public class Destino {
            public final String DESTINOS = API_VERSION + "/destinos";
            public final String DESTINOS_ID = ID;
        }

        @UtilityClass
        public class Proveedor {
            public final String PROVEEDORES = API_VERSION + "/proveedores";
            public final String PROVEEDOR_ID = ID;
        }

        @UtilityClass
        public class EAN {
            public final String EAN = API_VERSION + "/ean";
            public final String EAN_ID = "/{codigoEAN}";
        }

    }
}
