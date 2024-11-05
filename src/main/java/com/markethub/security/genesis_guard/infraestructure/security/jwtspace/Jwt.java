package com.markethub.security.genesis_guard.infraestructure.security.jwtspace;

import com.markethub.security.genesis_guard.domain.dtos.token.TokenDto;
import com.markethub.security.genesis_guard.domain.dtos.token.TokenInfo;
import com.markethub.security.genesis_guard.infraestructure.rest.advicers.exceptions.ResourceUnauthorized;
import com.markethub.security.genesis_guard.infraestructure.security.constants.ConstantsSecurity;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.sql.Date;
import java.util.function.Function;

@Component
public class Jwt {

    private final ConstantsSecurity constantsSecurity;

    public Jwt(ConstantsSecurity constantsSecurity){
        this.constantsSecurity = constantsSecurity;
    };

    public SecretKey getKey(){
        return constantsSecurity.getSECRET_KEY();
    }


    

}
