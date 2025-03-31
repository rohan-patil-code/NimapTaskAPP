package com.Nimap.Test.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;



@Entity  // To Mark Class as Database entity
@Data  // Getter,Setter,AllArgsConstructors,NoArgsConstructors etc
//@ToString
public class Products {

    @Id  // Primary key with autoincreament
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
    private int pid;  
    private String pname;  
    private Double price;  

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)   // defining relations
    @JoinColumn(name = "category_id", referencedColumnName = "cid")  // Foreign key reference
   
  @JsonIgnoreProperties("products") // to prevent Looping or we can say recursions
    private Categories category;  
    

 
}
