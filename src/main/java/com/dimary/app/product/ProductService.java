package com.dimary.app.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getNames() {
        return this.productRepository.findAll();
    }

    public void addProducto(@RequestBody Product product) {
        Optional<Product> res = productRepository.findProductByName(product.getName());
        if (res.isPresent()) {
            throw new IllegalStateException("El producto ya existe");
        } else {
            productRepository.save(product);
        }
    }
}
