package com.ssb.onlineshopbackend.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@Table(name = "PRODUCTS")
public class Product {
    @Id
    @Column(name = "PRODUCT_ID", insertable = false, nullable = false)
    @GenericGenerator(name = "seq_product_id", strategy = "com.ssb.onlineshopbackend.util.MyGenerator")
    @GeneratedValue(generator = "seq_product_id")
    private String productID;

    @Column(name = "PRODUCT_CATEGORY", nullable = false)
    private String productCategory;

    @Column(name = "PRODUCT_NAME", nullable = false)
    private String productName;

    @Column(name = "PRODUCT_DESCRIPTIONS", nullable = false)
    private String productDescription;

    @Column(name = "UNITS", nullable = false)
    private int units;

    public Product() {
    }

    public Product(String productCategory, String productName, String productDescription, int units) {
        this.productCategory = productCategory;
        this.productName = productName;
        this.productDescription = productDescription;
        this.units = units;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productID='" + productID + '\'' +
                ", productCategory='" + productCategory + '\'' +
                ", productName='" + productName + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", units=" + units +
                '}';
    }

}
