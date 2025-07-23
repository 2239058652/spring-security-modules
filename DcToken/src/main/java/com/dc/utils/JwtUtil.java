package src.main.java.com.dc.utils;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;

public class JwtUtil {
    //有效期
    public static final long EXPIRE = 1000 * 60 * 60 * 24; // 24小时
    //设置密钥
    public static final String APP_SECRET = "ukc8BDbRigUD8zkq";

    public static String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     * 生成jwt
     *
     * @param subject  token中保存的数据（json）
     * @param ttMillis 过期时间
     * @return token
     */
    public static String createJWT(String subject, Long ttMillis) {
        return getJwtBuilder(subject, ttMillis, getUUID()).compact(); //设置过期时间
    }

    private static JwtBuilder getJwtBuilder(String subject, Long ttMillis, String uuid) {
        return Jwts.builder()
                .setId(uuid)
                .setSubject(subject)
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, APP_SECRET)
                .setExpiration(new Date(System.currentTimeMillis() + ttMillis));
    }

    /**
     * 创建token
     *
     */
    public static String createJWT(String id, String subject, Long ttlMillis) {
        JwtBuilder builder = getJwtBuilder(subject, ttlMillis, id);//设置过期时间
        return builder.compact();
    }

    public static void main(String[] args) throws Exception {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIwMjY3ZjU2MC1kNjY0LTQwMjgtYjY5Ny1hZjE1ZjU4MjY2MzciLCJzdWIiOiJzZyIsImlhdCI6MTY2";
        Claims claims = parseJWT(token);
        System.out.println(claims);
    }

    /**
     * 生成加密后的密钥secretKey
     * @return 加密后的密钥secretKey
     * */
    public static SecretKey generateKey(){
        byte[] encodedKey = Base64.getEncoder().encode(APP_SECRET.getBytes());
        return new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
    }

    /**
     * 解析jwt
     *
     * @param jwt token
     * @return Claims
     * @throws Exception 异常
     */
    public static Claims parseJWT(String jwt) throws Exception {
        SecretKey secretKey = generateKey();
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(jwt)
                .getBody();
    }

}
