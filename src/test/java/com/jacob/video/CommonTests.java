package com.jacob.video;

import com.jacob.video.domain.User;
import com.jacob.video.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import org.junit.Test;

public class CommonTests {

    @Test
    public void testGeneJwt(){
        User user = new User();
        user.setId(999);
        user.setName("jacob");
        user.setHeadImg("www.jacob2359.com");

        String token = JwtUtils.geneJsonWebToken(user); // 生成token
        System.out.println("token = " + token);

        Claims claims = JwtUtils.checkJWT(token);   // 解密
        System.out.println(claims);

    }
}
