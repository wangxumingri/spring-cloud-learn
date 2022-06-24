package com.wxss.feign.service.impl;

import com.wxss.feign.feign.api.OrderApi;
import com.wxss.feign.pojo.Product;
import com.wxss.feign.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService {
    @Autowired
    private OrderApi orderApi;

    @Override
    public List<Product> selectProductList() {
        return orderApi.selectProductList();
    }
}
