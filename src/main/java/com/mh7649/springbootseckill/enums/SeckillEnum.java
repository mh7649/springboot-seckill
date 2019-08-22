package com.mh7649.springbootseckill.enums;

/**
 * @author laimh
 * @since 2019/8/19 22:20
 */
public enum SeckillEnum {
    SUCCESS(1, "秒杀成功"),
    END(0, "秒杀关闭"),
    REPEAT_KILL(-1, "重复秒杀"),
    INNER_ERROR(-2, "内部错误"),
    DATA_REWRITE(-3, "数据串改");

    private int state;
    private String stateInfo;

    SeckillEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }
}
