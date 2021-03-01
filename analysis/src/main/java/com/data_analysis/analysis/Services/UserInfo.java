package com.data_analysis.analysis.Services;

import com.data_analysis.utils.util.UserMachineOperationLog;

import java.util.List;

public interface UserInfo {

    public List<String> getUserAction(List<UserMachineOperationLog> userMachineOperationLog);

    public List<String> getUserMachine(List<UserMachineOperationLog> userMachineOperationLog);

    public List<String> getUserIp(List<UserMachineOperationLog> userMachineOperationLog);

}
