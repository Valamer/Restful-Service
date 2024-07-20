package com.example.glovo.service;

import com.example.glovo.dto.ItemDTO;
import com.example.glovo.dto.OrderDTO;
import com.example.glovo.entity.OrderEntity;
import com.example.glovo.mapper.OrderMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderService {
    private List<OrderEntity> orders;
    private final ItemService itemService;

    public List<OrderDTO> getAll() {
        return orders.stream().map(OrderMapper::toDTO).toList();
    }

    public OrderDTO save(OrderDTO orderDTO) {
        orders.add(OrderMapper.toEntity(orderDTO));
        return orderDTO;
    }

    public OrderDTO addItem(ItemDTO itemDTO, int orderId) {
        OrderEntity orderEntity = orders.get(orderId);
        itemService.save(itemDTO);
        orderEntity.getItemsId().add(itemDTO.getId());
        return OrderMapper.toDTO(orderEntity);
    }

    public void delete(int id) {
        List<Integer> items = orders.get(id).getItemsId();
        for (Integer itemId : items) {
            itemService.delete(itemId);
        }
        OrderEntity orderEntity = orders.stream().filter(order -> order.getId() == id).findFirst().get();
        orders.remove(orderEntity);
    }

    public OrderDTO getById(int id) {
        OrderEntity orderEntity = orders.stream().filter(order -> order.getId() == id).findFirst().get();
        return OrderMapper.toDTO(orderEntity);
    }
}
