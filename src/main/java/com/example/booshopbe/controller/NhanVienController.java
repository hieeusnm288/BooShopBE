package com.example.booshopbe.controller;

import com.example.booshopbe.apirespone.ApiRespone;
import com.example.booshopbe.entity.NhanVien;
import com.example.booshopbe.security.JwtResponse;
import com.example.booshopbe.security.LoginRequest;
import com.example.booshopbe.service.JWTService;
import com.example.booshopbe.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/nhanvien")
public class NhanVienController {
    @Autowired
    NhanVienService nhanVienService;

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private JWTService jwtService;

    @GetMapping("/all")
    public ApiRespone<List> getListNhanVien()
    {
        ApiRespone<List> apiRespone = new ApiRespone<>();
        apiRespone.setCode(200);
        apiRespone.setMessage("Success");
        apiRespone.setResult(nhanVienService.getAll());
        return apiRespone;
    }

    @PostMapping("/add")
    public ApiRespone<NhanVien> addNhanVien(@RequestBody NhanVien nhanVien){
        ApiRespone apiRespone = new ApiRespone();
        apiRespone.setResult(nhanVienService.insert(nhanVien));
        apiRespone.setCode(200);
        apiRespone.setMessage("Success");
        return apiRespone;
    }

    @GetMapping("/{id}")
    public ApiRespone<NhanVien> getDetail(@PathVariable("id") UUID id){
        ApiRespone apiRespone = new ApiRespone();
        apiRespone.setResult(nhanVienService.findById(id));
        apiRespone.setCode(200);
        apiRespone.setMessage("Success");
        return apiRespone;
    }

    @PutMapping("/{id}")
    public ApiRespone<NhanVien> updateAccount(@PathVariable("id") UUID id, @RequestBody NhanVien nhanVien){
        ApiRespone apiRespone = new ApiRespone();
        apiRespone.setResult(nhanVienService.updateNhanhVien(id, nhanVien));
        apiRespone.setCode(200);
        apiRespone.setMessage("Success");
        return apiRespone;
    }

    @DeleteMapping("/{id}")
    public ApiRespone<NhanVien> deleteAccount(@PathVariable("id") UUID id){
        ApiRespone apiRespone = new ApiRespone();
        nhanVienService.deleteNhanVien(id);
        apiRespone.setResult("Xóa Thành công");
        apiRespone.setCode(200);
        apiRespone.setMessage("Success");
        return apiRespone;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest){
        // Xac thuc nguoi dung bang username va password
        try {
            Authentication authentication = manager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
            );
            // Neu xac thuc thah cong tao jwt
            if (authentication.isAuthenticated()){
                final String jwt = jwtService.generateToken(loginRequest.getUsername());
                return ResponseEntity.ok().body(new JwtResponse(jwt));
            }
        }catch (AuthenticationException e){
            return ResponseEntity.badRequest().body("Login Fail, Username or Password Incorrect");
        }
        return ResponseEntity.badRequest().body("Login Fail");
    }

}
