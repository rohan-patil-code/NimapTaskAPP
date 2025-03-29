package com.Nimap.Test.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Nimap.Test.Models.Categories;

public interface CategoriesRepo extends JpaRepository<Categories,Integer> {

}
