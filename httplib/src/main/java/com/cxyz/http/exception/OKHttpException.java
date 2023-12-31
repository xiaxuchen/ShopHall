package com.cxyz.http.exception;


/**
 * Created by 夏旭晨 on 2018/9/23.
 */

public class OKHttpException extends RuntimeException {

    public static final int EMPTY = 0;

    private int code;

    public OKHttpException() {
        super("服务器内部异常");
    }

    public OKHttpException(int code) {
        this.code = code;
    }

    public OKHttpException(String msg,int code) {
        super(msg);
        this.code = code;
    }

    public OKHttpException(String msg) {
        super(msg);
    }

    public OKHttpException(Throwable throwable) {
        super(throwable);
    }

    public OKHttpException(String msg, Throwable throwable) {
        super(msg, throwable);
    }

    public int getCode() {
        return code;
    }
}
