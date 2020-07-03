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
public class Coach implements Serializable {
    private String id;
    private String name;
    private String idcard;
    private String carid;
    private String gender;
    private String telephone;
    private String advice;
    private String picture;
    private String password;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"id\":\"")
                .append(id).append('\"');
        sb.append(",\"name\":\"")
                .append(name).append('\"');
        sb.append(",\"idcard\":\"")
                .append(idcard).append('\"');
        sb.append(",\"carid\":\"")
                .append(carid).append('\"');
        sb.append(",\"gender\":\"")
                .append(gender).append('\"');
        sb.append(",\"telephone\":\"")
                .append(telephone).append('\"');
        sb.append(",\"advice\":\"")
                .append(advice).append('\"');
        sb.append(",\"picture\":\"")
                .append(picture).append('\"');
        sb.append(",\"password\":\"")
                .append(password).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
