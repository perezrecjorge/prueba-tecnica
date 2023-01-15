package com.mercadona.pruebatecnica.controller.productos;

import com.mercadona.pruebatecnica.constants.Constants;
import com.mercadona.pruebatecnica.dto.ProductoDto;
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

@RequestMapping(Constants.Endpoint.Producto.PRODUCTOS)
@Api(tags = "Productos")
public interface ProductosApi {

    @ApiOperation(value = "List productos with detailed data", notes = "List productos with a max size per request", nickname = "listProductos")
    @ApiResponses({@ApiResponse(code = 400, message = "BAD REQUEST", response = ErrorResponse.class),
            @ApiResponse(code = 401, message = "UNAUTHORIZED", response = ErrorResponse.class),
            @ApiResponse(code = 403, message = "FORBIDDEN", response = ErrorResponse.class),
            @ApiResponse(code = 500, message = "INTERNAL SERVER ERROR", response = ErrorResponse.class)})
    @GetMapping
    List<ProductoDto> getAllProductos();

    @ApiOperation(value = "Get productos data by id", notes = "Get the detailed data for a productos by id", nickname = "getProductoById")
    @ApiResponses({@ApiResponse(code = 400, message = "BAD REQUEST", response = ErrorResponse.class),
            @ApiResponse(code = 401, message = "UNAUTHORIZED", response = ErrorResponse.class),
            @ApiResponse(code = 403, message = "FORBIDDEN", response = ErrorResponse.class),
            @ApiResponse(code = 404, message = "NOT FOUND", response = ErrorResponse.class),
            @ApiResponse(code = 500, message = "INTERNAL SERVER ERROR", response = ErrorResponse.class)})
    @GetMapping(Constants.Endpoint.Producto.PRODUCTOS)
    ProductoDto getProductoById(@PathVariable long id);

    @ApiOperation(value = "Create productos", notes = "Create a new productos")
    @ApiResponses({@ApiResponse(code = 400, message = "BAD REQUEST", response = ErrorResponse.class),
            @ApiResponse(code = 401, message = "UNAUTHORIZED", response = ErrorResponse.class),
            @ApiResponse(code = 403, message = "FORBIDDEN", response = ErrorResponse.class),
            @ApiResponse(code = 422, message = "INCONSISTENT DATA", response = ErrorResponse.class),
            @ApiResponse(code = 500, message = "INTERNAL SERVER ERROR", response = ErrorResponse.class)})
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    ProductoDto save(@RequestBody @Valid ProductoDto request);

    @ApiOperation(value = "Update productos", notes = "Update an existing productos")
    @ApiResponses({@ApiResponse(code = 400, message = "BAD REQUEST", response = ErrorResponse.class),
            @ApiResponse(code = 401, message = "UNAUTHORIZED", response = ErrorResponse.class),
            @ApiResponse(code = 403, message = "FORBIDDEN", response = ErrorResponse.class),
            @ApiResponse(code = 404, message = "NOT FOUND", response = ErrorResponse.class),
            @ApiResponse(code = 500, message = "INTERNAL SERVER ERROR", response = ErrorResponse.class)})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping
    ProductoDto update(@RequestBody @Valid ProductoDto request);

    @ApiOperation(value = "Delete productos", notes = "Delete an existing productos")
    @ApiResponses({@ApiResponse(code = 400, message = "BAD REQUEST", response = ErrorResponse.class),
            @ApiResponse(code = 401, message = "UNAUTHORIZED", response = ErrorResponse.class),
            @ApiResponse(code = 403, message = "FORBIDDEN", response = ErrorResponse.class),
            @ApiResponse(code = 404, message = "NOT FOUND", response = ErrorResponse.class),
            @ApiResponse(code = 500, message = "INTERNAL SERVER ERROR", response = ErrorResponse.class)})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(Constants.Endpoint.Producto.PRODUCTOS_ID)
    void delete(@PathVariable long id);

}
