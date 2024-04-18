package com.example.bobomap.dto;

import lombok.Data;

@Data
public class UserLocationDto {
    private long latitude;
    private long longitude;
    private String username;
}
