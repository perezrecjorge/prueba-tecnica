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
import javax.transaction.Transactional;

@Slf4j
@Component
public class DatabaseInit {

    @Autowired
    public ProductoRepository productoRepository;

    @Autowired
    public DestinoRepository destinoRepository;

    @Autowired
    public ProveedorRepository proveedorRepository;

    @Transactional
    @PostConstruct
    public void createEjs() {
        log.info("Insertando productos");
        productoRepository.save(createProducto("12345", "Pan", 2000));
        productoRepository.save(createProducto("54321", "Arroz", 1000));
        log.info("Insertando destinos");
        destinoRepository.save(createDestino("0", "Colmenas"));
        destinoRepository.save(createDestino("1", "Mercadona España"));
        destinoRepository.save(createDestino("2", "Mercadona España"));
        destinoRepository.save(createDestino("3", "Mercadona España"));
        destinoRepository.save(createDestino("4", "Mercadona España"));
        destinoRepository.save(createDestino("5", "Mercadona España"));
        destinoRepository.save(createDestino("6", "Mercadona Portugal"));
        destinoRepository.save(createDestino("8", "Almacenes"));
        destinoRepository.save(createDestino("9", "Oficinas Mercadona"));
        log.info("Insertando proveedores");
        proveedorRepository.save(createProveedor("8437008", "HACENDADO"));
        proveedorRepository.save(createProveedor("1234567", "CANAMA S.L."));
        proveedorRepository.save(createProveedor("7654321", "JUAN S.L."));
    }

    private ProductoEntity createProducto(String codigo, String nombre, Integer cantidad) {
        return ProductoEntity.builder().codigoProducto(codigo).nombre(nombre).cantidad(cantidad).build();
    }

    private DestinoEntity createDestino(String codigoDestino, String nombre) {
        return DestinoEntity.builder().codigoDestino(codigoDestino).destino(nombre).build();
    }

    private ProveedorEntity createProveedor(String codigo, String nombre) {
        return ProveedorEntity.builder().codigoProveedor(codigo).nombre(nombre).build();
    }
}