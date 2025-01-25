package com.ayush.ecom_proj.controller;

import com.ayush.ecom_proj.model.Product;
import com.ayush.ecom_proj.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    @GetMapping("/product/{id}")
    public Product getProductById(@PathVariable int id){
        return service.getProductById(id);
    }

    @PostMapping("/product")
    public ResponseEntity<?> addProduct(@RequestPart Product product,
        @RequestPart MultipartFile imgFile){
        try {
            Product pro = service.addProduct(product,imgFile);
            return new ResponseEntity<>(pro, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/product/{proId}/image")
    public ResponseEntity<byte []> getImgByProductId(@PathVariable int proId){
        Product product = service.getProductById(proId);
        byte [] imgFile = product.getImgData();
        return ResponseEntity.ok()
                .contentType(MediaType
                        .valueOf(product
                                .getImgType()))
                .body(imgFile);
    }
}