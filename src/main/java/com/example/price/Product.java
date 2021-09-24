package com.example.price;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Product {

    private final String name;

    private int price;
}
