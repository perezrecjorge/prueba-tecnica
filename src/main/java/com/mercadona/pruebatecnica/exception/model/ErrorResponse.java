package com.mercadona.pruebatecnica.exception.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Builder
@Getter
@ToString
@ApiModel(description = "Response for any error thrown in the application")
public class ErrorResponse {

    @ApiModelProperty(value = "API Version", example = "1")
    private final String apiVersion;
    @ApiModelProperty(value = "HTTP Error", example = "Internal Server Error")
    private final String error;
    @ApiModelProperty(value = "Detail error")
    private final String detail;
    @ApiModelProperty(value = "HTTP Status", example = "500")
    private final long status;
    @ApiModelProperty(value = "Internal code of error", example = "E{FunctionalityCode}-{ErrorCode}")
    private final String internalCode;
    @ApiModelProperty(value = "Timestamp of error")
    private final long timestamp;
    @ApiModelProperty(value = "List of suberrors")
    private final List<SubError> subErrors;

}
