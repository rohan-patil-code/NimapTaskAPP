package com.Nimap.Test.Services;

import java.util.Optional;

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

	
	// Business logic for Fetching all Categories
	@Override
	public Page<Categories> findAllCategories(int page, int size) {
	Page<Categories> categ=cr.findAll(PageRequest.of(page, size));
		return categ;
	}

	// Logic for Adding new Category
	@Override
	public boolean saveCat(Categories c) {
		Categories cat=cr.save(c);
		return cat!= null ;
	}

	
	//logic for find category by id
	@Override
	public Categories getCatbyId(int cid) {
		Optional<Categories> oc=cr.findById(cid);
		if(oc.isPresent()) {
			return oc.get();
		}
		else {
			return null;
		}
		
	}
	
	
	
	//logic for delete category by id
	@Override
	public boolean DelCatById(int cid) {
		Optional<Categories> oc = cr.findById(cid);
		if(oc.isPresent()) {
		cr.deleteById(cid);
		return true;
		}
		else {
		return false;
	}
		
	}
	
	// logic for update category by id
	@Override
	public boolean updateCategory(int id, Categories c) {
		Optional<Categories>opcat=cr.findById(id);
		if(opcat.isPresent())
		{
			Categories cat=opcat.get();
			cat.setCname(c.getCname());
			cr.save(cat);
			return true;
		}
	
		return false;
	}


}
