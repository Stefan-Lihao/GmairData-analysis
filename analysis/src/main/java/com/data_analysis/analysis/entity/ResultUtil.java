package com.data_analysis.analysis.entity;

import com.data_analysis.analysis.utils.ErrorCode;

public class ResultUtil {
    public static ApiResult success() {
        return success(null, null);
    }

    public static ApiResult success(String msg, Object data) {
        ApiResult apiResult = new ApiResult();
        apiResult.setResponseCode("RESPONSE_OK");
        apiResult.setDescription(msg);
        apiResult.setData(data);
        return apiResult;
    }

    public static ApiResult success(String msg) {
        return success(msg, null);
    }

    public static ApiResult error(String code, String msg) {
        ApiResult apiResult = new ApiResult();
        apiResult.setResponseCode(code);
        apiResult.setDescription(msg);
        return apiResult;
    }

    public static ApiResult error(String msg) {
        ApiResult apiResult = new ApiResult();
        apiResult.setResponseCode("RESPONSE_ERROR");
        apiResult.setDescription(msg);
        return apiResult;
    }

    public static ApiResult error(ErrorCode codeEnum) {
        ApiResult apiResult = new ApiResult();
        apiResult.setResponseCode(codeEnum.getResponseCode());
        apiResult.setDescription(codeEnum.getDescription());
        return apiResult;
    }
}
