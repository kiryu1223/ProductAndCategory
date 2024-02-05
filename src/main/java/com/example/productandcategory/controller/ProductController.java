package com.example.productandcategory.controller;

import com.example.productandcategory.pojo.Category;
import com.example.productandcategory.pojo.Product;
import com.example.productandcategory.service.ProductService;
import com.example.productandcategory.util.HttpResult;
import com.example.productandcategory.vo.CategoryVo;
import com.example.productandcategory.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController
{
    @Autowired
    ProductService productService;

    /**
     * 新增产品
     */
    @PostMapping("/create")
    public HttpResult<?> createProduct(@RequestBody ProductVo productVo)
    {
        boolean flag = productService.insertOne(productVo);
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
     * 删除产品
     */
    @GetMapping("/delete/{id}")
    public HttpResult<?> deleteProductById(@PathVariable int id)
    {
        boolean flag = productService.deleteOne(id);
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
     * 根据产品分类id获取所有该产品分类下的所有产品
     */
    @GetMapping("/findByCategoryId/{categoryId}")
    public HttpResult<List<Product>> findProductByCategoryId(@PathVariable int categoryId)
    {
        List<Product> products = productService.findByCategoryId(categoryId);
        return HttpResult.ok(products);
    }

    /**
     * 根据id更新产品的信息
     */
    @PostMapping("/update/{id}")
    public HttpResult<?> updateProductById(@PathVariable int id, @RequestBody ProductVo productVo)
    {
        boolean flag = productService.updateById(id, productVo);
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
