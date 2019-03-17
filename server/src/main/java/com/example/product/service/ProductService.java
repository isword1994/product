package com.example.product.service;

import com.example.product.DecreaseStockInput;
import com.example.product.ProductInfoOutput;

import java.util.List;

public interface ProductService {
    /**
     * 查询在架商品列表
     *
     * @return
     */
    List<ProductInfoOutput> findUpAll();

    /**
     * 查询商品列表
     *
     * @param productIdList
     * @return
     */
    List<ProductInfoOutput> findList(List<String> productIdList);

    /**
     * 扣库存
     *
     * @param cartDTOList
     */
    void decreaseStock(List<DecreaseStockInput> cartDTOList);
}
