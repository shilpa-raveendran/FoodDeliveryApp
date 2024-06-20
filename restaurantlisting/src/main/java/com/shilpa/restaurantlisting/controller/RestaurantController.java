package com.shilpa.restaurantlisting.controller;

import com.shilpa.restaurantlisting.dto.RestaurantDTO;
import com.shilpa.restaurantlisting.entity.Restaurant;
import com.shilpa.restaurantlisting.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;

    @GetMapping("/fetchAllRestaurant")
    public ResponseEntity<List<RestaurantDTO>> getRestaurant(){
        List<RestaurantDTO> allRestaurants= restaurantService.findAllRestaurants();
        return new ResponseEntity<>(allRestaurants, HttpStatus.OK);
    }

    @PostMapping("/addRestaurants")
    public ResponseEntity<RestaurantDTO> addRestaurant(@RequestBody RestaurantDTO restaurantDTO){
        RestaurantDTO addRestaurants= restaurantService.addRestaurant(restaurantDTO);
        return new ResponseEntity<>(addRestaurants, HttpStatus.OK);
    }

    @GetMapping("/getRestaurantById/{restaurantDTO_Id}")
    public ResponseEntity<RestaurantDTO> getRestaurantById(@PathVariable int restaurantDTO_Id){
            return restaurantService.getRestaurantById(restaurantDTO_Id);
    }
}
