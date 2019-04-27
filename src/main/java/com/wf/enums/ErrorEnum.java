package com.wf.enums;

public enum  ErrorEnum {

    PARAAM_ERROR(1,"参数校验失败"),
    MY_ERROR(2,"自定义异常"),
    UNKNOWN_ERROR(-1,"未知错误");

    private int code;

    private String message;

    ErrorEnum() {
    }

    ErrorEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
