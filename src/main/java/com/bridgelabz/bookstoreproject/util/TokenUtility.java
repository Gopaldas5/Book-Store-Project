package com.bridgelabz.bookstoreproject.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.Verification;
import org.springframework.stereotype.Component;

@Component
public class TokenUtility {

    private static final String TOKEN_SECRET = "Goku";

    public String createToken(int id) {
        try {
            //to set algorithm
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            return JWT.create().withClaim("user_id", id).sign(algorithm);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();

            //log token signing failed
        } catch (JWTCreationException e) {
            e.printStackTrace();
        }
        return null;
    }
    public int decodeToken(String token){
        int contactId;

        Verification verification = null;
        try{
            verification = JWT.require(Algorithm.HMAC256(TOKEN_SECRET));

        }catch (IllegalArgumentException e){
            e.printStackTrace();
        }
        JWTVerifier jwtVerifier = verification.build();
        DecodedJWT decodedJWT = jwtVerifier.verify(token);

        Claim claim =decodedJWT.getClaim("user_id");
        contactId = claim.asInt();

        return contactId;
    }
}
//    public int decodeToken(String token) {
//        int userId;
//        //for verification algorithm
//        Verification verification = null;
//        try {
//            verification = JWT.require(Algorithm.HMAC256(TOKEN_SECRET));
//        } catch (IllegalArgumentException e) {
//            e.printStackTrace();
//        }
////        assert verification != null;
//        JWTVerifier jwtVerifier = verification.build();
//        //to decode token
//        DecodedJWT decodedJWT = jwtVerifier.verify(token);
//        Claim claim = decodedJWT.getClaim("user_id");
//        userId = claim.asInt();
//
//        return userId;
//
//
//    }
//
//}
