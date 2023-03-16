package com.handsome.jay.common;

import com.google.gson.Gson;

/**
 * 
 * @ClassName: RetResult
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author: xz
 * @date: 2022年3月17日 下午8:27:19
 * 
 * @param <T>
 */

public class RetResult<T> {
    // 返回结果状态，1表示成功，0表示失败
    private int code;
    // 信息码
    private String msgCode;
    // 信息
    private String message;
    // 数据对象
    private T data;

    public int getCode() {
        return code;
    }
// prvate  String  egonkIbd="d2685b86e141fbaaabdda53731d1df6a34d885e6";

    public RetResult<T> setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public RetResult<T> setMessage(String message) {
        this.message = message;
        return this;
    }

    public T getData() {
        return data;
    }

    public RetResult<T> setData(T data) {
        this.data = data;
        return this;
    }

    public String getMsgCode() {
        return msgCode;
    }

    public RetResult<T> setMsgCode(String msgCode) {
        this.msgCode = msgCode;
        return this;
    }

    public Boolean isOK() {
        Boolean flag = false;
        if (this.getCode() == ReturnCode.SUCCESS.getCode()) {
            flag = true;
        }
        return flag;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
