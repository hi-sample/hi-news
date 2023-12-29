package com.example.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @author IKin <br/>
 * @description <br/>
 * @create 2022/11/29 11:51 <br/>
 */
public class Result<T> implements Serializable {

    private static final long serialVersionUID = -1231791391888956466L;
    int code = 0;
    String msg = "ok";
    List<T> data = null;
    T model;
    String url;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public T getModel() {
        return model;
    }

    public void setModel(T model) {
        this.model = model;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
