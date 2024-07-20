package com.example.glovo.service;

import com.example.glovo.dto.ItemDTO;
import com.example.glovo.mapper.ItemMapper;
import com.example.glovo.repository.ItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class ItemService {
    private ItemRepository itemRepository;

    public List<ItemDTO> getAll() {
        return itemRepository.findAll().stream().map(ItemMapper::toDTO).toList();
    }

    public void delete(int id) {
        itemRepository.deleteById(id);
    }

    public ItemDTO getById(int id) {
        return itemRepository.findById(id).map(ItemMapper::toDTO).orElseThrow();
    }
}
