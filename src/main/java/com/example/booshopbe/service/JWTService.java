package com.example.booshopbe.service;

import com.example.booshopbe.entity.KhachHang;
import com.example.booshopbe.entity.NhanVien;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

@Component
public class JWTService {
    public static final String SERECT = "5367566B59703373367639792F423F4528482B4D6251655468576D5A71347437";

    // Tao jwt du tren username NV
    public String generateToken(NhanVien nhanVien){
        Map<String, Objects> claims = new HashMap<>();
        // claims.put("isAdmin", true);
        return createToken(claims, nhanVien);
    }
    //Taok JWT voi cac claims
    private String createToken(Map<String, Objects> claims, NhanVien nhanVien){
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(nhanVien.getUsername())
                .claim("role", nhanVien.getChucvu())
                .claim("username", nhanVien.getUsername())
                .claim("tennhanvien", nhanVien.getTennhanvien())
                .claim("idNhanVien",nhanVien.getIdNhanVien())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() +600*60*1000))
                .signWith(SignatureAlgorithm.HS256, getSignKey())
                .compact();
    }

    // KH
    public String generateTokenKH(KhachHang khachHang){
        Map<String, Objects> claims = new HashMap<>();
        // claims.put("isAdmin", true);
        return createTokenKH(claims, khachHang);
    }


    private String createTokenKH(Map<String, Objects> claims, KhachHang khachHang){
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(khachHang.getUsername())
//                .claim("role", nhanVien.getChucvu())
                .claim("username", khachHang.getUsername())
                .claim("tenKhachHang", khachHang.getTenkhachhang())
                .claim("id" , khachHang.getIdKhachHang())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() +600*60*1000))
                .signWith(SignatureAlgorithm.HS256, getSignKey())
                .compact();
    }

    // Lay SERECT_KEY
    private Key getSignKey(){
        byte[] keyByte = Decoders.BASE64.decode(SERECT);
        return Keys.hmacShaKeyFor(keyByte);
    }

    // Trích xuất thông tin
    private Claims extractAllClaims(String token){
        return Jwts.parser().setSigningKey(getSignKey()).parseClaimsJws(token).getBody();
    }

    // Trích xuất TT cho 1 claims
    public <T>  T extractClaim(String token, Function<Claims, T> claimsTFunction){
        final Claims claims = extractAllClaims(token);
        return claimsTFunction.apply(claims);
    }

    // Kiem tra Token het han
    public Date exTractExpiriration(String token){
        return extractClaim(token,Claims::getExpiration);
    }

    //Lay ra username
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);

    }
    // Kiểm tra cái JWT đã hết hạn
    private Boolean isTokenExpired(String token){
        return exTractExpiriration(token).before(new Date());
    }

    // Kiểm tra tính hợp lệ
    public Boolean validateToken(String token, UserDetails userDetails){
        final String tenDangNhap = extractUsername(token);
        return (tenDangNhap.equals(userDetails.getUsername())&&!isTokenExpired(token));
    }
}

