package net.hifor.demo.dto;

import java.io.Serializable;
import java.util.List;

/**
 * @author IKin <br/>
 * @description <br/>
 * @create 2024/1/26 18:05 <br/>
 */
public class Result<T> implements Serializable {
    private static final long serialVersionUID = 4056498461738191100L;
    int code = 0;
    String msg = "ok";
    List<T> data = null;
    T model;
    String url;

    public Result() {
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<T> getData() {
        return this.data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public T getModel() {
        return this.model;
    }

    public void setModel(T model) {
        this.model = model;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
