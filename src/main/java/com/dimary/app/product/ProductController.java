package com.dimary.app.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Object> addProduct(@RequestBody Product product) {
        return productService.addProducto(product);
    }

    @PutMapping
    public ResponseEntity<Object> updateProduct(@RequestBody Product product) {
        return productService.updateProducto(product);
    }

@DeleteMapping(path = "{productID}")
    public ResponseEntity<Object> deleteProduct(@PathVariable("productID") Long idProduct) {
        return this.productService.deleteProduct(idProduct);
    }

}
