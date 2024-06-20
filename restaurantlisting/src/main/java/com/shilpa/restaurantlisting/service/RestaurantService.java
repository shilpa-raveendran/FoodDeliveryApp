package com.shilpa.restaurantlisting.service;

import com.shilpa.restaurantlisting.dto.RestaurantDTO;
import com.shilpa.restaurantlisting.entity.Restaurant;
import com.shilpa.restaurantlisting.mapper.RestaurantMapper;
import com.shilpa.restaurantlisting.repo.RestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {

    @Autowired
    RestaurantRepo restaurantRepo;

    public List<RestaurantDTO> findAllRestaurants() {
        List<Restaurant> listOfRestaurants= restaurantRepo.findAll();
        //Map restaurants to restaurantDTO
        List<RestaurantDTO> lisOfRestDTO = listOfRestaurants.stream().map(restaurant ->
                RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDTO(restaurant)).toList();
        return lisOfRestDTO;
    }

    public RestaurantDTO addRestaurant(RestaurantDTO restaurantDTO) {
        Restaurant newRestaurant= restaurantRepo.save(RestaurantMapper.INSTANCE.mapRestaurantDTOToRestaurant(restaurantDTO));
        return RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDTO(newRestaurant);
    }

    public ResponseEntity<RestaurantDTO> getRestaurantById(int restaurantDTOId) {
        Optional<Restaurant> restaurant =restaurantRepo.findById(restaurantDTOId);
        if(restaurant.isPresent()){
            return  new ResponseEntity<>(RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDTO(restaurant.get()), HttpStatus.OK);
        }else{
            return  new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }
}
