package com.Nimap.Test.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Nimap.Test.Models.Categories;

@Repository
public interface CategoriesRepo extends JpaRepository<Categories,Integer> {

}
