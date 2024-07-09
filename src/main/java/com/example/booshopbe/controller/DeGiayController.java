package com.example.booshopbe.controller;

import com.example.booshopbe.apirespone.ApiRespone;
import com.example.booshopbe.entity.DeGiay;
import com.example.booshopbe.entity.KhuyenMai;
import com.example.booshopbe.entity.KichCo;
import com.example.booshopbe.service.DeGiayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/degiay")
public class DeGiayController {
    @Autowired
    DeGiayService deGiayService;
    @GetMapping("/all")
    public ApiRespone<List> getAll(){
        ApiRespone apiRespone = new ApiRespone();
        apiRespone.setResult(deGiayService.getAll());
        apiRespone.setCode(200);
        apiRespone.setMessage("Success");
        return apiRespone;
    }
    @PostMapping("/add")
    public ApiRespone<DeGiay> insert(@RequestBody DeGiay deGiay){
        ApiRespone apiRespone = new ApiRespone();
        apiRespone.setResult(deGiayService.insert(deGiay));
        apiRespone.setCode(200);
        apiRespone.setMessage("Success");
        return apiRespone;
    }

    @PutMapping("/{id}")
    public ApiRespone<DeGiay> update(@PathVariable("id") UUID id, @RequestBody DeGiay deGiay){
        ApiRespone apiRespone = new ApiRespone();
        apiRespone.setResult(deGiayService.update(id,deGiay));
        apiRespone.setCode(200);
        apiRespone.setMessage("Success");
        return apiRespone;
    }

    @DeleteMapping("/{id}")
    public ApiRespone<?> delete(@PathVariable("id") UUID id){
        deGiayService.deleteById(id);
        ApiRespone apiRespone = new ApiRespone();
        apiRespone.setResult("Xoa Thanh Cong");
        apiRespone.setCode(200);
        apiRespone.setMessage("Success");
        return apiRespone;
    }

    @GetMapping("/{id}")
    public ApiRespone<DeGiay> getDetail(@PathVariable("id") UUID id){
        ApiRespone apiRespone = new ApiRespone();
        apiRespone.setResult(deGiayService.findById(id));
        apiRespone.setCode(200);
        apiRespone.setMessage("Success");
        return apiRespone;
    }
}
