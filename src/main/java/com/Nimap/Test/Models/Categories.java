package com.Nimap.Test.Models;

import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity  // Marks this class as a JPA entity (database table)
@AllArgsConstructor // Created a constructor with all fields
@NoArgsConstructor   // Created a default constructor
public class Categories {
	
    @Id  // Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-increment primary key
    private int cid;  // Category ID
    
    private String cname;  // Category name
    
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)  
    // One category can have multiple products
    private List<Products> products;  

    // Getter and Setter for all feilds
    public int getCid() {
        return cid;
    }
    
    public void setCid(int cid) {
        this.cid = cid;
    }

   
    public void setCname(String cname) {
        this.cname = cname;
    }
    
    public String getCname() {
        return cname;
    }

    
    public void setProducts(List<Products> products) {
        this.products = products;
    }
    
    public List<Products> getProducts() {
        return products;
    }
}
