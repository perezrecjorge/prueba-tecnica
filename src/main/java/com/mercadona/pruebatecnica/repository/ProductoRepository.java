package com.mercadona.pruebatecnica.repository;

import com.mercadona.pruebatecnica.entity.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductoRepository extends JpaRepository<ProductoEntity, Long> {

    Optional<ProductoEntity> findByCodigoProducto(String codigoProducto);

}
