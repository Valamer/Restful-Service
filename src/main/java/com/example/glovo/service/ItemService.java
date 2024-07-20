package com.example.glovo.service;

import com.example.glovo.dto.ItemDTO;
import com.example.glovo.entity.ItemEntity;
import com.example.glovo.mapper.ItemMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class ItemService {
    private List<ItemEntity> items;

    public List<ItemDTO> getAll() {
        return items.stream().map(ItemMapper::toDTO).toList();
    }

    public ItemDTO save(ItemDTO itemDTO) {
        items.add(ItemMapper.toEntity(itemDTO));
        return itemDTO;
    }

    public void delete(int id) {
        ItemEntity itemEntity = items.stream().filter(item -> item.getId() == id).findFirst().get();
        items.remove(itemEntity);
    }

    public ItemDTO getById(int id) {
        ItemEntity itemEntity = items.stream().filter(item -> item.getId() == id).findFirst().get();
        return ItemMapper.toDTO(itemEntity);
    }
}
