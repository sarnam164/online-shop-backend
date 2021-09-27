package com.ssb.onlineshopbackend.data;

import com.ssb.onlineshopbackend.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Serializable> {
    List<Product> findAllByOrderByProductID();
    List<Product> findAllByProductCategory(String categoryname);
}
