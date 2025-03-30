package com.Nimap.Test.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Nimap.Test.Models.Categories;
import com.Nimap.Test.Services.CategoriesService;

@RestController
@RequestMapping("/api/categories")
public class CategoriesController {
	@Autowired	
	CategoriesService catserv;
	
	@GetMapping
	public ResponseEntity<Page<Categories>> getAllCategories(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "5") int size){
			
		Page<Categories> categ=catserv.findAllCategories(page, size);
		
		return ResponseEntity.ok(categ);
	}
	
	@PostMapping
	public String AddCategory(@RequestBody Categories c) {
			
		boolean b =catserv.saveCat(c);
		if(b) {
			return "Category Added Successfully";
		}
		else {
			return "some problem is there.....";
		}
	}

}
