package com.desafiospringboot.Service;

import com.desafiospringboot.DTOs.ProductDTO;
import com.desafiospringboot.Entities.Product;
import com.desafiospringboot.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product findOrCreateProduct(ProductDTO productDTO) {
        Product product = productRepository.findById(productDTO.getProduct_id()).orElse(null);

        if (product != null)
            return product;

        product = ProductDTO.convert(productDTO);

        return productRepository.save(product);
    }
}
