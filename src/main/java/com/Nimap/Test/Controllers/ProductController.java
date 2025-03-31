package com.Nimap.Test.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	
	//To Fetch All Products with Pagination
	@GetMapping
	public ResponseEntity<Page<Products>> getAllProds(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "5") int size){
				
		Page<Products> prods=prodserv.findAllProds(page, size);
		
		return ResponseEntity.ok(prods);
	}
	
	
	// To Add new Product 
	@PostMapping
	public Products AddProd(@RequestBody Products p) {
		return prodserv.saveProd(p);
	}
	
	
	// To Find Product By id
	@GetMapping(value="/{pid}")
	public Products getProdById(@PathVariable int pid) {
			
			Products pr = prodserv.getProdById(pid);
			if(pr!=null) {
				return pr;
			}
			else {
				throw new RuntimeException("Product Not Found");
			}
	}
	
	
	
	//To Update Product By id
	@PutMapping("/{pid}")
	public Products UpdateProd(@PathVariable int pid,@RequestBody Products p)
	{
		return prodserv.UpdateProd(pid,p);
	}
	
	
	//To delet Product By id
	@DeleteMapping("/{cid}")
	public String DelProdById(@PathVariable int cid) {

		boolean b = prodserv.DelProdById(cid);
		if (b) {
			return "Record \t" + cid + "\tdeleted Successfully.";
		} else {
			return "Some Problem is there...";
		}
	}
	
	

}
