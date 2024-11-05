package com.markethub.security.genesis_guard.infraestructure.rest.advicers;

import lombok.Data;

@Data
public class IndeterminateErrorMessage {
    private String typeError;
    private String bodyError;
    private int statusCodeError;

    public IndeterminateErrorMessage(String typeError, String bodyError, int statusCodeError) {
        this.typeError = typeError;
        this.bodyError = bodyError;
        this.statusCodeError = statusCodeError;
    }


}
