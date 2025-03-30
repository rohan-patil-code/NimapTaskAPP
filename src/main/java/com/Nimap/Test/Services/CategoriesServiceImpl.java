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
