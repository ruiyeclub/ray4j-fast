package top.ray4j.manage.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;

import static top.ray4j.manage.interceptor.AuthorizationInterceptor.USERNAME_KEY;
import static top.ray4j.manage.interceptor.AuthorizationInterceptor.USER_KEY;

/**
 * jwt工具类
 *
 * @author: Cr.
 * @date: 2022/7/29
 */
@Slf4j
@ConfigurationProperties(prefix = "ray4j.jwt")
@Component
@Data
public class JwtUtils {

    private String secret;
    private long expire;
    private String header;

    public static final String SUBJECT = "cr.";

    public String generateToken(long userId, String username) {
        Date nowDate = new Date();
        // 过期时间
        Date expireDate = new Date(nowDate.getTime() + expire * 1000);

        return Jwts.builder().setSubject(SUBJECT)
                .claim(USER_KEY, userId)
                .claim(USERNAME_KEY, username)
                .setIssuedAt(nowDate)
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS256, secret).compact();
    }

    public Claims getClaimByToken(String token) {
        try {
            return Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            log.error("validate is token error ", e);
            return null;
        }
    }

    /**
     * token是否过期
     *
     * @return true：过期
     */
    public boolean isTokenExpired(Date expiration) {
        return expiration.before(new Date());
    }

}
