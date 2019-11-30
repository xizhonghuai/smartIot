package com.entity;

/**
 * @ClassName SensorParams
 * @Description TODO
 * @Author xizhonghuai
 * @Date 2019-07-12 14:30
 * @Version 1.0
 */
public class SensorParams {

    private Integer EA;
    private Integer interval;
    private Integer increment;

    public SensorParams() {
    }

    public SensorParams(Integer EA, Integer interval, Integer increment) {
        this.EA = EA;
        this.interval = interval;
        this.increment = increment;
    }

    public Integer getEA() {
        return EA;
    }

    public void setEA(Integer EA) {
        this.EA = EA;
    }

    public Integer getInterval() {
        return interval;
    }

    public void setInterval(Integer interval) {
        this.interval = interval;
    }

    public Integer getIncrement() {
        return increment;
    }

    public void setIncrement(Integer increment) {
        this.increment = increment;
    }

    @Override
    public String toString() {
        return "SensorParams{" +
                "EA=" + EA +
                ", interval=" + interval +
                ", increment=" + increment +
                '}';
    }
}
