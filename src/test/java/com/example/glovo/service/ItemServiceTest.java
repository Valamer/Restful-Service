package com.example.glovo.service;

import com.example.glovo.dto.ItemDTO;
import com.example.glovo.entity.ItemEntity;
import com.example.glovo.entity.ProductEntity;
import com.example.glovo.repository.ItemRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ItemServiceTest {

    private final ItemRepository itemRepository = Mockito.mock(ItemRepository.class);

    @Test
    public void testGetAll() {
        ItemDTO itemDto1 = ItemDTO.builder()
                .id(1)
                .quantity(2)
                .productId(30)
                .build();
        ItemDTO itemDto2 = ItemDTO.builder()
                .id(2)
                .quantity(3)
                .productId(40)
                .build();
        List<ItemDTO> dtoList = List.of(itemDto1, itemDto2);

        ItemEntity itemEntity1 = ItemEntity.builder()
                .id(1)
                .quantity(2)
                .product(ProductEntity.builder().id(30).build())
                .build();
        ItemEntity itemEntity2 = ItemEntity.builder()
                .id(2)
                .quantity(3)
                .product(ProductEntity.builder().id(40).build())
                .build();
        List<ItemEntity> entityList = List.of(itemEntity1, itemEntity2);

        Mockito.when(itemRepository.findAll()).thenReturn(entityList);
        ItemService itemService = new ItemService(itemRepository);

        assertEquals(dtoList, itemService.getAll());
        Mockito.verify(itemRepository).findAll();
    }

    @Test
    public void testDelete() {
        ItemService itemService = new ItemService(itemRepository);
        itemService.delete(12);
        Mockito.verify(itemRepository).deleteById(12);
    }

    @Test
    public void testGetById() {
        ItemEntity entity = ItemEntity.builder()
                .id(1)
                .quantity(2)
                .product(ProductEntity.builder().id(30).build())
                .build();

        ItemDTO dto = ItemDTO.builder()
                .id(1)
                .quantity(2)
                .productId(30)
                .build();

        Mockito.when(itemRepository.findById(1)).thenReturn(Optional.ofNullable(entity));
        ItemService itemService = new ItemService(itemRepository);

        assertEquals(dto, itemService.getById(1));
        Mockito.verify(itemRepository).findById(1);
    }
}
