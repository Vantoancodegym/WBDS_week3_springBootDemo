package com.vantoan.demo.service.productService;

import com.vantoan.demo.model.Product;
import com.vantoan.demo.repo.ProductRepo;
import com.vantoan.demo.service.productService.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private ProductRepo productRepo;

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return productRepo.findAll(pageable);
    }

    @Override
    public List<Product> findByCategory(Long id) {
        return productRepo.findProductByCategoryQ(id);
    }

    @Override
    public List<Product> findAll() {
        return (List<Product>) productRepo.findAll() ;
    }

    @Override
    public Product findById(Long id) {
        return productRepo.findById(id).get();
    }

    @Override
    public Product save(Product product) {
        return productRepo.save(product);
    }

    @Override
    public void delete(Long id) {
        productRepo.deleteById(id);

    }
}
