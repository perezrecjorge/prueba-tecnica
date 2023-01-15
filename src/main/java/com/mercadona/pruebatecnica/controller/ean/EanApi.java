package com.mercadona.pruebatecnica.controller.ean;

import com.mercadona.pruebatecnica.constants.Constants;
import com.mercadona.pruebatecnica.dto.SalidaConsultaEAN;
import com.mercadona.pruebatecnica.exception.model.ErrorResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(Constants.Endpoint.EAN.EAN)
@Api(tags = "EAN Api")
public interface EanApi {

    @ApiOperation(value = "Get indo data by id", notes = "Get the detailed data by EAN")
    @ApiResponses({@ApiResponse(code = 400, message = "BAD REQUEST", response = ErrorResponse.class),
            @ApiResponse(code = 401, message = "UNAUTHORIZED", response = ErrorResponse.class),
            @ApiResponse(code = 403, message = "FORBIDDEN", response = ErrorResponse.class),
            @ApiResponse(code = 404, message = "NOT FOUND", response = ErrorResponse.class),
            @ApiResponse(code = 500, message = "INTERNAL SERVER ERROR", response = ErrorResponse.class)})
    @GetMapping(Constants.Endpoint.EAN.EAN_ID)
    SalidaConsultaEAN getInfoByEAN(@PathVariable String codigoEAN);

}
