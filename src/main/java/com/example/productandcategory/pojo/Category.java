package com.example.productandcategory.pojo;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Category
{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "category_id", nullable = false)
    private Integer categoryId;
    @Basic
    @Column(name = "category_name", nullable = true, length = 255)
    private String categoryName;
    @Basic
    @Column(name = "category_parent_id", nullable = true)
    private Integer categoryParentId;

    public Integer getCategoryId()
    {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId)
    {
        this.categoryId = categoryId;
    }

    public String getCategoryName()
    {
        return categoryName;
    }

    public void setCategoryName(String categoryName)
    {
        this.categoryName = categoryName;
    }

    public Integer getCategoryParentId()
    {
        return categoryParentId;
    }

    public void setCategoryParentId(Integer categoryParentId)
    {
        this.categoryParentId = categoryParentId;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(categoryId, category.categoryId) && Objects.equals(categoryName, category.categoryName) && Objects.equals(categoryParentId, category.categoryParentId);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(categoryId, categoryName, categoryParentId);
    }
}
