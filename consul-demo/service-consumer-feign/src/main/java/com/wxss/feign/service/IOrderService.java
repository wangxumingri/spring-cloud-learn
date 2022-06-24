package com.wxss.feign.service;

import com.wxss.feign.pojo.Product;
import java.util.List;

public interface IOrderService {
    /**
     * 查询商品列表
     * @return
     */
    List<Product> selectProductList();
}
