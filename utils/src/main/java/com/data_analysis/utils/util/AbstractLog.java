package com.data_analysis.utils.util;

import org.springframework.data.mongodb.core.mapping.Field;

public abstract class AbstractLog {
    @Field("logDetail")
    private String detail;

    private String ip;

    private long createAt;

    public AbstractLog(String detail, String ip) {
        this.detail = detail;
        this.ip = ip;
        this.createAt = System.currentTimeMillis();
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(long createAt) {
        this.createAt = createAt;
    }
}