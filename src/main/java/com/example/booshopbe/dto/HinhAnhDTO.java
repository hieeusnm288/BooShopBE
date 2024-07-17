package com.example.booshopbe.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HinhAnhDTO {
    private UUID idHinhAnh;
    private String tenhinhanh;
    private int trangthai;
    private UUID idChiTietSanPham;

    @JsonIgnore
    private MultipartFile logoFile;
}
