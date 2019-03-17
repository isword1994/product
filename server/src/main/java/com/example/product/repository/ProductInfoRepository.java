package com.example.product.repository;

import com.example.product.ProductInfoOutput;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductInfoRepository extends JpaRepository<ProductInfoOutput, String> {

    List<ProductInfoOutput> findByProductStatus(Integer productStatus);

    List<ProductInfoOutput> findByProductIdIn(List<String> productIdList);
}
