package com.mercadona.pruebatecnica.service.proveedor;

import com.mercadona.pruebatecnica.dto.ProveedorDto;

import java.util.List;

public interface ProveedorService {

    List<ProveedorDto> getAll();

    ProveedorDto getById(Long id);

    ProveedorDto save(ProveedorDto destinoDto);

    ProveedorDto update(ProveedorDto destinoDto);

    void delete(Long id);
    
}
