package com.example.productandcategory.pojo;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Product
{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "product_id", nullable = false)
    private Integer productId;
    @Basic
    @Column(name = "product_name", nullable = true, length = 255)
    private String productName;
    @Basic
    @Column(name = "product_image", nullable = true, length = 255)
    private String productImage;
    @Basic
    @Column(name = "category_id", nullable = true)
    private Integer categoryId;

    public Integer getProductId()
    {
        return productId;
    }

    public void setProductId(Integer productId)
    {
        this.productId = productId;
    }

    public String getProductName()
    {
        return productName;
    }

    public void setProductName(String productName)
    {
        this.productName = productName;
    }

    public String getProductImage()
    {
        return productImage;
    }

    public void setProductImage(String productImage)
    {
        this.productImage = productImage;
    }

    public Integer getCategoryId()
    {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId)
    {
        this.categoryId = categoryId;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(productId, product.productId) && Objects.equals(productName, product.productName) && Objects.equals(productImage, product.productImage) && Objects.equals(categoryId, product.categoryId);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(productId, productName, productImage, categoryId);
    }
}
