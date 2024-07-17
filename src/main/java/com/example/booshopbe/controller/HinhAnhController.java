package com.example.booshopbe.controller;

import com.example.booshopbe.apirespone.ApiRespone;
import com.example.booshopbe.dto.HinhAnhDTO;
import com.example.booshopbe.entity.HinhAnh;
import com.example.booshopbe.service.HinhAnhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/hinhanh")
public class HinhAnhController {
    @Autowired
    HinhAnhService hinhAnhService;

    @GetMapping("/{id}")
    public ApiRespone<List> getList(@PathVariable("id") UUID id){
        ApiRespone apiRespone = new ApiRespone();
        apiRespone.setResult(hinhAnhService.getListByCTSP(id));
        apiRespone.setCode(200);
        apiRespone.setMessage("Success");
        return apiRespone;
    }

    @PostMapping("/add")
    public ApiRespone<HinhAnh> insert(@ModelAttribute HinhAnhDTO hinhAnhDTO){
        HinhAnh entity = hinhAnhService.insert(hinhAnhDTO);
        hinhAnhDTO.setIdHinhAnh(entity.getIdHinhAnh());
        hinhAnhDTO.setTenhinhanh(entity.getTenhinhanh());
        hinhAnhDTO.setTrangthai(entity.getTrangthai());
        hinhAnhDTO.setIdChiTietSanPham(entity.getChitietsanpham().getIdChiTietSanPham());
        ApiRespone apiRespone = new ApiRespone();
        apiRespone.setResult(hinhAnhDTO);
        apiRespone.setCode(200);
        apiRespone.setMessage("Success");
        return apiRespone;
    }
}
