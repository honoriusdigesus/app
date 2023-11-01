package com.dimary.app;

import com.dimary.app.product.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@SpringBootApplication
@RestController
public class CrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}

	@GetMapping(path = "/")
	public List<Product> getNames() {
		return List.of(new Product(1001,"Mil horas de estudio",1000, LocalDate.of(2023, Month.NOVEMBER,1),1));
	}

}
