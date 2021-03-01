package com.data_analysis.analysis.function;

import com.data_analysis.utils.util.UserMachineOperationLog;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.data_analysis.analysis.utils.GetUserAddress.getAddress;

public class UsersAnalysis {


    //获取一个地区每天操作数量
    public static Map<String,Integer> getDailyAreaOperationNum(List<UserMachineOperationLog> list){
        Map<String,Integer> map=new HashMap<>();
        String s=new String();
        for(UserMachineOperationLog userMachineOperationLog:list)
        {
            s=getAddress(userMachineOperationLog.getIp()).substring(0,4);
            if(map.containsKey(s)){
                map.put(s,map.get(s)+1);
            }
            else{
                map.put(s,1);
            }
        }
        return map;
    }

    //获取一个地区每天用户数量
    public static Map<String,Integer> getDailyAreaUsersNum(List<UserMachineOperationLog> list){
        Map<String,Integer> map=new HashMap<>();
        Map<String,Integer> user=new HashMap<>();
        String s=new String();
        for(UserMachineOperationLog userMachineOperationLog:list)
        {
            s=getAddress(userMachineOperationLog.getIp()).substring(0,4);
            if(map.containsKey(s)==true && user.containsKey(userMachineOperationLog.getUserId())==false){
                map.put(s,map.get(s)+1);
                user.put(userMachineOperationLog.getUserId(),1);
            }
            else if(map.containsKey(s)==false && user.containsKey(userMachineOperationLog.getUserId())==false){
                map.put(s,1);
                user.put(userMachineOperationLog.getUserId(),1);
            }
        }
        return map;
    }

}
