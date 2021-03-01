package com.data_analysis.analysis.controller;

import com.data_analysis.analysis.Services.Imp.DataImp;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.data_analysis.analysis.utils.GetUserAddress.getAddress;

@RestController
@RequestMapping("/test")
public class TestWeb {
//    @Autowired
//    private TestServices testServices;

    @Resource
    private DataImp dataImp;

//    @RequestMapping("/getTest")
//    public String getTest() {
//        return testServices.get("通过web调用的");
//    }

    @RequestMapping("/get1")
    public String test() {
        return dataImp.get("通过web调用的")+"123456";
    }

    @RequestMapping("/get2")
    public String test2() {
        long s=new Long("1585406759717");
        String lt= stampToDate(s);
        String sub = lt.substring(11,13);
        return sub;
    }

    private  String stampToDate(long s){
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(s);
        res = simpleDateFormat.format(date);
        return res;
    }

    @RequestMapping("/get3")
    public String test3() {
        String ip = "116.247.80.106";
        String result = getAddress(ip);
        return result;
    }

}
