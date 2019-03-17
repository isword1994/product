package com.example.product.service;

import com.example.product.ProductApplicationTests;
import com.example.product.dataObject.ProductInfo;
import com.example.product.service.ProductService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class ProductServiceTest extends ProductApplicationTests {
    @Autowired
    private ProductService productService;

    @Test
    public void findUpAll() throws Exception {
        List<ProductInfo> list = productService.findUpAll();
        Assert.assertTrue(list.size() > 0);
    }

    @Test
    public void findList() throws Exception {
        List<ProductInfo> list = productService.findList(Arrays.asList("157875196366160022", "164103465734242707"));
        Assert.assertTrue(list.size() > 0);

    }


}