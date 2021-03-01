package com.data_analysis.analysis.client;


import com.data_analysis.analysis.entity.ResultData;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "log-agent")
@RequestMapping("/log")
public interface LogClient {
    /**
     * 用户获取操作设备的日志
     *
     * @param userId 用户ID（即consumerId）
    //     * @param qrcode 设备
     * @return 结果
     */
    @PostMapping(value = "/useraction/query")
    public ResultData getUserActionLog(@RequestParam(value = "userId") String userId,
//                                        @RequestParam(value = "machineValue") String qrcode,
                                       @RequestParam(value = "pageIndex") int pageIndex,
                                       @RequestParam(value = "pageSize") int pageSize);
}
