package com.mercadona.pruebatecnica.service.ean;

import com.mercadona.pruebatecnica.dto.DestinoDto;
import com.mercadona.pruebatecnica.dto.ProductoDto;
import com.mercadona.pruebatecnica.dto.ProveedorDto;
import com.mercadona.pruebatecnica.dto.SalidaConsultaEAN;
import com.mercadona.pruebatecnica.service.destinos.DestinosService;
import com.mercadona.pruebatecnica.service.productos.ProductosService;
import com.mercadona.pruebatecnica.service.proveedor.ProveedorService;
import com.mercadona.pruebatecnica.util.Util;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = {"EAN"})
@RequiredArgsConstructor
public class EanServiceImpl implements EanService {

    private final ProductosService productosService;

    private final ProveedorService proveedorService;

    private final DestinosService destinosService;

    @Override
    @Cacheable(value = "EAN", key = "{#codigoEAN}")
    public SalidaConsultaEAN getInfoByEAN(String codigoEAN) {

        ProductoDto productoDto = productosService.findByCodigoProducto(Util.obtenerCodigoProductoFromEAN(codigoEAN));
        ProveedorDto proveedorDto = proveedorService.findByCodigoProveedor(Util.obtenerCodigoProveedorFromEAN(codigoEAN));
        DestinoDto destinoDto = destinosService.findByCodigoDestino(Util.obtenerCodigoDestinoFromEAN(codigoEAN));

        return SalidaConsultaEAN.builder()
            .producto(productoDto)
            .proveedor(proveedorDto)
            .destino(destinoDto)
            .build();
    }

}
