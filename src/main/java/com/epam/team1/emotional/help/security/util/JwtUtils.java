package com.epam.team1.emotional.help.security.util;

import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.xml.transform.sax.SAXResult;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Slf4j
@Component
public class JwtUtils {
    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.accessExpirationMs}")
    private int jwtAccessExpirationMs;
    @Value("${jwt.refreshExpirationMs}")
    private int jwtRefreshExpirationMs;

    @Value("${jwt.bearer}")
    private String bearer;

    public String generateJwtToken(UserDetails userDetails, boolean forRefresh) {
        Map<String, Object> claims = new HashMap<>();

        final Date createdDate = new Date();
        final Date expirationDate = calculateExpirationDate(createdDate, forRefresh);
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(createdDate)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public String generateJwtToken(String username) {
        Map<String, Object> claims = new HashMap<>();

        final Date createdDate = new Date();
        final Date expirationDate = calculateExpirationDate(createdDate, false);
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(createdDate)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }



    public String parseJwt(HttpServletRequest request) {
        String headerAuth = request.getHeader("Authorization");

        if (StringUtils.hasText(headerAuth) && headerAuth.startsWith(bearer + " ")) {
            return headerAuth.substring(7, headerAuth.length());
        }
        return null;
    }

    public String parseRefreshJwt(HttpServletRequest request) {
        String headerAuth = request.getHeader("Refresh-Toket");

        if (StringUtils.hasText(headerAuth) && headerAuth.startsWith(bearer + " ")) {
            return headerAuth.substring(7, headerAuth.length());
        }
        return null;
    }


    public String getUserNameFromJwtToken(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException e) {
            log.error("Invalid JWT signature: ", e.getMessage());
            throw e;
        } catch (MalformedJwtException e) {
            log.error("Invalid JWT token: ", e.getMessage());
            throw e;
        } catch (ExpiredJwtException e) {
            log.error("JWT token is expired: ", e.getMessage());
            throw e;
        } catch (UnsupportedJwtException e) {
            log.error("JWT token is unsupported: ", e.getMessage());
            throw e;
        } catch (IllegalArgumentException e) {
            log.error("JWT claims string is empty: ", e.getMessage());
            throw e;
        }
    }

    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date calculateExpirationDate(Date createdDate, boolean forRefresh) {

        int jwtExpirationInMs;
        if (forRefresh) {
            jwtExpirationInMs = jwtRefreshExpirationMs;
        } else {
            jwtExpirationInMs = jwtAccessExpirationMs;
        }
        return new Date(createdDate.getTime() + jwtExpirationInMs);
    }


}