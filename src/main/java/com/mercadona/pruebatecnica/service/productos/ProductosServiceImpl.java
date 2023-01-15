package com.mercadona.pruebatecnica.service.productos;

import com.mercadona.pruebatecnica.dto.ProductoDto;
import com.mercadona.pruebatecnica.entity.ProductoEntity;
import com.mercadona.pruebatecnica.exception.NotFoundException;
import com.mercadona.pruebatecnica.exception.message.ProductoExceptionMessage;
import com.mercadona.pruebatecnica.mapper.ProductoMapper;
import com.mercadona.pruebatecnica.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductosServiceImpl implements ProductosService {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<ProductoDto> getAll() {
        return productoRepository.findAll().stream().map(ProductoMapper::mapProductoDtoFromEntity).collect(Collectors.toList());
    }

    @Override
    public ProductoDto getById(Long id) {
        ProductoEntity productoEntity = productoRepository.findById(id).orElseThrow(() -> new NotFoundException(ProductoExceptionMessage.PRODUCT_NOT_FOUND_ERROR, id));
        return ProductoMapper.mapProductoDtoFromEntity(productoEntity);
    }

    @Override
    public ProductoDto findByCodigoProducto(String codigoProducto) {
        ProductoEntity productoEntity = productoRepository.findByCodigoProducto(codigoProducto).orElseThrow(() -> new NotFoundException(ProductoExceptionMessage.PRODUCT_CODE_NOT_FOUND_ERROR, codigoProducto));
        return ProductoMapper.mapProductoDtoFromEntity(productoEntity);
    }

    @Override
    public ProductoDto save(ProductoDto productoDto) {
        ProductoEntity productoEntity = productoRepository.save(ProductoMapper.mapProductoEntityFromDTO(productoDto));
        return ProductoMapper.mapProductoDtoFromEntity(productoEntity);
    }

    @Override
    public ProductoDto update(ProductoDto productoDto) {
        ProductoEntity productoEntity = productoRepository.save(ProductoMapper.mapProductoEntityFromDTO(getById(productoDto.getId())));
        return ProductoMapper.mapProductoDtoFromEntity(productoEntity);
    }

    @Override
    public void delete(Long id) {
        productoRepository.deleteById(id);
    }
    
}
