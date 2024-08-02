package com.example.glovo.mapper;

import com.example.glovo.dto.ItemDTO;
import com.example.glovo.entity.ItemEntity;
import com.example.glovo.entity.OrderEntity;
import com.example.glovo.entity.ProductEntity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ItemMapperTest {
    @Test
    public void testToDTO() {
        ItemDTO expected = ItemDTO.builder()
                .id(10)
                .quantity(3)
                .productId(60)
                .build();
        ItemEntity entity = ItemEntity.builder()
                .id(10)
                .quantity(3)
                .product(new ProductEntity().builder().id(60).build())
                .order(new OrderEntity())
                .build();
        assertEquals(expected, ItemMapper.toDTO(entity));
    }

    @Test
    public void testToEntity() {
        ItemEntity expected = ItemEntity.builder()
                .id(10)
                .quantity(3)
                .product(new ProductEntity().builder().id(60).build())
                .order(new OrderEntity()).build();
        ItemDTO dto = ItemDTO.builder()
                .id(10)
                .quantity(3)
                .productId(60)
                .build();
        assertEquals(expected, ItemMapper.toEntity(dto));
    }
}
