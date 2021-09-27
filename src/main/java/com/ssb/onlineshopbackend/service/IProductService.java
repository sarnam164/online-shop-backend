package com.ssb.onlineshopbackend.service;

import com.ssb.onlineshopbackend.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAllProducts();
    List<Product> getAllProductsByCategory(String categoryname);
    Product createProduct(Product product);
    Product updateProduct(Product product);
    Product getProductById(String productID);
    void deleteProduct(String productID);
}
