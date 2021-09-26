package com.ssb.onlineshopbackend.service;

import com.ssb.onlineshopbackend.data.ProductRepository;
import com.ssb.onlineshopbackend.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @BeforeEach
    public void init(){
        List<Product> productList = new ArrayList<Product>();
        Product product1 = new Product("Commercial","A350","Passenger Aircraft Family",2);
        Product product2 = new Product("Defence","A450","Defence",3);
        productList.add(product1);
        productList.add(product2);
        when(productRepository.findAllByOrderByProductID()).thenReturn(productList);
        when(productRepository.findAllByProductCategory("Commercial")).thenReturn(productList);
    }

    @Test
    public void testGetAllProducts(){
        List<Product> productList = productService.getAllProducts();
        assertEquals(productList.size(),2);
        assertEquals(productList.get(0).getProductCategory(),"Commercial");
    }

    @Test
    public void testGetAllProductsByCategory(){
        List<Product> productList = productService.getAllProductsByCategory("Commercial");
        assertEquals(productList.size(),1);
        assertEquals(productList.get(0).getProductCategory(),"Commercial");
    }

}
