package com.wf.Exception;

import com.wf.enums.ErrorEnum;
import com.wf.model.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class AppException {

    private static final Logger logger = LoggerFactory.getLogger(AppException.class);

    /*@ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public Result getException(Exception e, HttpServletRequest request){
        Result result = new Result();
        result.setCode(ErrorEnum.UNKNOWN_ERROR.getCode());
        result.setMessage(ErrorEnum.UNKNOWN_ERROR.getMessage());
        return result;
    }*/

    @ExceptionHandler(MyException.class)
    @ResponseBody
    public Result getMyException(MyException e, HttpServletRequest request){
        Result result = new Result();
        result.setCode(e.getCode());
        result.setMessage(e.getMessage());
        return result;
    }
}
