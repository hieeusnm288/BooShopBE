package com.example.booshopbe.controller;

import com.example.booshopbe.apirespone.ApiRespone;
import com.example.booshopbe.dto.HoaDonDTO;
import com.example.booshopbe.entity.HoaDon;
import com.example.booshopbe.entity.SanPham;
import com.example.booshopbe.service.HoaDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
@EnableSpringDataWebSupport(pageSerializationMode = EnableSpringDataWebSupport.PageSerializationMode.VIA_DTO)
@RestController
@RequestMapping("/api/v1/hoadon")
public class HoaDonController {
    @Autowired
    HoaDonService hoaDonService;

    @GetMapping("/search")
    public ApiRespone<?> getListAll(@RequestParam(required = false) String username , @RequestParam(required = false) int idTrangThai,
                                    @PageableDefault (size = 8, sort = "ngaytao", direction = Sort.Direction.DESC)
                                    Pageable pageable) {
        ApiRespone apiRespone = new ApiRespone<>();
        apiRespone.setCode(200);
        apiRespone.setMessage("Success");
        apiRespone.setResult(hoaDonService.getAll(username,idTrangThai,pageable));
        return apiRespone;
    }

    @GetMapping("/find")
    public ApiRespone<List> getListByKhachHang(@RequestParam(required = false) UUID idKhachHang) {
        ApiRespone<List> apiRespone = new ApiRespone<>();
        apiRespone.setCode(200);
        apiRespone.setMessage("Success");
        apiRespone.setResult(hoaDonService.getByKhachHang(idKhachHang));
        return apiRespone;
    }

    @PostMapping("/add")
    public ApiRespone<HoaDon> insert(@RequestBody HoaDonDTO hoaDonDTO) {
        ApiRespone apiRespone = new ApiRespone<>();
        HoaDon hoaDon = hoaDonService.insert(hoaDonDTO);
        hoaDonDTO.setIdHoaDon(hoaDon.getIdHoaDon());
        apiRespone.setCode(200);
        apiRespone.setMessage("Success");
        apiRespone.setResult(hoaDonDTO);
        return apiRespone;
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") UUID id, @RequestBody HoaDonDTO hoaDonDTO) {
        ApiRespone apiRespone = new ApiRespone<>();
        HoaDon hoaDon = hoaDonService.update(id, hoaDonDTO);
        hoaDonDTO.setIdHoaDon(hoaDon.getIdHoaDon());
        apiRespone.setCode(200);
        apiRespone.setMessage("Success");
        apiRespone.setResult(hoaDonDTO);
        return new ResponseEntity<>(apiRespone, HttpStatus.OK);
    }

}
