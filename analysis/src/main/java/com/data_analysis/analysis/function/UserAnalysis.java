package com.data_analysis.analysis.function;

import com.data_analysis.utils.util.UserMachineOperationLog;

import java.text.SimpleDateFormat;
import java.util.*;

public class UserAnalysis {
    //指定用户每天使用的最多的机器
    public static String userDailyMachine(List<UserMachineOperationLog> list){
        Map<String,Integer> map=new HashMap<>();
        for(UserMachineOperationLog userMachineOperationLog:list)
        {
            if (map.containsKey(userMachineOperationLog.getValue()))
            {
                map.put((String)userMachineOperationLog.getValue(),map.get(userMachineOperationLog.getValue())+1);
            }
            else{
                map.put((String)userMachineOperationLog.getValue(),1);
            }
        }
        String maxMachine=getDiskMax(map);
        return maxMachine;
    }
    //指定用户每天使用最多的时间段
    public static String userDailyTime(List<UserMachineOperationLog> list){
        Map<String,Integer> map=new HashMap<>();
        String s=new String();
        for(UserMachineOperationLog userMachineOperationLog:list)
        {
            s=stampToDate(userMachineOperationLog.getTime()).substring(11,13);
            if(map.containsKey(s)){
                map.put(s,map.get(s)+1);
            }
            else{
                map.put(s,1);
            }
        }
        String maxMachine=getDiskMax(map);
        return maxMachine;
    }
    //指定用户每天使用最多的部件
    public static String userDailyComponent(List<UserMachineOperationLog> list){
        Map<String,Integer> map=new HashMap<>();
        for(UserMachineOperationLog userMachineOperationLog:list)
        {
            if (map.containsKey(userMachineOperationLog.getComponent()))
            {
                map.put((String)userMachineOperationLog.getComponent(),map.get(userMachineOperationLog.getComponent())+1);
            }
            else{
                map.put((String)userMachineOperationLog.getComponent(),1);
            }
        }
        String maxMachine=getDiskMax(map);
        return maxMachine;
    }
    /*
     * 将时间戳转换为时间
     */
    private  static String stampToDate(long s){
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(s);
        res = simpleDateFormat.format(date);
        return res;
    }

//获得map中的最大值
    private static String getDiskMax(Map<String, Integer> map) {
        List<Integer> list = new ArrayList<Integer>();
        for (String temp : map.keySet()) {
            Integer value = map.get(temp);
            list.add(value);
        }
        double max = 0;
        for (int i = 0; i < list.size(); i++) {
            double size = list.get(i);
            max = (max>size)?max:size;
        }
        for (String key : map.keySet()) {
            if (max == map.get(key)) {
                return key;
            }
        }
        return null;
    }
}

