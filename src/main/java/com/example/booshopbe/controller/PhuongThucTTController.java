package com.example.booshopbe.controller;

import com.example.booshopbe.apirespone.ApiRespone;
import com.example.booshopbe.entity.PhuongThucThanhToan;
import com.example.booshopbe.service.PhuongThucTTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pttt")
public class PhuongThucTTController {
    @Autowired
    PhuongThucTTService service;

    @GetMapping("/all")
    public ApiRespone<List> getAll(){
        ApiRespone apiRespone = new ApiRespone();
        apiRespone.setResult(service.getAll());
        apiRespone.setCode(200);
        apiRespone.setMessage("Success");
        return apiRespone;
    }

    @PostMapping("/add")
    public ApiRespone<PhuongThucThanhToan> insert(@RequestBody PhuongThucThanhToan phuongThucThanhToan){
        ApiRespone apiRespone = new ApiRespone();
        apiRespone.setResult(service.insert(phuongThucThanhToan));
        apiRespone.setCode(200);
        apiRespone.setMessage("Success");
        return apiRespone;
    }

    @PutMapping("/{id}")
    public ApiRespone<PhuongThucThanhToan> update(@PathVariable("id") int id, @RequestBody PhuongThucThanhToan phuongThucThanhToan){
        ApiRespone apiRespone = new ApiRespone();
        apiRespone.setResult(service.update(id,phuongThucThanhToan));
        apiRespone.setCode(200);
        apiRespone.setMessage("Success");
        return apiRespone;
    }

    @DeleteMapping("/{id}")
    public ApiRespone<?> delete(@PathVariable("id") int id){
        service.deleteById(id);
        ApiRespone apiRespone = new ApiRespone();
        apiRespone.setResult("Xoa Thanh Cong");
        apiRespone.setCode(200);
        apiRespone.setMessage("Success");
        return apiRespone;
    }
}
