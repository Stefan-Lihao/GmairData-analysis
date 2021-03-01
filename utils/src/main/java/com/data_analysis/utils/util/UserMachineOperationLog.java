package com.data_analysis.utils.util;

import org.springframework.data.mongodb.core.mapping.Field;

public class UserMachineOperationLog extends AbstractLog {
    //@Field("")该属性对应mongodb的字段的名字，如果一致，则无需该注解
    private String logId;

    private String userId;

    private String qrcode;

    private long time;

    private String component;
    @Field("machineValue")
    private String value;

    public UserMachineOperationLog(String userId, String qrcode, long time, String component, String detail, String ip, String value) {
        super(detail, ip);
        this.userId = userId;
        this.qrcode = qrcode;
        this.time = time;
        this.component = component;
        this.value = value;
    }

    public String getLogId() {
        return logId;
    }

    public void setLogId(String logId) {
        this.logId = logId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getQrcode() {
        return qrcode;
    }

    public void setQrcode(String qrcode) {
        this.qrcode = qrcode;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}