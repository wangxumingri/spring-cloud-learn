package com.wxss.provider.payment.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
public class IndexController {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/heartBeat")
    public String heartBeat(){
        return "端口:"+serverPort+ "\t" + LocalDateTime.now().format(DateTimeFormatter.ISO_DATE);
    }
}
