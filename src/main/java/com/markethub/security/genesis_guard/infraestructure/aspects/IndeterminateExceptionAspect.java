package com.markethub.security.genesis_guard.infraestructure.aspects;

import com.markethub.security.genesis_guard.domain.dtos.user.UserResponseDto;
import com.markethub.security.genesis_guard.infraestructure.rest.advicers.IndeterminateErrorMessage;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpStatusCodeException;

@Aspect
@Component
public class IndeterminateExceptionAspect {

    /*
    @AfterThrowing(pointcut = "within(@com.markethub.security.genesis_guard.infraestructure.aspects.interceptables.InterceptableIndermitateException *)",throwing = "ex")
    public ResponseEntity<IndeterminateErrorMessage> handleInterceptableControllerException(HttpStatusCodeException ex){
        IndeterminateErrorMessage indeterminateErrorMessage = new IndeterminateErrorMessage(
                ex.getClass().getTypeName(),
                ex.getResponseBodyAsString(),
                ex.getStatusCode().value()
        );

        return ResponseEntity.status(indeterminateErrorMessage.getStatusCodeError()).body(indeterminateErrorMessage);
    }

     */

    @Around("@annotation(com.markethub.security.genesis_guard.infraestructure.aspects.interceptables.InterceptableIndermitateException)")
    public ResponseEntity<?> handleInterceptableMethodException(ProceedingJoinPoint proceedingJoinPoint) {
        try {
            ResponseEntity<UserResponseDto> userRes =(ResponseEntity<UserResponseDto>) proceedingJoinPoint.proceed();
            return userRes;
        }catch (HttpStatusCodeException ex){
            IndeterminateErrorMessage indeterminateErrorMessage = new IndeterminateErrorMessage(
                    ex.getClass().getTypeName(),
                    ex.getResponseBodyAsString(),
                    ex.getStatusCode().value()
            );
            return ResponseEntity.status(indeterminateErrorMessage.getStatusCodeError()).body(indeterminateErrorMessage);
        }catch (Throwable throwable){
            System.out.println(throwable);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error inesperado en el servicio");
        }

    }

    @Before("@annotation(com.markethub.security.genesis_guard.infraestructure.aspects.interceptables.PreInterceptor)")
    public void preIntercept(){
        System.out.println("Antes bien");
    }
}
