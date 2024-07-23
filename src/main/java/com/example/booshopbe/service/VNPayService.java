package com.example.booshopbe.service;

import com.example.booshopbe.config.ConfigVNPAY;
import com.example.booshopbe.dto.PaymentRequest;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class VNPayService {
    public String generatePaymentUrl(PaymentRequest paymentRequest, HttpServletRequest request) throws UnsupportedEncodingException {
        Calendar cld = Calendar.getInstance(TimeZone.getTimeZone("Etc/GMT+7"));
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        String vnp_CreateDate = formatter.format(cld.getTime());
        cld.add(Calendar.MINUTE, 15);
        long amount = paymentRequest.getAmount();
        String vnp_ExpireDate = formatter.format(cld.getTime());
        Map<String, String> vnp_Params = new HashMap<>();
        vnp_Params.put("vnp_Version", ConfigVNPAY.vnp_Version);
        vnp_Params.put("vnp_Command", ConfigVNPAY.vnp_Command);
        vnp_Params.put("vnp_TmnCode", ConfigVNPAY.vnp_TmnCode);
        vnp_Params.put("vnp_Amount", String.valueOf(amount * 100));
        vnp_Params.put("vnp_BankCode", ConfigVNPAY.vnp_BankCode);
        vnp_Params.put("vnp_CreateDate", vnp_CreateDate);
        vnp_Params.put("vnp_CurrCode", ConfigVNPAY.vnp_CurrCode);
        vnp_Params.put("vnp_IpAddr", ConfigVNPAY.getIpAddress(request));
        vnp_Params.put("vnp_Locale", ConfigVNPAY.vnp_Locale);
        vnp_Params.put("vnp_OrderInfo", "oderInfo");
        vnp_Params.put("vnp_OrderType", "Thanh toan hoa don");
        vnp_Params.put("vnp_ReturnUrl", ConfigVNPAY.vnp_ReturnUrl);
        vnp_Params.put("vnp_TxnRef", ConfigVNPAY.getRandomNumber(6));
        vnp_Params.put("vnp_ExpireDate", vnp_ExpireDate);

        List<String> fieldList = new ArrayList<>(vnp_Params.keySet());
        Collections.sort(fieldList);

        StringBuilder hashData = new StringBuilder();
        StringBuilder query = new StringBuilder();

        for (String fieldName : fieldList) {
            String fieldValue = vnp_Params.get(fieldName);
            if (fieldValue != null && fieldValue.length() > 0) {
                hashData.append(fieldName).append('=').append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString())).append('&');
                query.append(URLEncoder.encode(fieldName, StandardCharsets.US_ASCII.toString())).append('=').append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString())).append('&');
            }
        }
        query.deleteCharAt(query.length() - 1);
        hashData.deleteCharAt(hashData.length() - 1);

        String queryUrl = query.toString();
        String vnp_SecureHash = ConfigVNPAY.hmacSHA512(ConfigVNPAY.secretKey, hashData.toString());
        queryUrl += "&vnp_SecureHash=" + vnp_SecureHash;
        return ConfigVNPAY.vnp_PayUrl + "?" + queryUrl;
    }

    public boolean validateTransaction(String txnRef, String vnpSecureHash, Map<String, String> allParams) {
        List<String> fieldNames = new ArrayList<>(allParams.keySet());
        Collections.sort(fieldNames);
        StringBuilder hashData = new StringBuilder();
        for (String fieldName : fieldNames) {
            if (!"vnp_SecureHash".equals(fieldName)) {
                hashData.append(fieldName).append('=').append(allParams.get(fieldName)).append('&');
            }
        }
        hashData.deleteCharAt(hashData.length() - 1);
        String hashValue = ConfigVNPAY.hmacSHA512(ConfigVNPAY.secretKey, hashData.toString());
        return hashValue.equals(vnpSecureHash);
    }

    public String getTransactionStatus(String txnRef) {
        // Implement the code to call VNPay API to check the transaction status
        // Return "00" for success, other codes for failure
        return "00";
    }
}
