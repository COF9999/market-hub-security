package com.markethub.security.genesis_guard.infraestructure.rest.advicers;

import lombok.Data;

@Data
public class ErrorMessage {
    private String exception;
    private String message;
    private Integer statusCode;

    public ErrorMessage(Exception runtimeException,Integer statusCode){
        this.exception = runtimeException.getClass().getName();
        this.message = runtimeException.getMessage();
        this.statusCode = statusCode;
    }
}
