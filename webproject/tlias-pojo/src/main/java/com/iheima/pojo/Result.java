package com.iheima.pojo;

import lombok.Data;



/**
 * backend unified return result
 */
@Data
public class Result {

    private Integer code; //encoder: 1 success, 0 failed
    private String msg; //error message
    private Object data; //data

    public static Result success() {
        Result result = new Result();
        result.code = 1;
        result.msg = "success";
        return result;
    }

    public static Result success(Object object) {
        Result result = new Result();
        result.data = object;
        result.code = 1;
        result.msg = "success";
        return result;
    }

    public static Result error(String msg) {
        Result result = new Result();
        result.msg = msg;
        result.code = 0;
        return result;
    }

}
