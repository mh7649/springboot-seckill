/*
 Copyright (c) 2002-2019 WiseCRM.com. All rights reserved.
 WiseCRM.com PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.mh7649.springbootseckill.dto;

/**
 * @author laimh
 * @since 2019/8/20 21:28
 */
public class SeckillResult<T> {

    private int success;

    private T data;

    private String error;

    public SeckillResult(int success, T data) {
        this.success = success;
        this.data = data;
    }

    public SeckillResult(int success, String error) {
        this.success = success;
        this.error = error;
    }

    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "SeckillResult{" +
                "success=" + success +
                ", data=" + data +
                ", error='" + error + '\'' +
                '}';
    }
}
