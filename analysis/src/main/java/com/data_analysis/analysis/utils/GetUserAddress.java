package com.data_analysis.analysis.utils;


import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.List;


public class GetUserAddress {

    public static String getAddress(String ip) {
        String url = "http://ip.ws.126.net/ipquery?ip=" + ip;
        String str = HttpUtil.get(url);
        if(!StrUtil.hasBlank(str)){
            String substring = str.substring(str.indexOf("{"), str.indexOf("}")+1);
            System.out.println(substring);
            JSONObject jsonObject = JSONUtil.parseObj(substring);
            String province = jsonObject.getStr("province");
            String city = jsonObject.getStr("city");
            return province + " " + city;
        }
        return null;
    }
}
