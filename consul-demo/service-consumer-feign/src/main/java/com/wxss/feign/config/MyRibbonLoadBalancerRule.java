package com.wxss.feign.config;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Random;

public class MyRibbonLoadBalancerRule extends AbstractLoadBalancerRule {
    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }

    @Override
    public Server choose(Object key) {
        return chooserInternal(getLoadBalancer(), key);
    }

    private Server chooserInternal(ILoadBalancer loadBalancer, Object key) {
        List<Server> reachableServers = loadBalancer.getReachableServers();
        if (CollectionUtils.isEmpty(reachableServers)){
            throw new RuntimeException("无可用服务");
        }
        for (Server reachableServer : reachableServers) {
            System.out.println("可用服务实例:" + reachableServer.getHostPort());
        }
        int balanceNumber = new Random().nextInt();
        Server server;
        if (balanceNumber % 2 == 0){
            server = reachableServers.get(1);
        }else {
            server = reachableServers.get(0);
        }
        System.out.println(key + "选择实例:" + server.getHostPort());
        return server;
    }
}

