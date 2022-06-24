package com.wxss.consumer.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Value("${service-url.payment-service}")
    private String paymentServiceUrl;

    @Autowired
    private RestTemplate restTemplate;
    @GetMapping("/pay/{orderId}")
    public String queryPaymentInfo(@PathVariable("orderId") String orderId){
//        return restTemplate.getForObject(paymentServiceUrl + "/payment" + orderId, String.class);
        return restTemplate.getForObject(paymentServiceUrl + "/payment", String.class);
    }


    @PostMapping("/pay/{orderId}")
    public String paymentInfo(@PathVariable("orderId") String orderId,@RequestParam String price){
        String url = paymentServiceUrl + "/payment?orderId="+orderId+"&price="+price;
        System.out.println(url);
//        String payUrl = restTemplate.getForObject(paymentServiceUrl+"/payment/"+orderId, String.class, price);
        String payUrl = restTemplate.postForObject(url,null,String.class);
        return payUrl;
    }

}
