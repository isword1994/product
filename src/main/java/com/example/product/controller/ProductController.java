package com.example.product.controller;

import com.example.product.dto.CartDTO;
import com.example.product.VO.ProductInfoVO;
import com.example.product.VO.ProductVO;
import com.example.product.VO.ResultVO;
import com.example.product.dataObject.ProductCategory;
import com.example.product.dataObject.ProductInfo;
import com.example.product.service.CategoryService;
import com.example.product.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.product.utils.ResultVOUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ResultVO<ProductVO> list() {
        //查询所有在架的商品
        List<ProductInfo> productInfoList = productService.findUpAll();

        //获取类目type列表
        List<Integer> categoryTypeList = productInfoList.stream().
                map(ProductInfo::getCategoryType).
                collect(Collectors.toList());

        //从数据库查询类目
        List<ProductCategory> categoryList = categoryService.findByCategoryTypeIn(categoryTypeList);

        //构造数据
        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productcategory : categoryList) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(productcategory.getCategoryName());
            productVO.setCategoryType(productcategory.getCategoryType());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList) {
                if (productInfo.getCategoryType().equals(productcategory.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }

        return ResultVOUtil.success(productVOList);

    }

    /**
     * 获取商品列表
     *
     * @param productIdList
     * @return
     */
    @PostMapping("/listForOrder")
    public List<ProductInfo> listForOrder(@RequestBody List<String> productIdList) {
        return productService.findList(productIdList);

    }

    @PostMapping("/decreaseStock")
    public void decreaseStock(@RequestBody List<CartDTO> cartDTOList) {
        productService.decreaseStock(cartDTOList);
    }

}
