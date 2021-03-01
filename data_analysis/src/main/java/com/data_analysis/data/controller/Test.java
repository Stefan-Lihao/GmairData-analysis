package com.data_analysis.data.controller;

import com.data_analysis.data.services.TestServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class Test{

    @Autowired
    private TestServices testServices;

    @RequestMapping("/get")
    public String get(@RequestBody String name) {
        System.out.println("web has carry");
        return testServices.get(name);
    }
}