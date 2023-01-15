package com.mercadona.pruebatecnica.service.productos;

import com.mercadona.pruebatecnica.dto.ProductoDto;

import java.util.List;

public interface ProductosService {

    List<ProductoDto> getAll();

    ProductoDto getById(Long id);

    ProductoDto findByCodigoProducto(String codigoProducto);

    ProductoDto save(ProductoDto destinoDto);

    ProductoDto update(ProductoDto destinoDto);

    void delete(Long id);



}
