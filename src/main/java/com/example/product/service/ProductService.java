package com.example.product.service;

import com.example.product.dto.CartDTO;
import com.example.product.dataObject.ProductInfo;

import java.util.List;

public interface ProductService {
    /**
     * 查询在架商品列表
     *
     * @return
     */
    List<ProductInfo> findUpAll();

    /**
     * 查询商品列表
     *
     * @param productIdList
     * @return
     */
    List<ProductInfo> findList(List<String> productIdList);

    /**
     * 扣库存
     *
     * @param cartDTOList
     */
    void decreaseStock(List<CartDTO> cartDTOList);
}
