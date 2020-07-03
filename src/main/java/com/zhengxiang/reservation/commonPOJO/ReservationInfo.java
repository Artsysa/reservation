package com.zhengxiang.reservation.commonPOJO;

import lombok.*;

import java.io.Serializable;

/*
预约具体信息
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ReservationInfo implements Serializable {
    private String id;
    private String timepart;
    private String status;
    private String userid;
    private String time;
    private String name;
    private String timeid;


    public ReservationInfo(String timepart, String status, String userid, String time, String username,String timeid) {
        this.timepart = timepart;
        this.status = status;
        this.userid = userid;
        this.time = time;
        this.name = username;
        this.timeid=timeid;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"id\":\"")
                .append(id).append('\"');
        sb.append(",\"timepart\":\"")
                .append(timepart).append('\"');
        sb.append(",\"status\":\"")
                .append(status).append('\"');
        sb.append(",\"userid\":\"")
                .append(userid).append('\"');
        sb.append(",\"time\":\"")
                .append(time).append('\"');
        sb.append(",\"name\":\"")
                .append(name).append('\"');
        sb.append(",\"timeid\":\"")
                .append(timeid).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
