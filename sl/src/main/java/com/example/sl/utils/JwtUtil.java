//package com.example.sl.utils;
//
//import io.jsonwebtoken.*;
//
//public class JwtUtil {
//    private static final String SECRET_KEY = "your_secret_key";
//
//    public static Claims parseToken(String token) {
//        try {
//            return Jwts.parser()
//                    .setAllowedClockSkewSeconds(60) // 60초 클럭 스큐 허용
//                    .setSigningKey(SECRET_KEY)
//                    .parseClaimsJws(token)
//                    .getBody();
//        } catch (ExpiredJwtException e) {
//            // JWT가 만료된 경우의 처리 로직
//            throw e;
//        }
//    }
//}
