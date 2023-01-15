package com.mercadona.pruebatecnica.controller.proveedor;

import com.mercadona.pruebatecnica.dto.ProveedorDto;
import com.mercadona.pruebatecnica.service.proveedor.ProveedorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProveedoresRestController implements ProveedoresApi {

    private final ProveedorService proveedorService;

    @Override
    public List<ProveedorDto> getAllProductos() {
        return proveedorService.getAll();
    }

    @Override
    public ProveedorDto getProductoById(long id) {
        return proveedorService.getById(id);
    }

    @Override
    public ProveedorDto save(ProveedorDto proveedorDto) {
        return proveedorService.save(proveedorDto);
    }

    @Override
    public ProveedorDto update(ProveedorDto proveedorDto) {
        return proveedorService.update(proveedorDto);
    }

    @Override
    public void delete(long id) {
        proveedorService.delete(id);
    }
}
