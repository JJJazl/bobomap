package com.example.bobomap.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Marker {
//    private String id;
    private String name;
    private double latitude;
    private double longitude;
}
