package com.mercadona.pruebatecnica.exception.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
@ApiModel(description = "Validation error description")
public class SubError {

    @ApiModelProperty(value = "Field error")
    private final String field;
    @ApiModelProperty(value = "Description error")
    private final String description;

}
