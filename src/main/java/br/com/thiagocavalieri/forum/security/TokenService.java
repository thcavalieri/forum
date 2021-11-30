package br.com.thiagocavalieri.forum.security;

import br.com.thiagocavalieri.forum.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;

@Service
public class TokenService {

    private Long expiration;
    private String secret;

    public TokenService(@Value("${forum.jwt.expiration}") Long expiration,
                        @Value("${forum.jwt.secret}") String secret) {
        this.expiration = expiration;
        this.secret = secret;
    }

    public String generateToken(User user) {
        var today = Instant.now();

        return Jwts.builder().setIssuer("Forum API")
                .setSubject(user.getId().toString())
                .setIssuedAt(Date.from(today))
                .setExpiration(Date.from(today.plusMillis(expiration)))
                .signWith(SignatureAlgorithm.HS256, secret).compact();
    }

    public boolean isValidToken(String token) {
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Long getIdUser(String token) {
        String userId = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
        return Long.parseLong(userId);
    }
}
