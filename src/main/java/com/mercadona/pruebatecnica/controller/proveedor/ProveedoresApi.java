package com.mercadona.pruebatecnica.controller.proveedor;

import com.mercadona.pruebatecnica.constants.Constants;
import com.mercadona.pruebatecnica.dto.ProveedorDto;
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

@RequestMapping(Constants.Endpoint.Proveedor.PROVEEDORES)
@Api(tags = "Proveedores")
public interface ProveedoresApi {

    @ApiOperation(value = "List proveedores with detailed data", notes = "List proveedores with a max size per request", nickname = "listProveedores")
    @ApiResponses({@ApiResponse(code = 400, message = "BAD REQUEST", response = ErrorResponse.class),
            @ApiResponse(code = 401, message = "UNAUTHORIZED", response = ErrorResponse.class),
            @ApiResponse(code = 403, message = "FORBIDDEN", response = ErrorResponse.class),
            @ApiResponse(code = 500, message = "INTERNAL SERVER ERROR", response = ErrorResponse.class)})
    @GetMapping
    List<ProveedorDto> getAllProductos();

    @ApiOperation(value = "Get proveedor data by id", notes = "Get the detailed data for a proveedor by id", nickname = "getProveedorById")
    @ApiResponses({@ApiResponse(code = 400, message = "BAD REQUEST", response = ErrorResponse.class),
            @ApiResponse(code = 401, message = "UNAUTHORIZED", response = ErrorResponse.class),
            @ApiResponse(code = 403, message = "FORBIDDEN", response = ErrorResponse.class),
            @ApiResponse(code = 404, message = "NOT FOUND", response = ErrorResponse.class),
            @ApiResponse(code = 500, message = "INTERNAL SERVER ERROR", response = ErrorResponse.class)})
    @GetMapping(Constants.Endpoint.Proveedor.PROVEEDORES)
    ProveedorDto getProductoById(@PathVariable long id);

    @ApiOperation(value = "Create proveedor", notes = "Create a new proveedor")
    @ApiResponses({@ApiResponse(code = 400, message = "BAD REQUEST", response = ErrorResponse.class),
            @ApiResponse(code = 401, message = "UNAUTHORIZED", response = ErrorResponse.class),
            @ApiResponse(code = 403, message = "FORBIDDEN", response = ErrorResponse.class),
            @ApiResponse(code = 422, message = "INCONSISTENT DATA", response = ErrorResponse.class),
            @ApiResponse(code = 500, message = "INTERNAL SERVER ERROR", response = ErrorResponse.class)})
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    ProveedorDto save(@RequestBody @Valid ProveedorDto proveedorDto);

    @ApiOperation(value = "Update proveedor", notes = "Update an existing proveedor")
    @ApiResponses({@ApiResponse(code = 400, message = "BAD REQUEST", response = ErrorResponse.class),
            @ApiResponse(code = 401, message = "UNAUTHORIZED", response = ErrorResponse.class),
            @ApiResponse(code = 403, message = "FORBIDDEN", response = ErrorResponse.class),
            @ApiResponse(code = 404, message = "NOT FOUND", response = ErrorResponse.class),
            @ApiResponse(code = 500, message = "INTERNAL SERVER ERROR", response = ErrorResponse.class)})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping
    ProveedorDto update(@RequestBody @Valid ProveedorDto proveedorDto);

    @ApiOperation(value = "Delete proveedor", notes = "Delete an existing proveedor")
    @ApiResponses({@ApiResponse(code = 400, message = "BAD REQUEST", response = ErrorResponse.class),
            @ApiResponse(code = 401, message = "UNAUTHORIZED", response = ErrorResponse.class),
            @ApiResponse(code = 403, message = "FORBIDDEN", response = ErrorResponse.class),
            @ApiResponse(code = 404, message = "NOT FOUND", response = ErrorResponse.class),
            @ApiResponse(code = 500, message = "INTERNAL SERVER ERROR", response = ErrorResponse.class)})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(Constants.Endpoint.Proveedor.PROVEEDOR_ID)
    void delete(@PathVariable long id);

}
