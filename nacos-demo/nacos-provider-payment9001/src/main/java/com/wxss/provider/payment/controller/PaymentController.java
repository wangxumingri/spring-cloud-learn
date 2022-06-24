package com.wxss.provider.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    @PostMapping()
    public String pay(@RequestParam("orderId") String orderId, @RequestParam String price){
        String payUrl = orderId + "支付url：" + serverPort;
        return payUrl;
    }


    @GetMapping()
    public String queryPaymentInfo(){
        return serverPort;
    }

}
