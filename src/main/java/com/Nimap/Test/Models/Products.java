package com.Nimap.Test.Models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity  // Marks this class as a JPA entity (database table)
@AllArgsConstructor  // Created a constructor with all fields
@NoArgsConstructor   // Created a default constructor
public class Products {

    @Id  // Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-increment primary key
    private int pid;  // Product ID

    private String pname;  // Product name
    private Double price;  // Product price

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)  
    @JoinColumn(name = "category_id", referencedColumnName = "cid")  
    // Many products belong to one category (foreign key relation)
    private Categories category;  

    // Getter and Setter for All Feilds
    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getPid() {
        return pid;
    }

   
    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPname() {
        return pname;
    }

   
    public void setPrice(Double price) {
        this.price = price;
    }

    
    public Double getPrice() {
        return price;
    }

   
    public void setCategory(Categories category) {
        this.category = category;
    }

    public Categories getCategories() {
        return category;
    }
}
