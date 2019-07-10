package com.yht.image.model.vo;

import java.io.Serializable;

public class Msg implements Serializable {

    private static final long serialVersionUID = -1207714554255922567L;

    private static final String OK_CODE = "2000";

    private static final String SERVER_ERROR_CODE = "50000000";

    private String code;

    private String msg;

    private Object data;

    public static Msg ok() {
        return msg(StatusCode.SUCCESS);
    }

    public static Msg ok(Object data) {
        return msg(StatusCode.SUCCESS).data(data);
    }

    public static Msg msg(StatusCode code) {
        return new Msg(code);
    }

    public Msg(StatusCode code) {
        this();
        this.code = code.getCode();
        this.msg = code.getMessage();
    }

    public Msg data(Object data) {
        this.data = data;
        return this;
    }

    public Msg() {
        this.msg = "";
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
