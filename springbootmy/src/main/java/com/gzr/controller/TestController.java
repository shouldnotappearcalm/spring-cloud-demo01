package com.gzr.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gaozhriong
 */
@RestController
public class TestController {

    @GetMapping("/test")
    public String testGeMap(){
        return "HelloWorld";
    }



}
