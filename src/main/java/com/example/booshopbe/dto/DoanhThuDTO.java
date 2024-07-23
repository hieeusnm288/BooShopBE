package com.example.booshopbe.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DoanhThuDTO {
    private int tongDoanhThu;
    private Date nam;
    private Date thang;
}
