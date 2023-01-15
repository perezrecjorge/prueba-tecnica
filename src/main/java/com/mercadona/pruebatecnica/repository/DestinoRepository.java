package com.mercadona.pruebatecnica.repository;

import com.mercadona.pruebatecnica.entity.DestinoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DestinoRepository extends JpaRepository<DestinoEntity, Long> {

    Optional<DestinoEntity> findByCodigoDestino(String codigoDestino);

}
