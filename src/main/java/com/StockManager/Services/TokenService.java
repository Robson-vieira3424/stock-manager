package com.StockManager.Services;

import com.StockManager.Model.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.stereotype.Service;
import org.springframework.security.core.Authentication;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@Service
public class TokenService {

    @Value("${api.chave.agoritmo}")
    private String chaveCoficacao;


    public String gerarToken(Usuario usuario){
        try {

            Algorithm alg= Algorithm.HMAC256(chaveCoficacao);

            return JWT.create()
                    .withIssuer("Stock-Manager-API")
                    .withSubject(usuario.getEmail()) /* É O EMAIL */
                    .withClaim("role", String.valueOf(usuario.getAuthorities()) )
                    .withExpiresAt(dataExpiracao())
                    .sign(alg);
        }
        catch (JWTCreationException e){
            throw new JWTCreationException("Erro ao criar token: ", e);
        }
    }
    public String getSubject(String token){
        Algorithm alg= Algorithm.HMAC256(chaveCoficacao);

        try{
            return JWT.require(alg)
                    .withIssuer("Stock-Manager-API")
                    .build()
                    .verify(token)
                    .getSubject();
        }catch (JWTVerificationException e){
            throw new JWTVerificationException("ERRO ao verificar usuario do token: ", e);


        }

    }
    public Instant dataExpiracao(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-3:00"));
    }

}

