package com.dimary.app.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/products")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getNames() {
        return productService.getNames();
    }

    @PostMapping
    public void addProduct(@RequestBody Product product) {
        productService.addProducto(product);
    }

}
