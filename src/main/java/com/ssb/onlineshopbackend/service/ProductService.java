package com.ssb.onlineshopbackend.service;

import com.ssb.onlineshopbackend.exception.ResourceNotFoundException;
import com.ssb.onlineshopbackend.model.Product;
import com.ssb.onlineshopbackend.data.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductService implements IProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return this.productRepository.findAllByOrderByProductID();
    }

    @Override
    public List<Product> getAllProductsByCategory(String categoryname) {
        return this.productRepository.findAllByProductCategory(categoryname);
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        Optional<Product> productDb = this.productRepository.findById(product.getProductID());
        if(productDb.isPresent()){
            Product productUpdate = productDb.get();
            productUpdate.setProductID(product.getProductID());
            productUpdate.setProductName(product.getProductName());
            productUpdate.setProductCategory(product.getProductCategory());
            productUpdate.setProductDescription(product.getProductDescription());
            productUpdate.setUnits(product.getUnits());
            productRepository.save(productUpdate);
            return productUpdate;
        }else{
            throw new ResourceNotFoundException("Record Not Found with Id : "+product.getProductID());
        }
    }

    @Override
    public Product getProductById(long productID) {
        Optional<Product> productDb = this.productRepository.findById(productID);
        if(productDb.isPresent()){
            return productDb.get();
        }else{
            throw new ResourceNotFoundException("Record Not Found with Id : "+productID);
        }
    }

    @Override
    public void deleteProduct(long productID) {
        Optional<Product> productDb = this.productRepository.findById(productID);
        if(productDb.isPresent()){
            this.productRepository.delete(productDb.get());
        }else{
            throw new ResourceNotFoundException("Record Not Found with Id : "+productID);
        }
    }
}
