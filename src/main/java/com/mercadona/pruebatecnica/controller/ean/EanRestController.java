package com.mercadona.pruebatecnica.controller.ean;

import com.mercadona.pruebatecnica.dto.SalidaConsultaEAN;
import com.mercadona.pruebatecnica.service.ean.EanService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EanRestController implements EanApi {

    private final EanService eanService;

    @Override
    public SalidaConsultaEAN getInfoByEAN(String codigoEAN) {
        return eanService.getInfoByEAN(codigoEAN);
    }
}
