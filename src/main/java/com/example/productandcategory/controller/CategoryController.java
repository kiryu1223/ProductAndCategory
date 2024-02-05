package com.example.productandcategory.controller;


import com.example.productandcategory.pojo.Category;
import com.example.productandcategory.service.CategoryService;
import com.example.productandcategory.util.HttpResult;
import com.example.productandcategory.vo.CategoryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController
{
    @Autowired
    CategoryService categoryService;

    /**
     * 新增产品分类
     */
    @PostMapping("/create")
    public HttpResult<?> createNewCategory(@RequestBody CategoryVo categoryVo)
    {
        boolean flag = categoryService.insertOne(categoryVo);
        if (flag)
        {
            return HttpResult.ok();
        }
        else
        {
            return HttpResult.fail();
        }
    }

    /**
     * 删除产品分类
     */
    @GetMapping("/delete/{id}")
    public HttpResult<?> deleteCategoryById(@PathVariable int id)
    {
        boolean flag = categoryService.deleteOne(id);
        if (flag)
        {
            return HttpResult.ok();
        }
        else
        {
            return HttpResult.fail();
        }
    }

    /**
     * 根据id获取产品分类的子分类
     */
    @GetMapping("/findChild/{id}")
    public HttpResult<List<Category>> findChildById(@PathVariable int id)
    {
        List<Category> childById = categoryService.findChildById(id);
        return HttpResult.ok(childById);
    }

    /**
     * 根据产品分类id去更新该产品分类的信息
     */
    @PostMapping("/update/{id}")
    public HttpResult<?> updateCategoryById(@PathVariable int id, @RequestBody CategoryVo categoryVo)
    {
        boolean flag = categoryService.updateById(id, categoryVo);
        if (flag)
        {
            return HttpResult.ok();
        }
        else
        {
            return HttpResult.fail();
        }
    }
}
