package com.mercadona.pruebatecnica.controller.destinos;

import com.mercadona.pruebatecnica.constants.Constants;
import com.mercadona.pruebatecnica.dto.DestinoDto;
import com.mercadona.pruebatecnica.exception.model.ErrorResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.Valid;
import java.util.List;

@RequestMapping(Constants.Endpoint.Destino.DESTINOS)
@Api(tags = "Destinos")
public interface DestinosApi {

    @ApiOperation(value = "List destinos with detailed data", notes = "List destinos with a max size per request", nickname = "listDestinos")
    @ApiResponses({@ApiResponse(code = 400, message = "BAD REQUEST", response = ErrorResponse.class),
            @ApiResponse(code = 401, message = "UNAUTHORIZED", response = ErrorResponse.class),
            @ApiResponse(code = 403, message = "FORBIDDEN", response = ErrorResponse.class),
            @ApiResponse(code = 500, message = "INTERNAL SERVER ERROR", response = ErrorResponse.class)})
    @GetMapping
    List<DestinoDto> getAllDestinos();

    @ApiOperation(value = "Get destino data by id", notes = "Get the detailed data for a destino by id", nickname = "getDestinoById")
    @ApiResponses({@ApiResponse(code = 400, message = "BAD REQUEST", response = ErrorResponse.class),
            @ApiResponse(code = 401, message = "UNAUTHORIZED", response = ErrorResponse.class),
            @ApiResponse(code = 403, message = "FORBIDDEN", response = ErrorResponse.class),
            @ApiResponse(code = 404, message = "NOT FOUND", response = ErrorResponse.class),
            @ApiResponse(code = 500, message = "INTERNAL SERVER ERROR", response = ErrorResponse.class)})
    @GetMapping(Constants.Endpoint.Destino.DESTINOS_ID)
    DestinoDto getDestinoById(@PathVariable Long id);

    @ApiOperation(value = "Create destino", notes = "Create a new destino")
    @ApiResponses({@ApiResponse(code = 400, message = "BAD REQUEST", response = ErrorResponse.class),
            @ApiResponse(code = 401, message = "UNAUTHORIZED", response = ErrorResponse.class),
            @ApiResponse(code = 403, message = "FORBIDDEN", response = ErrorResponse.class),
            @ApiResponse(code = 422, message = "INCONSISTENT DATA", response = ErrorResponse.class),
            @ApiResponse(code = 500, message = "INTERNAL SERVER ERROR", response = ErrorResponse.class)})
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    DestinoDto save(@RequestBody @Valid DestinoDto request);

    @ApiOperation(value = "Update destino", notes = "Update an existing destino")
    @ApiResponses({@ApiResponse(code = 400, message = "BAD REQUEST", response = ErrorResponse.class),
            @ApiResponse(code = 401, message = "UNAUTHORIZED", response = ErrorResponse.class),
            @ApiResponse(code = 403, message = "FORBIDDEN", response = ErrorResponse.class),
            @ApiResponse(code = 404, message = "NOT FOUND", response = ErrorResponse.class),
            @ApiResponse(code = 500, message = "INTERNAL SERVER ERROR", response = ErrorResponse.class)})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping
    DestinoDto update( @RequestBody @Valid DestinoDto destinoDto);

    @ApiOperation(value = "Delete destino", notes = "Delete an existing destino")
    @ApiResponses({@ApiResponse(code = 400, message = "BAD REQUEST", response = ErrorResponse.class),
            @ApiResponse(code = 401, message = "UNAUTHORIZED", response = ErrorResponse.class),
            @ApiResponse(code = 403, message = "FORBIDDEN", response = ErrorResponse.class),
            @ApiResponse(code = 404, message = "NOT FOUND", response = ErrorResponse.class),
            @ApiResponse(code = 500, message = "INTERNAL SERVER ERROR", response = ErrorResponse.class)})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(Constants.Endpoint.Destino.DESTINOS_ID)
    void delete(@PathVariable long id);

}
