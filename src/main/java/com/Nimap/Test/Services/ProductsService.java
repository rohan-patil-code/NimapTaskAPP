package com.Nimap.Test.Services;

import org.springframework.data.domain.Page;

import com.Nimap.Test.Models.Products;

public interface ProductsService {
	
	public Page<Products> findAllProds(int page,int size);
}
