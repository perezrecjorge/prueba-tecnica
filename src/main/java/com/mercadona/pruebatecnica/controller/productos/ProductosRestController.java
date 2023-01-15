package com.mercadona.pruebatecnica.controller.productos;

import com.mercadona.pruebatecnica.dto.ProductoDto;
import com.mercadona.pruebatecnica.service.productos.ProductosService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductosRestController implements ProductosApi {

    private final ProductosService productosService;

    @Override
    public List<ProductoDto> getAllProductos() {
        return productosService.getAll();
    }

    @Override
    public ProductoDto getProductoById(long id) {
        return productosService.getById(id);
    }

    @Override
    public ProductoDto save(ProductoDto productoDto) {
        return productosService.save(productoDto);
    }

    @Override
    public ProductoDto update(ProductoDto productoDto) {
        return productosService.update(productoDto);
    }

    @Override
    public void delete(long id) {
        productosService.delete(id);
    }

}
