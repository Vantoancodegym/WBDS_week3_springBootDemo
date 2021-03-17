package com.vantoan.demo.controller;

import com.vantoan.demo.model.Category;
import com.vantoan.demo.model.Product;
import com.vantoan.demo.service.categoryService.ICategoryService;
import com.vantoan.demo.service.productService.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private IProductService iProductService;
    @Autowired
    private ICategoryService iCategoryService;
    @ModelAttribute("categories")
    public List<Category> getCategories(){
        return iCategoryService.findAll();
    }
    @GetMapping()
    public ModelAndView showAll(@PageableDefault(size = 3) Pageable pageable){
        Page<Product> productList=iProductService.findAll(pageable);
        return new ModelAndView("home","productList",productList);

    }
    @PostMapping("search")
    private ModelAndView search(@RequestParam Long category_id){
        return new ModelAndView("search","productList",iProductService.findByCategory(category_id));
    }
}
