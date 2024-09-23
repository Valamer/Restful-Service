package com.example.glovo.service;

import com.example.glovo.dto.OrderDTO;
import com.example.glovo.entity.ItemEntity;
import com.example.glovo.entity.OrderEntity;
import com.example.glovo.mapper.OrderMapper;
import com.example.glovo.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderServiceTest {

    private final OrderRepository orderRepository = Mockito.mock(OrderRepository.class);

    @Test
    public void testGetAll() {
        List<ItemEntity> items = List.of(
                new ItemEntity().builder().id(10).build(),
                new ItemEntity().builder().id(20).build(),
                new ItemEntity().builder().id(30).build(),
                new ItemEntity().builder().id(40).build()
        );

        OrderDTO orderDto1 = OrderDTO.builder()
                .id(1)
                .orderNumber(3)
                .itemsId(List.of(10,20,30,40))
                .build();
        OrderDTO orderDto2 = OrderDTO.builder()
                .id(2)
                .orderNumber(4)
                .itemsId(List.of(10,20,30,40))
                .build();
        List<OrderDTO> dtoList = List.of(orderDto1, orderDto2);

        OrderEntity orderEntity1 = OrderEntity.builder()
                .id(1)
                .orderNumber(3)
                .items(items)
                .build();
        OrderEntity orderEntity2 = OrderEntity.builder()
                .id(2)
                .orderNumber(4)
                .items(items)
                .build();
        List<OrderEntity> entityList = List.of(orderEntity1, orderEntity2);

        Mockito.when(orderRepository.findAll()).thenReturn(entityList);
        OrderService orderService = new OrderService(orderRepository);

        assertEquals(dtoList, orderService.getAll());
        Mockito.verify(orderRepository).findAll();
    }

    @Test
    public void testSave() {
        OrderDTO dto = OrderDTO.builder()
                .id(30)
                .orderNumber(20)
                .itemsId(List.of(10,20,30,40))
                .build();
        OrderEntity entity = OrderMapper.toEntity(dto);
        Mockito.when(orderRepository.save(Mockito.any(OrderEntity.class))).thenReturn(entity);

        OrderService orderService = new OrderService(orderRepository);

        assertEquals(dto, orderService.save(dto));

        Mockito.verify(orderRepository).save(Mockito.any(OrderEntity.class));
    }

    @Test
    public void testDelete() {
        OrderService orderService = new OrderService(orderRepository);
        orderService.delete(12);
        Mockito.verify(orderRepository).deleteById(12);
    }

    @Test
    public void testGetById() {
        List<ItemEntity> items = List.of(
                new ItemEntity().builder().id(10).build(),
                new ItemEntity().builder().id(20).build(),
                new ItemEntity().builder().id(30).build(),
                new ItemEntity().builder().id(40).build()
        );
        OrderEntity entity = OrderEntity.builder()
                .id(30)
                .orderNumber(20)
                .items(items)
                .build();

        OrderDTO dto = OrderDTO.builder()
                .id(1)
                .orderNumber(20)
                .itemsId(List.of(10,20,30,40))
                .build();

        Mockito.when(orderRepository.findById(1)).thenReturn(Optional.ofNullable(entity));
        OrderService orderService = new OrderService(orderRepository);

        assertEquals(dto, orderService.getById(1));
        Mockito.verify(orderRepository).findById(1);
    }
}
