package com.mercadona.pruebatecnica.service.destinos;

import com.mercadona.pruebatecnica.dto.DestinoDto;
import com.mercadona.pruebatecnica.entity.DestinoEntity;
import com.mercadona.pruebatecnica.exception.NotFoundException;
import com.mercadona.pruebatecnica.exception.message.DestinoExceptionMessage;
import com.mercadona.pruebatecnica.mapper.DestinoMapper;
import com.mercadona.pruebatecnica.repository.DestinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DestinosServiceImpl implements DestinosService {

    @Autowired
    private DestinoRepository destinoRepository;

    @Override
    public List<DestinoDto> getAll() {
        return destinoRepository.findAll().stream().map(DestinoMapper::mapDestinoDtoFromEntity).collect(Collectors.toList());
    }

    @Override
    public DestinoDto getById(Long id) {
        DestinoEntity destinoEntity = destinoRepository.findById(id).orElseThrow(() -> new NotFoundException(DestinoExceptionMessage.DESTINO_NOT_FOUND_ERROR, id));
        return DestinoMapper.mapDestinoDtoFromEntity(destinoEntity);
    }

    @Override
    public DestinoDto findByCodigoDestino(String codigoDestino) {
        DestinoEntity destinoEntity = destinoRepository.findByCodigoDestino(codigoDestino).orElseThrow(() -> new NotFoundException(DestinoExceptionMessage.DESTINO_CODE_NOT_FOUND_ERROR, codigoDestino));
        return DestinoMapper.mapDestinoDtoFromEntity(destinoEntity);
    }

    @Override
    public DestinoDto save(DestinoDto destinoDto) {
        DestinoEntity destinoEntity = destinoRepository.save(DestinoMapper.mapDestinoEntityFromDTO(destinoDto));
        return DestinoMapper.mapDestinoDtoFromEntity(destinoEntity);
    }

    @Override
    public DestinoDto update(DestinoDto destinoDto) {
        DestinoEntity destinoEntity = destinoRepository.save(DestinoMapper.mapDestinoEntityFromDTO(getById(destinoDto.getId())));
        return DestinoMapper.mapDestinoDtoFromEntity(destinoEntity);
    }

    @Override
    public void delete(Long id) {
        destinoRepository.deleteById(id);
    }

}
