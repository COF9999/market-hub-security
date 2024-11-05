package com.markethub.security.genesis_guard.infraestructure.rest.advicers.exceptions;

public class ResourceNotFound extends RuntimeException{
    public ResourceNotFound(String message) {
        super(message);
    }
}
