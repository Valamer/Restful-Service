package com.example.glovo.service;

import com.example.glovo.dto.ProductDTO;
import com.example.glovo.entity.ProductEntity;
import com.example.glovo.mapper.ProductMapper;
import com.example.glovo.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductServiceTest {

    private final ProductRepository productRepository = Mockito.mock(ProductRepository.class);

    @Test
    public void testGetAll() {
        ProductDTO productDto1 = ProductDTO.builder()
                .id(1)
                .name("Tomato")
                .price(20)
                .description("Original Description")
                .build();
        ProductDTO productDto2 = ProductDTO.builder()
                .id(2)
                .name("Potato")
                .price(30)
                .description("Original Description")
                .build();
        List<ProductDTO> dtoList = List.of(productDto1, productDto2);

        ProductEntity productEntity1 = ProductEntity.builder()
                .id(1)
                .name("Tomato")
                .price(20)
                .description("Original Description")
                .build();
        ProductEntity productEntity2 = ProductEntity.builder()
                .id(2)
                .name("Potato")
                .price(30)
                .description("Original Description")
                .build();
        List<ProductEntity> entityList = List.of(productEntity1, productEntity2);

        Mockito.when(productRepository.findAll()).thenReturn(entityList);
        ProductService productService = new ProductService(productRepository);

        assertEquals(dtoList, productService.getAll());
        Mockito.verify(productRepository).findAll();
    }

    @Test
    public void testSave() {
        ProductDTO dto = ProductDTO.builder()
                .id(25)
                .name("Potato")
                .price(30)
                .description("Original Description")
                .build();
        ProductEntity entity = ProductMapper.toEntity(dto);
        Mockito.when(productRepository.save(Mockito.any(ProductEntity.class))).thenReturn(entity);

        ProductService productService = new ProductService(productRepository);

        assertEquals(dto, productService.save(dto));

        Mockito.verify(productRepository).save(Mockito.any(ProductEntity.class));
    }

    @Test
    public void testDelete() {
        ProductService productService = new ProductService(productRepository);
        productService.delete(12);
        Mockito.verify(productRepository).deleteById(12);
    }

    @Test
    public void testGetById() {
        ProductEntity entity = ProductEntity.builder()
                .id(1)
                .name("Potato")
                .price(30)
                .description("Original Description")
                .build();

        ProductDTO dto = ProductDTO.builder()
                .id(1)
                .name("Potato")
                .price(30)
                .description("Original Description")
                .build();

        Mockito.when(productRepository.findById(1)).thenReturn(Optional.ofNullable(entity));
        ProductService orderService = new ProductService(productRepository);

        assertEquals(dto, orderService.getById(1));
        Mockito.verify(productRepository).findById(1);

    }
}
