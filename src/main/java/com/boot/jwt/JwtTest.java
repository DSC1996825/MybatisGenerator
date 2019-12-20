package com.boot.jwt;

import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * JWT 测试类
 *
 * @author DSC
 * @date 2019-12-17
 */
public class JwtTest {
    private static Logger logger = LoggerFactory.getLogger(JwtTest.class);

    private final static String key = "CISID";

    public static void main(String[] args) {
//        String jwtToken = createJWT("DSC_001");
        parseJWT("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJEU0NfMDAxIiwicm9sZSI6ImFkbWluIiwidXNlck5hbWUiOiJEU0MiLCJpYXQiOjE1NzY1Njc4ODQsImV4cCI6MTU3NjU2NzkxNH0.04vyNWJZ5PT8Q-BtZhYNtSVzG4rqKQNrbAyEXh7clCU");
    }

    public static String createJWT(String userId) {
        long currentTimeMillis = System.currentTimeMillis();
        JwtBuilder builder = Jwts.builder();
        //存入主体
        builder.setSubject(userId);
        //存入其他信息
        builder.claim("role", "admin");
        builder.claim("userName", "DSC");
        //签发日期
        builder.setIssuedAt(new Date(currentTimeMillis));
        //到期日期
        builder.setExpiration(new Date(currentTimeMillis + (1000 * 30)));
        //加密方式、签名秘钥
        builder.signWith(SignatureAlgorithm.HS256, key);

        String jwtToken = builder.compact();

        System.out.println(jwtToken);

        return jwtToken;
    }

    public static Claims parseJWT(String jwtToken) {
        JwtParser parser = Jwts.parser();
        parser.setSigningKey(key);

        Jws<Claims> claimsJws = parser.parseClaimsJws(jwtToken);
        Claims claims = claimsJws.getBody();

        System.out.println(claims);
        return claims;
    }
}
