package com.example.productandcategory.service;

import com.example.productandcategory.pojo.Category;
import com.example.productandcategory.pojo.Product;
import com.example.productandcategory.vo.CategoryVo;
import io.github.kiryu1223.baseDao.core.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService
{
    @Autowired
    BaseDao baseDao;

    public boolean insertOne(CategoryVo categoryVo)
    {
        Category category = new Category();
        category.setCategoryName(categoryVo.getName());
        Integer parentId = categoryVo.getParentId();
        if (parentId != null)
        {
            category.setCategoryParentId(parentId);
        }
        return baseDao.save(category);
    }

    //删除分类时需要删除子分类和产品
    public boolean deleteOne(int id)
    {
        deepDelete(id);
        return true;
    }

    private void deepDelete(int id)
    {
        //删除产品分类
        baseDao.delete(Category.class)
                .where(e -> e.getCategoryId() == id)
                .doDelete();

        //删除商品
        baseDao.delete(Product.class)
                .where(p -> p.getCategoryId() == id)
                .doDelete();

        //获取子产品分类
        List<Category> list = baseDao.query(Category.class)
                .where(c -> c.getCategoryParentId() == id)
                .select(r -> r).toList();


        //递归删除
        //这里使用in更好
        for (Category category : list)
        {
            deepDelete(category.getCategoryId());
        }
    }

    public List<Category> findChildById(int id)
    {
        return baseDao.query(Category.class)
                .where(c -> c.getCategoryParentId() == id)
                .select(r -> r).toList();
    }

    public boolean updateById(int id, CategoryVo categoryVo)
    {
        String name = categoryVo.getName();
        Integer parentId = categoryVo.getParentId();
        return baseDao.update(Category.class)
                .set(a ->
                {
                    a.setCategoryName(name);
                    a.setCategoryParentId(parentId);
                })
                .where(b -> b.getCategoryId() == id)
                .doUpdate() == 1;
    }
}
