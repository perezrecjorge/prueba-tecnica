package com.mercadona.pruebatecnica.controller.destinos;

import com.mercadona.pruebatecnica.dto.DestinoDto;
import com.mercadona.pruebatecnica.service.destinos.DestinosService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DestinosRestController implements DestinosApi {

    private final DestinosService destinosService;

    @Override
    public List<DestinoDto> getAllDestinos() {
        return destinosService.getAll();
    }

    @Override
    public DestinoDto getDestinoById(Long id) {
        return destinosService.getById(id);
    }

    @Override
    public DestinoDto save(DestinoDto destinoDto) {
        return destinosService.save(destinoDto);
    }

    @Override
    public DestinoDto update(DestinoDto destinoDto) {
        return destinosService.update(destinoDto);
    }

    @Override
    public void delete(long id) {
        destinosService.delete(id);
    }
}
