package com.edureka.mstestsactuator.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v2")
public class HelloResource_V2 extends HelloResource {

    @GetMapping("/hello/{user}")
    public String getHello(@PathVariable String user) {
        System.out.println("V2- Hello User Resource is called");
        return "V2- Hello " + user;
    }
}
