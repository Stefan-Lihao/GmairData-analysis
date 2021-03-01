package com.data_analysis.analysis.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(name="server-service")
public interface DataClient {

    @RequestMapping("/test/get")
    public String get(@RequestBody String name);
}
