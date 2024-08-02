package com.example.glovo.mapper;

import com.example.glovo.dto.ProductDTO;
import com.example.glovo.entity.ProductEntity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ProductMapperTest {
    @Test
    public void testToDTO() {
        ProductDTO expected = ProductDTO.builder()
                .id(25)
                .name("Potato")
                .price(30)
                .description("Original Description")
                .build();
        ProductEntity entity = ProductEntity.builder()
                .id(25)
                .name("Potato")
                .price(30)
                .description("Original Description")
                .build();
        assertEquals(expected, ProductMapper.toDTO(entity));
    }

    @Test
    public void testToEntity() {
        ProductEntity expected = ProductEntity.builder()
                .id(25)
                .name("Potato")
                .price(30)
                .description("Original Description")
                .build();
        ProductDTO dto = ProductDTO.builder()
                .id(25)
                .name("Potato")
                .price(30)
                .description("Original Description")
                .build();
        assertEquals(expected, ProductMapper.toEntity(dto));
    }
}
