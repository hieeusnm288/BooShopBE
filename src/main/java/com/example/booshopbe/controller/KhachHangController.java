package com.example.booshopbe.controller;

import com.example.booshopbe.apirespone.ApiRespone;
import com.example.booshopbe.entity.KhachHang;
import com.example.booshopbe.entity.NhanVien;
import com.example.booshopbe.security.JwtResponse;
import com.example.booshopbe.security.LoginRequest;
import com.example.booshopbe.service.JWTService;
import com.example.booshopbe.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/khachhang")
public class KhachHangController {
    @Autowired
    KhachHangService khachHangService;

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private JWTService jwtService;

    @GetMapping("/all")
    public ApiRespone<List> getListKhachHang()
    {
        ApiRespone<List> apiRespone = new ApiRespone<>();
        apiRespone.setCode(200);
        apiRespone.setMessage("Success");
        apiRespone.setResult(khachHangService.getAll());
        return apiRespone;
    }

    @GetMapping("/{id}")
    public ApiRespone<KhachHang> getDetail(@PathVariable("id") UUID id){
        ApiRespone apiRespone = new ApiRespone();
        apiRespone.setResult(khachHangService.findById(id));
        apiRespone.setCode(200);
        apiRespone.setMessage("Success");
        return apiRespone;
    }

    @PostMapping("/add")
    public ApiRespone<KhachHang> addKhachHang(@RequestBody KhachHang khachHang){
        ApiRespone apiRespone = new ApiRespone();
        apiRespone.setResult(khachHangService.insert(khachHang));
        apiRespone.setCode(200);
        apiRespone.setMessage("Success");
        return apiRespone;
    }

    @PutMapping("/{id}")
    public ApiRespone<KhachHang> updateKhachHang(@PathVariable("id") UUID id, @RequestBody KhachHang khachHang){
        ApiRespone apiRespone = new ApiRespone();
        apiRespone.setResult(khachHangService.updateKhachHang(id, khachHang));
        apiRespone.setCode(200);
        apiRespone.setMessage("Success");
        return apiRespone;
    }

    @DeleteMapping("/{id}")
    public ApiRespone<KhachHang> deleteKhachHang(@PathVariable("id") UUID id){
        ApiRespone apiRespone = new ApiRespone();
        khachHangService.deleteKhachHang(id);
        apiRespone.setResult("Xóa Thành công");
        apiRespone.setCode(200);
        apiRespone.setMessage("Success");
        return apiRespone;
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest){
        // Xac thuc nguoi dung bang username va password
        KhachHang khachHang = khachHangService.findByUsername(loginRequest.getUsername());
        try {
            Authentication authentication = manager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
            );
            // Neu xac thuc thah cong tao jwt
            if (authentication.isAuthenticated()){
                final String jwt = jwtService.generateTokenKH(khachHang);
                return ResponseEntity.ok().body(new JwtResponse(jwt));
            }
        }catch (AuthenticationException e){
            return ResponseEntity.badRequest().body("Login Fail, Username or Password Incorrect");
        }
        return ResponseEntity.badRequest().body("Login Fail");
    }
}
