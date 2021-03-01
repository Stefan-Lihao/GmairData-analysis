package com.data_analysis.analysis.controller;


import com.alibaba.fastjson.JSONObject;
import com.data_analysis.analysis.Services.Imp.LogServiceImpl;

import com.data_analysis.analysis.function.UserAnalysis;
import com.data_analysis.analysis.function.UsersAnalysis;
import com.data_analysis.utils.util.UserMachineOperationLog;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/show")
public class ShowController {

    @Resource
    LogServiceImpl logServiceImpl;
    /**
     * *userActionLog可视化
     *
     * @param uid 获取查询用户的id（如果不填就是查询全部日志）
     * @param qrCode 设备编号
     * @return 结果
     * */
    @GetMapping("/user/action")//在页面user_action_log上显示详细的个人操作信息
    public String showUserActionLog(@RequestParam(value = "uid", required = false) String uid, @RequestParam(value = "qrcode", required = false) String qrCode, Model model){
        System.out.println("uid");
        List<UserMachineOperationLog> lists=(List<UserMachineOperationLog>)logServiceImpl.getUserActionLog(uid, qrCode, 0, 15).getData();
        model.addAttribute("lists",lists);
        return "user_action_log";
    }

    @ResponseBody
    @GetMapping("/user/analysis")//可以返回特定用户当天最爱使用的机器
    public String dataAnalysis(@RequestParam(value = "uid", required = false) String uid, @RequestParam(value = "qrcode", required = false) String qrCode, Model model){
        System.out.println("uid");
        List<UserMachineOperationLog> lists=(List<UserMachineOperationLog>)logServiceImpl.getUserActionLog(uid, qrCode, 0, 15).getData();//获取用户日志
        String paras= JSONObject.toJSONString(lists);
        List<UserMachineOperationLog> list= JSONObject.parseArray(paras,UserMachineOperationLog.class);
        String s=new String();
        s=UserAnalysis.userDailyMachine(list);//调用函数，从读取数据中找出频率最高的机器
        return s;
    }

    @ResponseBody
    @GetMapping("/users/operationNum")//获取每个地方，每天用户操作的数量（操作数量）
    public String dataUsersOperationNumAnalysis(@RequestParam(value = "uid", required = false) String uid, @RequestParam(value = "qrcode", required = false) String qrCode, Model model){
        List<UserMachineOperationLog> lists=(List<UserMachineOperationLog>)logServiceImpl.getUserActionLog(uid, qrCode, 0, 15).getData();
        String paras= JSONObject.toJSONString(lists);
        List<UserMachineOperationLog> list= JSONObject.parseArray(paras,UserMachineOperationLog.class);
        Map<String,Integer> map=new HashMap<>();
        map= UsersAnalysis.getDailyAreaOperationNum(list);
        for (String key:map.keySet())
        {
            System.out.println("city:"+key+":"+map.get(key));
        }
        return "success";
    }

    @ResponseBody
    @GetMapping("/users/userNum")//获取每个地方，每天用户使用的数量（重复用户去除）
    public String dataUsersNumAnalysis(@RequestParam(value = "uid", required = false) String uid, @RequestParam(value = "qrcode", required = false) String qrCode, Model model){
        List<UserMachineOperationLog> lists=(List<UserMachineOperationLog>)logServiceImpl.getUserActionLog(uid, qrCode, 0, 15).getData();
        String paras= JSONObject.toJSONString(lists);
        List<UserMachineOperationLog> list= JSONObject.parseArray(paras,UserMachineOperationLog.class);
        Map<String,Integer> map=new HashMap<>();
        map= UsersAnalysis.getDailyAreaUsersNum(list);
        for (String key:map.keySet())
        {
            System.out.println("city:"+key+":"+map.get(key));
        }
        return "success";
    }
    @PostMapping("/user/action1")
    public String showUserActionLog2(){

        return "user_action_log";
    }
}
