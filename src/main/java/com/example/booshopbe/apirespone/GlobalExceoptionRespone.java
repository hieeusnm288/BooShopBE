package com.example.booshopbe.apirespone;

import lombok.Data;

@Data
public class GlobalExceoptionRespone {
    public String message;
    public GlobalExceoptionRespone(String message) {
        this.message = message;
    }
}
