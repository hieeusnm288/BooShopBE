package com.example.booshopbe.controller;

import com.example.booshopbe.apirespone.ApiRespone;
import com.example.booshopbe.config.ConfigVNPAY;
import com.example.booshopbe.dto.PaymentRequest;
import com.example.booshopbe.entity.ChiTietHoaDon;
import com.example.booshopbe.entity.ChiTietSanPham;
import com.example.booshopbe.entity.HoaDon;
import com.example.booshopbe.responsitory.ChiTietHoaDonRepository;
import com.example.booshopbe.responsitory.HoaDonRepository;
import com.example.booshopbe.service.VNPayService;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.codec.binary.Hex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

@RestController
@RequestMapping("/api/v1/payment")
public class ThanhToanController {
    @Autowired
    private VNPayService vnpayService;


    @PostMapping("/create")
    public ResponseEntity<ApiRespone<?>> createPayment(HttpServletRequest request, @RequestBody PaymentRequest paymentRequest) throws UnsupportedEncodingException {

        String paymentUrl = vnpayService.generatePaymentUrl(paymentRequest, request);
        ApiRespone apiRespone = new ApiRespone();
        apiRespone.setResult(paymentUrl);
        apiRespone.setCode(200);
        apiRespone.setMessage("Ok");
        return ResponseEntity.ok(apiRespone);
    }

}
