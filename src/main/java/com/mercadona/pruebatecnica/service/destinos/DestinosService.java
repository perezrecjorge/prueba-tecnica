package com.mercadona.pruebatecnica.service.destinos;

import com.mercadona.pruebatecnica.dto.DestinoDto;

import java.util.List;

public interface DestinosService {

    List<DestinoDto> getAll();

    DestinoDto getById(Long id);

    DestinoDto findByCodigoDestino(String codigoDestino);

    DestinoDto save(DestinoDto destinoDto);

    DestinoDto update(DestinoDto destinoDto);

    void delete(Long id);

}
