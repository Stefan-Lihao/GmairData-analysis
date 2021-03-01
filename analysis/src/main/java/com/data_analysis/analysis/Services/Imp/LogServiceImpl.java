package com.data_analysis.analysis.Services.Imp;

import com.data_analysis.analysis.Services.LogService;
import com.data_analysis.analysis.client.LogClient;
import com.data_analysis.analysis.entity.ResultData;
import com.data_analysis.analysis.utils.BizException;
import com.data_analysis.analysis.utils.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;

@Slf4j
@Service
public class LogServiceImpl implements LogService {

    @Resource
    LogClient logClient;

    @Override
    public ResultData getUserActionLog(String uid, String qrCode, int pageIndex, int pageSize) {
        if (pageIndex == 0 && pageSize == 0) {
            pageSize = 15;
        }
        ResultData data = logClient.getUserActionLog(uid, pageIndex, pageSize);
        // log.info("LogService | machine com log is: {}", JSON.toJSONString(data));
        if (ObjectUtils.isEmpty(data.getData())) {
            throw new BizException(ErrorCode.USER_ACTION_LOG_ERROR);
        }
        return data;
    }
}
