package com.example.glovo.mapper;

import com.example.glovo.dto.OrderDTO;
import com.example.glovo.entity.ItemEntity;
import com.example.glovo.entity.OrderEntity;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class OrderMapperTest {
    @Test
    public void testToDTO() {
        List<ItemEntity> items = List.of(
                new ItemEntity().builder().id(10).build(),
                new ItemEntity().builder().id(20).build(),
                new ItemEntity().builder().id(30).build(),
                new ItemEntity().builder().id(40).build()
        );
        OrderDTO expected = OrderDTO.builder()
                .id(30)
                .orderNumber(20)
                .itemsId(List.of(10,20,30,40))
                .build();
        OrderEntity entity = OrderEntity.builder()
                .id(30)
                .orderNumber(20)
                .items(items)
                .build();
        assertEquals(expected, OrderMapper.toDTO(entity));
    }

    @Test
    public void testToEntity() {
        List<ItemEntity> items = List.of(
                new ItemEntity().builder().id(10).build(),
                new ItemEntity().builder().id(20).build(),
                new ItemEntity().builder().id(30).build(),
                new ItemEntity().builder().id(40).build()
        );
        OrderEntity expected = OrderEntity.builder()
                .id(30)
                .orderNumber(20)
                .items(items)
                .build();
        OrderDTO dto = OrderDTO.builder()
                .id(30)
                .orderNumber(20)
                .itemsId(List.of(10,20,30,40))
                .build();
        assertEquals(expected, OrderMapper.toEntity(dto));
    }
}
