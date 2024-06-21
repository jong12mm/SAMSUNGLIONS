//package com.example.sl.utils;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//
//import java.util.Date;
//
//public class JwtUtil {
//
//    public static String getUserName(String token, String secretKey) {
//        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token)
//                .getBody().get("userName",String.class);
//    }
////    public static String getRole(String token, String secretKey) {
////        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token)
////                .getBody().get("role",String.class);
////    }
//
//    public static boolean isExpired(String token, String secretKey) {
//       return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getExpiration().before(new Date());
//    }
//
//    public static String createJwt(String userName, String role, String secretKey, long expiredMs) {
//        Claims claims = Jwts.claims();
//        claims.put("userName",userName);
//        claims.put("role",role);
//
//
//        return Jwts.builder()
//                .setClaims(claims)
//                .setIssuedAt(new Date(System.currentTimeMillis()))
//                .setExpiration(new Date(System.currentTimeMillis() + expiredMs))
//                .signWith(SignatureAlgorithm.HS256, secretKey)
//                .compact();
//    }
//
//}
