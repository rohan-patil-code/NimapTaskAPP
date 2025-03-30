package com.Nimap.Test.Services;

import  org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Nimap.Test.Models.Products;
import com.Nimap.Test.Repositories.ProductsRepo;

@Service
public class ProductsServiceImpl implements ProductsService{
	@Autowired
	ProductsRepo pr;
				
	@Override
	public Page<Products> findAllProds(int page, int size) {
		// TODO Auto-generated method stub
		Page<Products> prod=pr.findAll(PageRequest.of(page, size));
		return prod;
	}
	 
}
