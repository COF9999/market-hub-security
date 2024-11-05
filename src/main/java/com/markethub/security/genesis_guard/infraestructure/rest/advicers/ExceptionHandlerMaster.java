package com.markethub.security.genesis_guard.infraestructure.rest.advicers;

import com.markethub.security.genesis_guard.infraestructure.rest.advicers.exceptions.ResourceAlreadyExists;
import com.markethub.security.genesis_guard.infraestructure.rest.advicers.exceptions.ResourceNotFound;
import com.markethub.security.genesis_guard.infraestructure.rest.advicers.exceptions.ResourceUnauthorized;
import io.jsonwebtoken.security.SignatureException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.support.MissingServletRequestPartException;

@RestControllerAdvice
public class ExceptionHandlerMaster {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({ResourceNotFound.class})
    @ResponseBody
    public ErrorMessage resourceNotFound(Exception e){
        return new ErrorMessage(e,HttpStatus.NOT_FOUND.value());
    }

    @ExceptionHandler({ResourceAlreadyExists.class})
    public ResponseEntity<ErrorMessage> conflictCallingResource(Exception e){
        return ResponseEntity.status(HttpStatus.CONFLICT).body((new ErrorMessage(e,HttpStatus.CONFLICT.value())));
    }


    @ExceptionHandler({ResourceUnauthorized.class, SignatureException.class})
    public ResponseEntity<ErrorMessage> unauthorizedResource(Exception e ){
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ErrorMessage(e,HttpStatus.UNAUTHORIZED.value()));
    }

    @ExceptionHandler({HttpMediaTypeException.class})
    public ResponseEntity<ErrorMessage> mediaTypeInvalid(Exception e){
        return ResponseEntity.status(HttpStatus.UNSUPPORTED_MEDIA_TYPE).body(new ErrorMessage(e,HttpStatus.UNSUPPORTED_MEDIA_TYPE.value()));
    }

    @ExceptionHandler({
            MissingServletRequestPartException.class,
            IllegalArgumentException.class})
    public ResponseEntity<ErrorMessage> badFormatInRequest(Exception e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorMessage(e,HttpStatus.BAD_REQUEST.value()));
    }
}
