package com.one.service.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = "com.one")
public class PlatformSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlatformSystemApplication.class,args);
    }
}
