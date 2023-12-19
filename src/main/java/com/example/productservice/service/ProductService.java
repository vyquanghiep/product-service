package com.example.productservice.service;


import com.example.productservice.model.Product;

import java.util.List;

public interface ProductService {
    Product saveProduct(Product product);
    List<Product> getProducts();

    Product getProductById(int id);

    String deleteProduct(int id);
}
