package com.Nimap.Test.Models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity  // Marks this class as a JPA entity (database table)
@Data  // Created a default constructor
public class Categories {
	
    @Id  // Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-increment primary key
    private int cid;  // Category ID
    
    private String cname;  // Category name
    
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)  
    // One category can have multiple products
    
    @JsonIgnore //don’t want to return the list of products inside Categories
    private List<Products> products;  

  
}
