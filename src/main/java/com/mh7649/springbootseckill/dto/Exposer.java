/*
 Copyright (c) 2002-2019 WiseCRM.com. All rights reserved.
 WiseCRM.com PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.mh7649.springbootseckill.dto;

/**
 * @author laimh
 * @since 2019/8/19 22:26
 */
public class Exposer {

    private boolean exposed;

    private String md5;

    private String seckillId;

    private long startTime;

    private long endTime;

    private long nowTime;

    public Exposer(boolean exposed, long startTime, long endTime, long nowTime) {
        this.exposed = exposed;
        this.startTime = startTime;
        this.endTime = endTime;
        this.nowTime = nowTime;
    }

    public Exposer(boolean exposed, String md5) {
        this.exposed = exposed;
        this.md5 = md5;
    }

    @Override
    public String toString() {
        return "Exposer{" +
                "exposed=" + exposed +
                ", md5='" + md5 + '\'' +
                ", seckillId='" + seckillId + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", nowTime=" + nowTime +
                '}';
    }
}
