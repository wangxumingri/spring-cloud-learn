package com.wxss.consul;

import com.wxss.consul.config.RibbonBalanceConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


/**
 * 开启负载均衡：启用@RibbonClient 和 @LoadBalanced，以及RestTemplate 使用 服务名称调用
 * 关闭负载均衡：关闭@RibbonClient 和 @LoadBalanced，以及RestTemplate 使用 固定IP调用
 */
@SpringBootApplication
@RibbonClient(name = "service-provider",configuration = RibbonBalanceConfiguration.class ) // name 指定被负载均衡的服务提供者ServiceName，configuration 指定自定义配置累
public class ServiceConsumerApp {
    public static void main(String[] args) {
        SpringApplication.run(ServiceConsumerApp.class,args);
    }

    /**
     * RestTemplate 默认不会自动放入 ioc容器，需要手动添加
     * @return
     */
    @Bean
    @LoadBalanced // 负载均衡
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
