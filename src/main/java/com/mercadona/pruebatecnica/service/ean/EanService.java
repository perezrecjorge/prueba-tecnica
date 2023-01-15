package com.mercadona.pruebatecnica.service.ean;

import com.mercadona.pruebatecnica.dto.SalidaConsultaEAN;

public interface EanService {

    SalidaConsultaEAN getInfoByEAN(String codigoEAN);

}
