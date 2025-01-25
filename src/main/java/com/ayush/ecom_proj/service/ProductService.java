package com.ayush.ecom_proj.service;


import com.ayush.ecom_proj.model.Product;
import com.ayush.ecom_proj.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo repo;

    public List<Product> getAllProducts(){
        return repo.findAll();
    }

    public Product getProductById(int id) {
        return repo.findById(id).orElse(new Product());
    }

    public Product addProduct(Product product, MultipartFile imgFile) throws IOException {
        product.setImgName(imgFile.getOriginalFilename());
        product.setImgType(imgFile.getContentType());
        product.setImgData(imgFile.getBytes());
        return repo.save(product);
    }
}
