package com.markethub.security.genesis_guard.infraestructure.components;

import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.DefaultResponseErrorHandler;

import java.io.IOException;

public class CustomResponseErrorHandler extends DefaultResponseErrorHandler {
    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        // Puedes verificar el código de estado y manejarlo según sea necesario
        if (response.getStatusCode().is4xxClientError() || response.getStatusCode().is5xxServerError()) {

            System.out.println("HOLLLLALALAL");
            // Lanza la excepción como de costumbre
            super.handleError(response);
        }
        // Si deseas manejar otros códigos o realizar una acción particular antes de lanzar la excepción,
        // puedes hacerlo aquí.
    }
}
