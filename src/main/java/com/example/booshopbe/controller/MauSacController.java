package com.example.booshopbe.controller;

import com.example.booshopbe.apirespone.ApiRespone;
import com.example.booshopbe.entity.KhuyenMai;
import com.example.booshopbe.entity.MauSac;
import com.example.booshopbe.entity.PhuongThucThanhToan;
import com.example.booshopbe.service.MauSacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/mausac")
public class MauSacController {
    @Autowired
    MauSacService mauSacService;

    @GetMapping("/all")
    public ApiRespone<List> getAll(){
        ApiRespone apiRespone = new ApiRespone();
        apiRespone.setResult(mauSacService.getAll());
        apiRespone.setCode(200);
        apiRespone.setMessage("Success");
        return apiRespone;
    }

    @PostMapping("/add")
    public ApiRespone<MauSac> insert(@RequestBody MauSac mauSac){
        ApiRespone apiRespone = new ApiRespone();
        apiRespone.setResult(mauSacService.insert(mauSac));
        apiRespone.setCode(200);
        apiRespone.setMessage("Success");
        return apiRespone;
    }
    @PutMapping("/{id}")
    public ApiRespone<PhuongThucThanhToan> update(@PathVariable("id") UUID id, @RequestBody MauSac mauSac){
        ApiRespone apiRespone = new ApiRespone();
        apiRespone.setResult(mauSacService.update(id,mauSac));
        apiRespone.setCode(200);
        apiRespone.setMessage("Success");
        return apiRespone;
    }

    @DeleteMapping("/{id}")
    public ApiRespone<?> delete(@PathVariable("id") UUID id){
        mauSacService.deleteById(id);
        ApiRespone apiRespone = new ApiRespone();
        apiRespone.setResult("Xoa Thanh Cong");
        apiRespone.setCode(200);
        apiRespone.setMessage("Success");
        return apiRespone;
    }

    @GetMapping("/{id}")
    public ApiRespone<MauSac> getDetail(@PathVariable("id") UUID id){
        ApiRespone apiRespone = new ApiRespone();
        apiRespone.setResult(mauSacService.findById(id));
        apiRespone.setCode(200);
        apiRespone.setMessage("Success");
        return apiRespone;
    }

    @GetMapping("/find")
    public ApiRespone<MauSac> getDetailbyName(@RequestParam(required = false) String name){
        ApiRespone apiRespone = new ApiRespone();
        apiRespone.setResult(mauSacService.findByName(name));
        apiRespone.setCode(200);
        apiRespone.setMessage("Success");
        return apiRespone;
    }
}
