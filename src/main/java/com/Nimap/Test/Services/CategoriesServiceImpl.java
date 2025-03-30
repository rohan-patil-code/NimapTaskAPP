package com.Nimap.Test.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.Nimap.Test.Models.Categories;
import com.Nimap.Test.Repositories.CategoriesRepo;

@Service
public class CategoriesServiceImpl implements CategoriesService{
	@Autowired
	CategoriesRepo cr;

	@Override
	public Page<Categories> findAllCategories(int page, int size) {
	Page<Categories> categ=cr.findAll(PageRequest.of(page, size));
		return categ;
	}

	@Override
	public boolean saveCat(Categories c) {
		Categories cat=cr.save(c);
		return cat!= null ;
	}

	

	


	
	

}
