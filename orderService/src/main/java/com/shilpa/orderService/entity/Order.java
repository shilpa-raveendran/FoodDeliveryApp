package com.shilpa.orderService.entity;

import com.shilpa.orderService.dto.FoodItemDTO;
import com.shilpa.orderService.dto.RestaurantDTO;
import com.shilpa.orderService.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("order")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private Integer orderId;
    private List<FoodItemDTO> foodItemList;
    private RestaurantDTO restaurant;
    private UserDTO user;

}
