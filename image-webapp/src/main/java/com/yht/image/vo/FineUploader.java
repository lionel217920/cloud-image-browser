package com.yht.image.vo;

import java.io.Serializable;

public class FineUploader implements Serializable {
    private static final long serialVersionUID = 148493123940461644L;

    private static final String SUCCESS_STATE = "true";

    private static final String ERROR_STATE = "false";

    private String success;

    private String error;

    private String newUuid;

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getNewUuid() {
        return newUuid;
    }

    public void setNewUuid(String newUuid) {
        this.newUuid = newUuid;
    }

    public static FineUploader ok() {
        return new FineUploader(SUCCESS_STATE);
    }

    public static FineUploader ok(String newUuid) {
        return new FineUploader(SUCCESS_STATE, newUuid);
    }

    public static FineUploader failed() {
        return new FineUploader(ERROR_STATE);
    }

    public FineUploader() {

    }

    public FineUploader(String state) {
        this.success = state;
    }

    public FineUploader(String state, String uuid) {
        this.success = state;
        this.newUuid = uuid;
    }
}
