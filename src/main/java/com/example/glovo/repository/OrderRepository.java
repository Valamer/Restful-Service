package com.example.glovo.repository;

import com.example.glovo.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {

}

