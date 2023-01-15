package com.mercadona.pruebatecnica.service.proveedor;

import com.mercadona.pruebatecnica.dto.ProveedorDto;
import com.mercadona.pruebatecnica.entity.ProveedorEntity;
import com.mercadona.pruebatecnica.exception.NotFoundException;
import com.mercadona.pruebatecnica.exception.message.ProveedorExceptionMessage;
import com.mercadona.pruebatecnica.mapper.ProveedorMapper;
import com.mercadona.pruebatecnica.repository.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProveedorServiceImpl implements ProveedorService {

    @Autowired
    private ProveedorRepository proveedorRepository;

    @Override
    public List<ProveedorDto> getAll() {
        return proveedorRepository.findAll().stream().map(ProveedorMapper::mapProveedorDtoFromEntity).collect(Collectors.toList());
    }

    @Override
    public ProveedorDto getById(Long id) {
        ProveedorEntity proveedorEntity = proveedorRepository.findById(id).orElseThrow(() -> new NotFoundException(ProveedorExceptionMessage.PROVEEDOR_NOT_FOUND_ERROR, id));
        return ProveedorMapper.mapProveedorDtoFromEntity(proveedorEntity);
    }

    @Override
    public ProveedorDto findByCodigoProveedor(String codigoProveedor) {
        ProveedorEntity proveedorEntity = proveedorRepository.findByCodigoProveedor(codigoProveedor).orElseThrow(() -> new NotFoundException(ProveedorExceptionMessage.PROVEEDOR_CODE_NOT_FOUND_ERROR, codigoProveedor));
        return ProveedorMapper.mapProveedorDtoFromEntity(proveedorEntity);
    }

    @Override
    public ProveedorDto save(ProveedorDto proveedorDto) {
        ProveedorEntity proveedorEntity = proveedorRepository.save(ProveedorMapper.mapProveedorEntityFromDTO(proveedorDto));
        return ProveedorMapper.mapProveedorDtoFromEntity(proveedorEntity);
    }

    @Override
    public ProveedorDto update(ProveedorDto proveedorDto) {
        ProveedorEntity proveedorEntity = proveedorRepository.save(ProveedorMapper.mapProveedorEntityFromDTO(getById(proveedorDto.getId())));
        return ProveedorMapper.mapProveedorDtoFromEntity(proveedorEntity);
    }

    @Override
    public void delete(Long id) {
        proveedorRepository.deleteById(id);
    }

}
