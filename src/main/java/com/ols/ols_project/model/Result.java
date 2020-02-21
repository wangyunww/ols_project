package com.ols.ols_project.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashMap;

/**
 * @author yuyy
 * @date 20-2-19 下午2:37
 */
@Getter
@Setter
@ToString
public class Result {
    private HashMap<String,Object> data;
    private Meta meta;

    public Result(HashMap<String, Object> data,String status,String msg) {
        this.meta=new Meta(status,msg);
        this.data = data;
    }

    /**
     * 失败的时候 没有data
     * @param status
     * @param msg
     */
    public Result(String status,String msg) {
        this.meta=new Meta(status,msg);
    }

    public Result() {
    }
}