package com.dimary.app.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
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

    public ResponseEntity<Object> addProducto(@RequestBody Product product) {
        Optional<Product> res = productRepository.findProductByName(product.getName());
        HashMap<String, Object> datos = new HashMap<>();
        if (res.isPresent() && product.getId() == null) {
            datos.put("ERROR", "No se puede almacenar el producto");
            return new ResponseEntity<>(datos ,HttpStatus.CONFLICT);
        }
        productRepository.save(product);
        datos.put("SAVED", "Producto almacenado correctamente");
        return new ResponseEntity<>(datos, HttpStatus.CREATED);
    }

    public ResponseEntity<Object> updateProducto(Product product) {
        Optional<Product> res = productRepository.findProductByName(product.getName());
        HashMap<String, Object> datos = new HashMap<>();
        if (res.isPresent() && product.getId() == null) {
            datos.put("ERROR", "No se puede actualizar el producto");
            return new ResponseEntity<>(datos ,HttpStatus.CONFLICT);
        }
        if(product.getId() != null){
            datos.put("UPDATE", "Producto actualizado correctamente");
        }
        productRepository.save(product);
        return new ResponseEntity<>(datos, HttpStatus.CREATED);
    }
}
