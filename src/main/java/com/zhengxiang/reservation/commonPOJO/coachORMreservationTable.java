package com.zhengxiang.reservation.commonPOJO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/*
各个教练和预约表之间的映射关系
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class coachORMreservationTable  implements Serializable {
    private String id;
    private String tablename;



}
