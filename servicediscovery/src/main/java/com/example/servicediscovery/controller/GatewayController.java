package com.example.servicediscovery.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebFlux;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@EnableSwagger2WebFlux
@RestController()
@Api(value = "Gateway", description = "Gateway APIs")O
public class GatewayController {

    @GetMapping(value = "/health")
    @ApiOperation(value = "Returns Health")
    public Mono<String> health(){
         return Mono.just(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
    }

}
