package com.example.booshopbe.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GioHangDTO {
    private UUID IdGioHang;
    private UUID IdKhachHang;
}
