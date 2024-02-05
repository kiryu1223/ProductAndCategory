package com.example.productandcategory.service;

import com.example.productandcategory.pojo.Category;
import com.example.productandcategory.pojo.Product;
import com.example.productandcategory.vo.CategoryVo;
import com.example.productandcategory.vo.ProductVo;
import io.github.kiryu1223.baseDao.core.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService
{
    @Autowired
    BaseDao baseDao;

    public boolean insertOne(ProductVo productVo)
    {
        Product product = new Product();
        product.setProductName(productVo.getProductName());
        product.setProductImage(productVo.getProductImage());
        product.setCategoryId(productVo.getCategoryId());
        return baseDao.save(product);
    }

    public boolean deleteOne(int id)
    {
        return baseDao.delete(Product.class)
                .where(p -> p.getProductId() == id)
                .doDelete() == 1;
    }

    public List<Product> findByCategoryId(int id)
    {
        return baseDao.query(Product.class)
                .where(a -> a.getCategoryId() == id)
                .select(r -> r)
                .toList();
    }

    public boolean updateById(int id, ProductVo productVo)
    {
        String productName = productVo.getProductName();
        String productImage = productVo.getProductImage();
        int categoryId = productVo.getCategoryId();
        return baseDao.update(Product.class)
                .set(a ->
                {
                    a.setProductName(productName);
                    a.setProductImage(productImage);
                    a.setCategoryId(categoryId);
                })
                .where(b -> b.getProductId() == id)
                .doUpdate() == 1;
    }
}
