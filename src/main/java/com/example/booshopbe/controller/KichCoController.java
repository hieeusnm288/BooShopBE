package com.example.booshopbe.controller;

import com.example.booshopbe.apirespone.ApiRespone;
import com.example.booshopbe.entity.KhuyenMai;
import com.example.booshopbe.entity.KichCo;
import com.example.booshopbe.entity.MauSac;
import com.example.booshopbe.entity.PhuongThucThanhToan;
import com.example.booshopbe.service.KichCoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/kichco")
public class KichCoController {
    @Autowired
    KichCoService kichCoService;

    @GetMapping("/all")
    public ApiRespone<List> getAll(){
        ApiRespone apiRespone = new ApiRespone();
        apiRespone.setResult(kichCoService.getAll());
        apiRespone.setCode(200);
        apiRespone.setMessage("Success");
        return apiRespone;
    }
    @PostMapping("/add")
    public ApiRespone<KichCo> insert(@RequestBody KichCo kichCo){
        ApiRespone apiRespone = new ApiRespone();
        apiRespone.setResult(kichCoService.insert(kichCo));
        apiRespone.setCode(200);
        apiRespone.setMessage("Success");
        return apiRespone;
    }

    @PutMapping("/{id}")
    public ApiRespone<KichCo> update(@PathVariable("id") UUID id, @RequestBody KichCo kichCo){
        ApiRespone apiRespone = new ApiRespone();
        apiRespone.setResult(kichCoService.update(id,kichCo));
        apiRespone.setCode(200);
        apiRespone.setMessage("Success");
        return apiRespone;
    }

    @DeleteMapping("/{id}")
    public ApiRespone<?> delete(@PathVariable("id") UUID id){
        kichCoService.deleteById(id);
        ApiRespone apiRespone = new ApiRespone();
        apiRespone.setResult("Xoa Thanh Cong");
        apiRespone.setCode(200);
        apiRespone.setMessage("Success");
        return apiRespone;
    }
    @GetMapping("/{id}")
    public ApiRespone<KichCo> getDetail(@PathVariable("id") UUID id){
        ApiRespone apiRespone = new ApiRespone();
        apiRespone.setResult(kichCoService.findById(id));
        apiRespone.setCode(200);
        apiRespone.setMessage("Success");
        return apiRespone;
    }
}
