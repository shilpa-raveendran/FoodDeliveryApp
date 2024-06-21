package com.shilpa.orderService.repo;

import com.shilpa.orderService.dto.OrderDTO;
import com.shilpa.orderService.entity.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends MongoRepository<Order, Integer > {

}
