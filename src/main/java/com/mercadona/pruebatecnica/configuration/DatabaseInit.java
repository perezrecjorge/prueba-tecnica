package com.mercadona.pruebatecnica.configuration;

import com.mercadona.pruebatecnica.entity.DestinoEntity;
import com.mercadona.pruebatecnica.entity.ProductoEntity;
import com.mercadona.pruebatecnica.entity.ProveedorEntity;
import com.mercadona.pruebatecnica.repository.DestinoRepository;
import com.mercadona.pruebatecnica.repository.ProductoRepository;
import com.mercadona.pruebatecnica.repository.ProveedorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@Component
public class DatabaseInit {

    @Autowired
    public ProductoRepository productoRepository;

    @Autowired
    public DestinoRepository destinoRepository;

    @Autowired
    public ProveedorRepository proveedorRepository;

    @PostConstruct
    public void createEjs() {
        log.info("Insertando productos");
        productoRepository.save(createProducto("12345", "Pan", 100));
        productoRepository.save(createProducto("54321", "Arroz", 200));
        log.info("Insertando destinos");
        destinoRepository.save(createDestino("1", "Mercadona España", "Sevilla"));
        destinoRepository.save(createDestino("6", "Mercadona Portugal", "Lisboa"));
        log.info("Insertando proveedores");
        proveedorRepository.save(createProveedor("1234567", "CANAMA S.L."));
        proveedorRepository.save(createProveedor("7654321", "JUAN S.L."));
    }

    private ProductoEntity createProducto(String codigo, String nombre, Integer cantidad) {
        return ProductoEntity.builder().codigoProducto(codigo).nombre(nombre).cantidad(cantidad).build();
    }

    private DestinoEntity createDestino(String codigo, String nombre, String ciudad) {
        return DestinoEntity.builder().codigoDestino(codigo).destino(nombre).ciudad(ciudad).build();
    }

    private ProveedorEntity createProveedor(String codigo, String nombre) {
        return ProveedorEntity.builder().codigoProveedor(codigo).nombre(nombre).build();
    }
}