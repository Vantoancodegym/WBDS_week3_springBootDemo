package com.vantoan.demo.controller;

import com.vantoan.demo.model.Product;
import com.vantoan.demo.service.categoryService.ICategoryService;
import com.vantoan.demo.service.productService.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductRestController {
    @Autowired
    private IProductService iProductService;
    @Autowired
    private ICategoryService iCategoryService;
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Product> delete(@PathVariable Long id){
        iProductService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping()
    public ResponseEntity<List<Product>> showAll(){
        return new ResponseEntity<>(iProductService.findAll(),HttpStatus.OK);
    }
    @PostMapping("create")
    public ResponseEntity<Product> create(@RequestBody Product product){
        iProductService.save(product);
        return new ResponseEntity<>(product,HttpStatus.CREATED);
    }

}
