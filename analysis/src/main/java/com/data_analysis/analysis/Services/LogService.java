package com.data_analysis.analysis.Services;

import com.data_analysis.analysis.entity.ResultData;

public interface LogService {
    ResultData getUserActionLog(String uid, String qrCode, int pageIndex, int pageSize);

}
