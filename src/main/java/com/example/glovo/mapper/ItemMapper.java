package com.example.glovo.mapper;

import com.example.glovo.dto.ItemDTO;
import com.example.glovo.entity.ItemEntity;

public class ItemMapper {

    public static ItemDTO toDTO(ItemEntity itemEntity) {
        return ItemDTO.builder()
                .id(itemEntity.getId())
                .quantity(itemEntity.getQuantity())
                .build();
    }

    public static ItemEntity toEntity(ItemDTO itemDTO) {
        return ItemEntity.builder()
                .id(itemDTO.getId())
                .quantity(itemDTO.getQuantity())
                .build();
    }
}
