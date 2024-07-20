package com.example.glovo.controller;

import com.example.glovo.dto.ItemDTO;
import com.example.glovo.service.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/items")
@AllArgsConstructor
public class ItemController {

    private ItemService itemService;

    @GetMapping()
    public List<ItemDTO> getAll() {
        return itemService.getAll();
    }

    @GetMapping("/{id}")
    public ItemDTO getById(@PathVariable int id) {
        return itemService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        itemService.delete(id);
    }

}
