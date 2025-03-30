package com.Nimap.Test.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Nimap.Test.Models.Products;
import com.Nimap.Test.Services.ProductsService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	@Autowired
	ProductsService prodserv;
	
	@GetMapping
	public ResponseEntity<Page<Products>> getAllProds(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "5") int size){
				
		Page<Products> prods=prodserv.findAllProds(page, size);
		
		return ResponseEntity.ok(prods);
	}

}
