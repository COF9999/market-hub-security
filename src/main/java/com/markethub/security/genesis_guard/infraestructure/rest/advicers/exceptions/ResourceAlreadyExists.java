package com.markethub.security.genesis_guard.infraestructure.rest.advicers.exceptions;

public class ResourceAlreadyExists extends RuntimeException{
    public ResourceAlreadyExists(String message) {
        super(message);
    }
}
