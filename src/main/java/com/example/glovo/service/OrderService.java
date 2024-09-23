package com.example.glovo.service;

import com.example.glovo.dto.ItemDTO;
import com.example.glovo.dto.OrderDTO;
import com.example.glovo.dto.ProductDTO;
import com.example.glovo.entity.ItemEntity;
import com.example.glovo.entity.OrderEntity;
import com.example.glovo.entity.ProductEntity;
import com.example.glovo.mapper.ItemMapper;
import com.example.glovo.mapper.OrderMapper;
import com.example.glovo.mapper.ProductMapper;
import com.example.glovo.repository.ItemRepository;
import com.example.glovo.repository.OrderRepository;
import com.example.glovo.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderService {
    private OrderRepository orderRepository;

    public List<OrderDTO> getAll() {
        return orderRepository.findAll().stream().map(OrderMapper::toDTO).toList();
    }

    public OrderDTO save(OrderDTO orderDTO) {
        return OrderMapper.toDTO(orderRepository.save(OrderMapper.toEntity(orderDTO)));
    }

    public OrderDTO addItem(ItemDTO itemDTO, int orderId) {
        OrderEntity orderEntity = orderRepository.findById(orderId).get();
        ItemEntity itemEntity  = ItemMapper.toEntity(itemDTO);
        itemEntity.setOrder(orderEntity);
        ProductEntity build = ProductEntity.builder().id(itemEntity.getProduct().getId()).build();
        itemEntity.setProduct(build);
        return OrderMapper.toDTO(orderEntity);
    }

    public void delete(int id) {
        orderRepository.deleteById(id);
    }

    public OrderDTO getById(int id) {
        return orderRepository.findById(id).map(OrderMapper::toDTO).orElseThrow();
    }
}
