package com.example.booshopbe.controller;

import com.example.booshopbe.apirespone.ApiRespone;
import com.example.booshopbe.dto.DiaChiDTO;
import com.example.booshopbe.entity.DiaChi;
import com.example.booshopbe.entity.GioHang;
import com.example.booshopbe.service.DiaChiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/diachi")
public class DiaChiController {
    @Autowired
    DiaChiService diaChiService;

    @GetMapping("/find")
    public ApiRespone<List> getList(@RequestParam(required = false) UUID idKhachHang){
        ApiRespone apiRespone = new ApiRespone();
        apiRespone.setResult(diaChiService.getListDiaChi(idKhachHang));
        apiRespone.setCode(200);
        apiRespone.setMessage("Success");
        return apiRespone;
    }

    @PostMapping("/add")
    public ApiRespone<DiaChi> insert(@RequestBody DiaChiDTO dto){
        ApiRespone apiRespone = new ApiRespone();
        apiRespone.setResult(diaChiService.insert(dto));
        apiRespone.setCode(200);
        apiRespone.setMessage("Success");
        return apiRespone;
    }

    @PutMapping("/{id}")
    public ApiRespone<DiaChi> update(@PathVariable("id") UUID id, @RequestBody DiaChiDTO dto){
        ApiRespone apiRespone = new ApiRespone();
        apiRespone.setResult(diaChiService.update(id,dto));
        apiRespone.setCode(200);
        apiRespone.setMessage("Success");
        return apiRespone;
    }

    @GetMapping("/{id}")
    public ApiRespone<DiaChi> getById(@PathVariable("id") UUID id){
        ApiRespone apiRespone = new ApiRespone();
        apiRespone.setResult(diaChiService.getById(id));
        apiRespone.setCode(200);
        apiRespone.setMessage("Success");
        return apiRespone;
    }

    @DeleteMapping("/{id}")
    public ApiRespone<?> delete(@PathVariable("id") UUID id){
        ApiRespone apiRespone = new ApiRespone();
        diaChiService.delete(id);
        apiRespone.setResult("Xóa thành công");
        apiRespone.setCode(200);
        apiRespone.setMessage("Success");
        return apiRespone;
    }
}
