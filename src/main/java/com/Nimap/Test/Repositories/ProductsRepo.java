package com.Nimap.Test.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Nimap.Test.Models.Products;

@Repository
public interface ProductsRepo extends JpaRepository<Products, Integer>{
	

}
