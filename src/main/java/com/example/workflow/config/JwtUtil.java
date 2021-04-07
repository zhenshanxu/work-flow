package com.example.workflow.config;

import com.example.workflow.utils.CommonUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.tomcat.util.codec.binary.Base64;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Date;

/**
 * @author 作者 : ZhenShanXu
 * @version 创建时间:2020/7/21 16:31.
 *修订记录
 *功能说明：jwt token 工具类
 *
 **/
public class JwtUtil {


    /**
     * 生成签名,15分钟过期
     *
     * @param userId
     * @return
     */
    public static String createJWT(int userId, String subject) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        //设置过期时间
        Long presentTime = System.currentTimeMillis();
        Date issuedAtTime = new Date(presentTime);
        Date expirationTime = new Date(presentTime + CommonUtil.TOKEN_EXPIRE_TIME);

        SecretKey secretKey = generalKey();
        JwtBuilder builder = Jwts.builder()
                .setId(String.valueOf(userId))
                // 主题
                .setSubject(subject)
                // 签发者
                .setIssuer(CommonUtil.JWT_ID)
                // 签发时间
                .setIssuedAt(issuedAtTime)
                // 签名算法以及密匙
                .signWith(signatureAlgorithm, secretKey)
                // 过期时间
                .setExpiration(expirationTime);
        return builder.compact();
    }

    /**
     * 验证JWT
     *
     * @param jwtStr
     * @return
     */
    public Claims validateJWT(String jwtStr) {
        //签名秘钥，和生成的签名的秘钥一模一样
        SecretKey key = generalKey();
        Claims claims = Jwts.parser()
                .setSigningKey(key)
                .parseClaimsJws(jwtStr).getBody();
        return claims;

    }

    /**
     * 设置key值
     *
     * @return
     */
    public static SecretKey generalKey() {
        String stringKey = CommonUtil.TOKEN_SECRET;
        byte[] encodedKey = Base64.decodeBase64(stringKey);
        SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
        return key;
    }

    public static void main(String[] args) {
        String JWT = createJWT(1, "username");
        System.out.println("测试token:" + JWT);
//        String jwt = "" +
//                "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIxIiwic3ViIjoidXNlcm5hbWUiLCJpc3MiOiJlMzBmN2U4Yy0wODY5LTQ5NDItYjk5Yy01ZDBlYWQwN2ZjMGEiLCJpYXQiOjE1OTUzMjA0MzIsImV4cCI6MTU5NTkyNTIzMn0.f_v1dN3YPoH9rez-Tb2i0w4BuP1yIul_FA7rWYam-So";
//        JwtUtil jwtUtil = new JwtUtil();
//        Claims c = jwtUtil.validateJWT(jwt);
//        System.out.println(c.getId());
//        System.out.println(c.getIssuedAt());
//        System.out.println(c.getSubject());

    }

}
