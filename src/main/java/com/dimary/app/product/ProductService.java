package com.dimary.app.product;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class ProductService {
    public List<Product> getNames() {
        return List.of(new Product(1001,"Mil y una hora de estudio",1000, LocalDate.of(2023, Month.NOVEMBER,1),1));
    }
}
