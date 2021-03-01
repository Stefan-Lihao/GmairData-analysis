package com.data_analysis.data.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/***
 name/value属性: 这两个的作用是一样的,指定的是调用服务的微服务名称
 url : 指定调用服务的全路径,经常用于本地测试
 如果同时指定name和url属性: 则以url属性为准,name属性指定的值便当做客户端的名称***/
//@FeignClient(name = "server-service")
//public interface TestServer {
//    @RequestMapping("/test/get")
//    public String get(String name);
//}
