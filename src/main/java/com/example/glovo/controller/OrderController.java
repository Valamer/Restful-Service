package com.example.glovo.controller;

import com.example.glovo.dto.ItemDTO;
import com.example.glovo.dto.OrderDTO;
import com.example.glovo.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/orders")
@AllArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping()
    public List<OrderDTO> getAll() {
        return orderService.getAll();
    }

    @GetMapping("/{id}")
    public OrderDTO getById(@PathVariable int id) {
        return orderService.getById(id);
    }

    @PatchMapping("/{id}")
    public OrderDTO addItem(@RequestBody ItemDTO itemDTO, @PathVariable int id) {return orderService.addItem(itemDTO, id);}

    @PostMapping
    public OrderDTO create(@RequestBody OrderDTO orderDTO) {
        return orderService.save(orderDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        orderService.delete(id);
    }

}
