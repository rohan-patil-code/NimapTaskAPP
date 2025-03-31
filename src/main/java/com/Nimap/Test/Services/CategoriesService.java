package com.Nimap.Test.Services;

import org.springframework.data.domain.Page;

import com.Nimap.Test.Models.Categories;

public interface CategoriesService {
	
	public Page<Categories> findAllCategories(int page,int size);
	
	boolean saveCat(Categories c);
	
	Categories getCatbyId(int cid);
	
	public boolean DelCatById(int cid);
	
	boolean updateCategory(int id, Categories c);
	
	

}
