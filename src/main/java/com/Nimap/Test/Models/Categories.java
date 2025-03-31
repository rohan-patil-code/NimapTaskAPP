package com.Nimap.Test.Models;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


import lombok.Data;


@Entity // To Mark Class as Database entity
@Data  // Getter,Setter,AllArgsConstructors,NoArgsConstructors etc
//@ToString
public class Categories {
	
    @Id  // Primary key with autoincreament
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private int cid; 
    
    private String cname;  
    
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)  // defining relations
    
    @JsonIgnoreProperties("category")// to prevent Looping or we can say recursions
    private List<Products> products;  

  
}
