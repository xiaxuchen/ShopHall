package com.cxyz.http.response;

public class CheckResult<T> {

    /**
     * 请求是否成功
     */
    private boolean success;

    /**
     * 请求的数据
     */
    private T data;

    /**
     * 请求失败的错误信息
     */
    private String msg;

    /**
     * 状态值，成功返回1
     */
    private Integer code;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public CheckResult()
    {}

}
