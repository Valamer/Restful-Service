package com.example.glovo.service;

import com.example.glovo.dto.ProductDTO;
import com.example.glovo.entity.ProductEntity;
import com.example.glovo.mapper.ProductMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {
    private List<ProductEntity> products;

    public List<ProductDTO> getAll() {
        return products.stream().map(ProductMapper::toDTO).toList();
    }

    public ProductDTO save(ProductDTO productDTO) {
        ProductEntity productEntity = ProductMapper.toEntity(productDTO);
        productEntity.setCreateDate(LocalDate.now());
        products.add(productEntity);
        return productDTO;
    }

    public void delete(int id) {
        ProductEntity productEntity = products.stream().filter(product -> product.getId() == id).findFirst().get();
        products.remove(productEntity);
    }

    public ProductDTO getById(int id) {
        ProductEntity productEntity = products.stream().filter(product -> product.getId() == id).findFirst().get();
        return ProductMapper.toDTO(productEntity);
    }
}
