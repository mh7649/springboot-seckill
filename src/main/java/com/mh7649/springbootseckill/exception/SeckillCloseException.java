/*
 Copyright (c) 2002-2019 WiseCRM.com. All rights reserved.
 WiseCRM.com PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.mh7649.springbootseckill.exception;

/**
 * @author laimh
 * @since 2019/8/20 21:34
 */
public class SeckillCloseException extends SeckillException {

    public SeckillCloseException(String message) {
        super(message);
    }

    public SeckillCloseException(String message, Throwable cause) {
        super(message, cause);
    }
}
