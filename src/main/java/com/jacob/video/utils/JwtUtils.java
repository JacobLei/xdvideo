package com.jacob.video.utils;

import com.jacob.video.domain.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * jwt工具类
 */
public class JwtUtils {

    private static final String SUBJECT =  "jacob";
    private static final long EXPIRE = 1000 * 60 * 60 * 24 * 7;
    private static final String APPSECRET = "jacob";    // 密钥

    /**
     * 生成jwt
     * @param user 用户实体类
     * @return token
     */
    public static String geneJsonWebToken(User user){

        if(user == null || user.getId() == null || user.getName() == null || user.getHeadImg() == null)
            return null;

        String token = Jwts.builder().setSubject(SUBJECT)
                .claim("id", user.getId())
                .claim("name", user.getName())
                .claim("img", user.getHeadImg())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))
                .signWith(SignatureAlgorithm.HS256, APPSECRET).compact();

        return token;
    }

    /**
     * 校验token
     * @param token
     * @return
     */
    public static Claims checkJWT(String token){

        try{
            return Jwts.parser().setSigningKey(APPSECRET).parseClaimsJws(token).getBody();
        }catch (Exception e){
            System.out.println("token校验不通过");
        }
        return null;
    }
}
