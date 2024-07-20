package com.example.glovo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity {
    private int id;
    private String name;
    private double price;
    private String description;
    private LocalDate createDate;

}
