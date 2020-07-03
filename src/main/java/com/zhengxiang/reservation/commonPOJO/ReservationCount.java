package com.zhengxiang.reservation.commonPOJO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
/*
预约表信息
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservationCount implements Serializable {

    private String id;
    private String status;
    private String time1;
    private String time2;
    private String time3;
    private String time4;
    private String time5;
    private String time6;
    private String time7;
    private String time8;
    private String time9;
    private String time10;
    private String time11;
    private String time12;
    private String time13;
    private String time14;
    private String time15;
    private String time16;
    private String time17;
    private String time18;
    private String time19;
    private String time20;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"id\":\"")
                .append(id).append('\"');
        sb.append(",\"status\":\"")
                .append(status).append('\"');
        sb.append(",\"time1\":\"")
                .append(time1).append('\"');
        sb.append(",\"time2\":\"")
                .append(time2).append('\"');
        sb.append(",\"time3\":\"")
                .append(time3).append('\"');
        sb.append(",\"time4\":\"")
                .append(time4).append('\"');
        sb.append(",\"time5\":\"")
                .append(time5).append('\"');
        sb.append(",\"time6\":\"")
                .append(time6).append('\"');
        sb.append(",\"time7\":\"")
                .append(time7).append('\"');
        sb.append(",\"time8\":\"")
                .append(time8).append('\"');
        sb.append(",\"time9\":\"")
                .append(time9).append('\"');
        sb.append(",\"time10\":\"")
                .append(time10).append('\"');
        sb.append(",\"time11\":\"")
                .append(time11).append('\"');
        sb.append(",\"time12\":\"")
                .append(time12).append('\"');
        sb.append(",\"time13\":\"")
                .append(time13).append('\"');
        sb.append(",\"time14\":\"")
                .append(time14).append('\"');
        sb.append(",\"time15\":\"")
                .append(time15).append('\"');
        sb.append(",\"time16\":\"")
                .append(time16).append('\"');
        sb.append(",\"time17\":\"")
                .append(time17).append('\"');
        sb.append(",\"time18\":\"")
                .append(time18).append('\"');
        sb.append(",\"time19\":\"")
                .append(time19).append('\"');
        sb.append(",\"time20\":\"")
                .append(time20).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
