package com.leon.stock.service;

import java.security.Key;

import java.util.Date;
import java.util.stream.Collectors;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

	@Value("${jwt.secret}")
	private String jwtKey;
	
	private static final long EXPIRATION_TIME = 3600000L;
	
	
	
	public String generateToken(Authentication authentication) {
		
		Date now = new Date();
		Date expirationDate = new Date(now.getTime() + EXPIRATION_TIME);
			
		String roles = authentication.getAuthorities().stream()
				.map(grantedAuthority -> grantedAuthority.getAuthority())
				.collect(Collectors.joining(","));
			
		
		String token = Jwts.builder()
                .subject(authentication.getName())
                .claim("roles", roles)
                .issuedAt(now)
                .expiration(expirationDate)
                .signWith(key())
                .compact();

		return token;
	}
	
	private Key key(){
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtKey));
    }
	
	
	// get username from JWT token
    public String getUsername(String token){

        return Jwts.parser()
                .verifyWith((SecretKey) key())
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }

    // validate JWT token
    public boolean validateToken(String token){
            Jwts.parser()
                    .verifyWith((SecretKey) key())
                    .build()
                    .parse(token);
            return true;
    }
	
	
}
