package com.data_analysis.analysis.controller;

import com.data_analysis.analysis.Services.Imp.LogServiceImpl;
import com.data_analysis.analysis.Services.LogService;
import com.data_analysis.analysis.entity.ApiResult;
import com.data_analysis.analysis.entity.ResultUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/log")
public class LogController {
    @Resource
    LogServiceImpl logServiceImpl;

    @GetMapping("/test")
    public String get1(@RequestParam(value = "uid") String uid)
    {
        return uid+"success";
    }

    @GetMapping("/user")
    public String getUserActionLog1(@RequestParam(value = "uid") String uid,
                                      @RequestParam(value = "qrcode", required = false) String qrCode, int pageIndex, int pageSize) {
        System.out.println("carry success");
        return uid+pageIndex+pageSize;
    }

    /**
     * 获取用户控制设备的日志
     *
     * @param uid    用户ID（非必需，如果不填，则查询设备的全部日志）
     * @param qrCode 设备二维码 （非必需，如果不填，则查询用户的全部控制日志）
     * @return 结果
     */
    @GetMapping("/user/action")
    public ApiResult getUserActionLog(@RequestParam(value = "uid") String uid,
                                      @RequestParam(value = "qrcode", required = false) String qrCode, int pageIndex, int pageSize) {
        System.out.println("carry success11");
        return ResultUtil.success("用户日志获取成功", logServiceImpl.getUserActionLog(uid, qrCode, pageIndex, pageSize).getData());
    }


}
