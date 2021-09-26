package com.ssb.onlineshopbackend.controller;

import com.ssb.onlineshopbackend.model.Product;
import com.ssb.onlineshopbackend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts(){
        return ResponseEntity.ok().body(this.productService.getAllProducts());
    }

    @GetMapping("/products/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable Long productId){
        return  ResponseEntity.ok().body(this.productService.getProductById(productId));
    }

    @GetMapping("/category/{categoryname}")
    public ResponseEntity<List<Product>> getAllProductsByCategory(@PathVariable String categoryname){
        return ResponseEntity.ok().body(this.productService.getAllProductsByCategory(categoryname));
    }

    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        return ResponseEntity.ok().body(this.productService.createProduct(product));
    }

    @PutMapping("/products/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long productId, @RequestBody Product product){
        product.setProductID(productId);
        return ResponseEntity.ok().body(this.productService.updateProduct(product));
    }

    @DeleteMapping("/products/{productID}")
    public ResponseEntity<Map<String,Boolean>> deleteProduct(@PathVariable Long productID){
        this.productService.deleteProduct(productID);
        Map<String,Boolean> response = new HashMap<>();
        response.put("deleted",Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

}
