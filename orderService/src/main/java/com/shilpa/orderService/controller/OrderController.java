package com.shilpa.orderService.controller;

import com.shilpa.orderService.dto.OrderDTO;
import com.shilpa.orderService.dto.OrderDTOFromUI;
import com.shilpa.orderService.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/saveOrder")
    public ResponseEntity<OrderDTO> saveOrder(@RequestBody OrderDTOFromUI orderDetails){
        OrderDTO saveOrder= orderService.saveorderInfo(orderDetails);
        return new ResponseEntity<>(saveOrder, HttpStatus.OK);
    }
}
