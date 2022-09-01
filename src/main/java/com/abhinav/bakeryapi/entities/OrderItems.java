package com.abhinav.bakeryapi.entities;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class OrderItems {
    private String name;
    private int quantity;
    private int price;
}
