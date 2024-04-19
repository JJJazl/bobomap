package com.example.bobomap.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Marker {
    private String name;
    private String latitude;
    private String longitude;
}
