package com.example.servicediscovery;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableDiscoveryClient
@EnableEurekaClient
public class GatewayDiscoveryConfiguration {


}