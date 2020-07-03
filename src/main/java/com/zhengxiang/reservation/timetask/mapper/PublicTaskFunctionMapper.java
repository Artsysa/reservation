package com.zhengxiang.reservation.timetask.mapper;

import com.zhengxiang.reservation.commonPOJO.ReservationCount;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

@Mapper
public interface PublicTaskFunctionMapper {

    /*
查询当天预约信息
 */
    @Cacheable(cacheNames = "reservationinfo",key = "#name+#now+#next")
    @Select("SELECT rc.id,rc.`status`,rc.time1,rc.time2,rc.time3,rc.time4,rc.time5,rc.time6,rc.time7" +
            ",rc.time8,rc.time9,rc.time10,rc.time11,rc.time12,rc.time13,rc.time14,rc.time15,rc.time16" +
            ",rc.time17,rc.time18,rc.time19,rc.time20 FROM ${tablename} AS rc where rc.id=#{now} or rc.id=#{next} order by id asc")
    public List<ReservationCount> getReservationOneInfo(@Param("now")String now,@Param("next")String next, @Param("tablename")String name);

    /*
    查询具体某一个时间段还剩余的预约次数
     */

    @Select("select ${timepart} from ${tablename} where id=#{date}")
    public Integer getReservationOneTimePartRemainderCount(@Param("date")String date, @Param("tablename")String tablename, @Param("timepart")String timepart);
}
