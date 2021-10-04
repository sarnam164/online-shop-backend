package com.ssb.onlineshopbackend.service;

import com.ssb.onlineshopbackend.data.ProductRepository;
import com.ssb.onlineshopbackend.model.Product;
import org.assertj.core.api.Assertions;
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


@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    String categoryName = "Space";
    List<Product> productList;
    List<Product> productList2;

    @BeforeEach
    public void init(){
        productList = new ArrayList<Product>();
        productList2 = new ArrayList<>();
        Product product1 = new Product("Commercial","A350","Passenger Aircraft Family",2);
        Product product2 = new Product("Space","A450","Defence",3);
        productList.add(product1);
        productList.add(product2);
        productList2.add(product2);
    }

    @Test
    public void testGetAllProducts(){
        when(productRepository.findAllByOrderByProductID()).thenReturn(productList);
        List<Product> productList = productService.getAllProducts();
        assertEquals(productList.size(),2);
        assertEquals(productList.get(0).getProductCategory(),"Commercial");
    }

    @Test
    public void testGetAllProductsByCategory(){
        when(productRepository.findAllByProductCategory(categoryName)).thenReturn(productList2);
        List<Product> list = productService.getAllProductsByCategory(categoryName);
        assertEquals(list.size(),1);
        assertEquals(list.get(0).getProductCategory(),"Space");
    }

}
