package com.example.booshopbe.controller;

import com.example.booshopbe.apirespone.ApiRespone;
import com.example.booshopbe.entity.TrangThaiHoaDon;
import com.example.booshopbe.responsitory.TrangThaiHoaDonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/trangthaihoadon")
public class TrangThaiHoaDonController {

    @Autowired
    TrangThaiHoaDonRepository repository;

    @PostMapping("/add")
    public ApiRespone<TrangThaiHoaDon> insert(@RequestBody TrangThaiHoaDon trangThaiHoaDon){
        ApiRespone apiRespone = new ApiRespone();
        apiRespone.setResult(repository.save(trangThaiHoaDon));
        apiRespone.setCode(200);
        apiRespone.setMessage("Success");
        return apiRespone;
    }

    @GetMapping("/all")
    public ApiRespone<List> getAll(){
        ApiRespone apiRespone = new ApiRespone();
        apiRespone.setResult(repository.findAll());
        apiRespone.setCode(200);
        apiRespone.setMessage("Success");
        return apiRespone;
    }
}
