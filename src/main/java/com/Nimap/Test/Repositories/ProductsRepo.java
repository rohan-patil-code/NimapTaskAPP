package com.Nimap.Test.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Nimap.Test.Models.Products;

public interface ProductsRepo extends JpaRepository<Products, Integer>{

}
