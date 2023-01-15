package com.mercadona.pruebatecnica.repository;

import com.mercadona.pruebatecnica.entity.ProveedorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProveedorRepository extends JpaRepository<ProveedorEntity, Long> {

    Optional<ProveedorEntity> findByCodigoProveedor(String codigoProveedor);

}
