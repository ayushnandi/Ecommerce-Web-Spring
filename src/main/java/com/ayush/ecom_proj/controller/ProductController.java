package com.ayush.ecom_proj.controller;

import com.ayush.ecom_proj.model.Product;
import com.ayush.ecom_proj.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService service;

    @RequestMapping("/")
    public String print(){
        return "Hello World";
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        List<Product> products = service.getAllProducts();
        System.out.println("Products fetched: " + products);
        return products;
    }

}