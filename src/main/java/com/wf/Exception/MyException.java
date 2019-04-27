package com.wf.Exception;

import com.wf.enums.ErrorEnum;

public class MyException extends RuntimeException{

    private int code;

    public MyException(ErrorEnum errorEnum) {
        super(errorEnum.getMessage());
        this.code = errorEnum.getCode();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
