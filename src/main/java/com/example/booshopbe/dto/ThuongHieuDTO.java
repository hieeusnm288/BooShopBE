package com.example.booshopbe.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Data
public class ThuongHieuDTO {
    private UUID idThuongHieu;
    private String tenthuonghieu;
    private String mota;
    private String hinhanh;
    private int trangthai;
    @JsonIgnore
    private MultipartFile logoFile;

}
