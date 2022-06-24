package com.wxss.provider.payment.controller;

//import com.wxss.provider.payment.configuration.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@RestController
@RefreshScope
public class IndexController {
    @Value("${server.port}")
    private String serverPort;
    @Value("${config.info}")
    private String env;
//
//    @Autowired
//    private Config config;
//    @GetMapping("/heartBeat")
//    public String heartBeat(){
//        String env = config.getEnv();
//        return env+"端口:"+serverPort+ "\t" + LocalDateTime.now().format(DateTimeFormatter.ISO_DATE);
//    }
    @GetMapping("/config")
    public String getConfigInfo(){
        return env;
    }
}
