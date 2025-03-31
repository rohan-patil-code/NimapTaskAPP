package com.Nimap.Test.Services;
import  org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Nimap.Test.Models.Categories;
import com.Nimap.Test.Models.Products;
import com.Nimap.Test.Repositories.ProductsRepo;

@Service
public class ProductsServiceImpl implements ProductsService{
	@Autowired
	ProductsRepo pr;
	
	@Autowired
	CategoriesService categoriesService;
	
	
	// logic for Fetching all products with pagination 
	@Override
	public Page<Products> findAllProds(int page, int size) {
		// TODO Auto-generated method stub
		Page<Products> prod=pr.findAll(PageRequest.of(page, size));
		return prod;
	}

	
	//logic for adding new Product
	@Override
	public Products saveProd(Products p) {
		int catid=p.getCategory().getCid();
		Categories cat=categoriesService.getCatbyId(catid);
		if(cat==null) 
			return null;
		
		p.setCategory(cat);
		
		Products pc=pr.save(p);
		return pc;
	}

	
	// logic for find prod by id
	@Override
	public Products getProdById(int pid) {
		Optional<Products> op=pr.findById(pid);
		if(op.isPresent()) {
			return op.get();
		}
		else {
		return null;
	}
	}
	
	
	//logic for delete product by id
	@Override
	public boolean DelProdById(int pid) {
		Optional<Products> oc = pr.findById(pid);
		if(oc.isPresent()) {
		pr.deleteById(pid);
		return true;
		}
		else {
		return false;
	}
		
	}

	
		//logic for update product also update category of productt
	public Products UpdateProd(int pid, Products p) {
	    Optional<Products> op = pr.findById(pid);
	    if (op.isPresent()) {
	        Products prod = op.get();
	        prod.setPname(p.getPname());
	        prod.setPrice(p.getPrice());

	        // Get the new category ID from the request
	        int newcid = p.getCategory().getCid();

	        // Fetch the full category object from DB to keep cname
	        Categories newCat = categoriesService.getCatbyId(newcid);
	        if (newCat != null) {
	            prod.setCategory(newCat);  
	        }

	        pr.save(prod);
	        return prod;
	    }
	    return null;
	}

		 
}
