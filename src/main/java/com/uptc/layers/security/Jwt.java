package com.uptc.layers.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.uptc.layers.model.object.LoginCredentials;

public class Jwt {
    public final static Algorithm ALGORITHM = Algorithm.HMAC256("HYCYBH");

    private final static String EMAIL_CLAIM_KEY = "email";
    private final static String PASSWORD_CLAIM_KEY = "password";

    public static class JwtToken {
        public final String value;

        public JwtToken(LoginCredentials loginCredentials) {
            this.value = JWT.create()
                    .withClaim(EMAIL_CLAIM_KEY, loginCredentials.email)
                    .withClaim(PASSWORD_CLAIM_KEY, loginCredentials.password)
                    .sign(Jwt.ALGORITHM);
        }
    }

    public static DecodedJWT isJwtTokenValid(String token) {
        JWTVerifier verifier = JWT.require(ALGORITHM).build();
        try {
            return verifier.verify(token);
        } catch (JWTVerificationException exception) {
            return null;
        }
    }

    public static LoginCredentials getLoginCredentialsFromToken(DecodedJWT token) {
        LoginCredentials credentials = new LoginCredentials(
                token.getClaim(EMAIL_CLAIM_KEY).asString(),
                token.getClaim(PASSWORD_CLAIM_KEY).asString()
        );
        return credentials;
    }
}
