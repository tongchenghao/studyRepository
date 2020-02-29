package net.tch.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Map;
import java.util.UUID;

/**
 * @description:jwt工具类
 * @auth tongchenghao
 * @date 2020/2/26
 */
public class JwtTokenUtils {

    public static void main(String[] args) {
        System.out.println(UUID.randomUUID().toString().replace("-",""));
    }

    private static Key generatorKey(){
        SignatureAlgorithm saa = SignatureAlgorithm.HS256;
        byte[] bin = DatatypeConverter.parseBase64Binary("5be9c59a8c4740dda65df67537bf2451");
        Key key = new SecretKeySpec(bin, saa.getJcaName());
        return key;
    }

    public static String generatorToken(Map<String,Object> payLoad){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Key key = generatorKey();
            // 设置加密算法为SignatureAlgorithm.HS256，密钥为5be9c59a8c4740dda65df67537bf2451
            String compact = Jwts.builder().setPayload(objectMapper.writeValueAsString(payLoad))
                    .signWith(SignatureAlgorithm.HS256, key)
                    .compact();
            return compact;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Claims phaseToken(String token){
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(generatorKey()).parseClaimsJws(token);
        return claimsJws.getBody();
    }
}
