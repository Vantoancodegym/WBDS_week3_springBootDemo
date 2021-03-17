package com.vantoan.demo.repo;

import com.vantoan.demo.model.Product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends PagingAndSortingRepository<Product,Long> {
    Page<Product> findAll(Pageable pageable);
    @Query(value = "select * from product where category_id = ?", nativeQuery = true)
    List<Product> findProductByCategoryQ(Long category_id);
}
