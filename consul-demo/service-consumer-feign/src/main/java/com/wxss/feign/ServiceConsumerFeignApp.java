package com.wxss.feign;

import feign.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients // 开启 openfeign: 扫描@FeignClient
public class ServiceConsumerFeignApp {
    public static void main(String[] args) {
        SpringApplication.run(ServiceConsumerFeignApp.class, args);
    }

    /**
     * 调整 feign 的日志级别
     * @return
     */
    @Bean
    public Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
