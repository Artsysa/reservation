package com.zhengxiang.reservation.commonPOJO;/*

 * @return: $return$

 * @Author: $user$

 * @Date: $date$ $time$

 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Scholar implements Serializable {
    private String id;
    private String name;
    private String idcard;
    private String telephone;
    private String gender;
    private String address;
    private int cost;
    private String password;
    private String coachid;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"id\":\"")
                .append(id).append('\"');
        sb.append(",\"name\":\"")
                .append(name).append('\"');
        sb.append(",\"idcard\":\"")
                .append(idcard).append('\"');
        sb.append(",\"telephone\":\"")
                .append(telephone).append('\"');
        sb.append(",\"gender\":\"")
                .append(gender).append('\"');
        sb.append(",\"address\":\"")
                .append(address).append('\"');
        sb.append(",\"cost\":")
                .append(cost);
        sb.append(",\"password\":\"")
                .append(password).append('\"');
        sb.append(",\"coachid\":\"")
                .append(coachid).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
