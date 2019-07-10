package com.yht.image.model.vo;

import java.io.Serializable;

public class StatusCode implements Serializable {
    private static final long serialVersionUID = 5898176336866248642L;
    public static final String SUCCESS_CODE = "2000";
    public static final StatusCode SUCCESS = new StatusCode("2000", "");
    private final String code;
    private final String message;

    public final String getCode() {
        return this.code;
    }

    public final String getMessage() {
        return this.message;
    }

    public StatusCode(String code, String message) {
        this.code = code == null ? "50000000" : code;
        this.message = message == null ? "Server Error" : message;
    }
}
