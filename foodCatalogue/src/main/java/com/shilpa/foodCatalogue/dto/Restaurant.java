package com.shilpa.foodCatalogue.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Restaurant {
    private int restId;
    private String restName;
    private String address;
    private String city;
    private String restDesc;
}