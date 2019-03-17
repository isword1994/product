package com.example.product.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {

    PRODUCT_NOT_EXIST(1, "商品不存在"),
    PRODUCT_STOCK_ERROR(2, "库存不足");

    private Integer code;

    private String mesage;

    ResultEnum(Integer code, String mesage) {
        this.code = code;
        this.mesage = mesage;
    }
}
