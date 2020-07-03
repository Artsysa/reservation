package com.zhengxiang.reservation.coach.mapper;

import com.zhengxiang.reservation.commonPOJO.ReservationInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.cache.annotation.Cacheable;

import java.util.concurrent.CopyOnWriteArrayList;

@Mapper
public interface CoachORMScholarMapper {

    /*
       查询当前时间段预约人的信息
       根据 时间，表名，哪个时间段
     */
    @Cacheable(cacheNames = "reservationinfopart",key = "#tablename+#date+#timepart")
    @Select("SELECT rd.id,rd.timepart,rd.`status`,rd.userid,rd.time,rd.timeid,rd.`name` FROM ${tablename} AS rd where rd.timeid=#{date} and rd.timepart=#{timepart}")
    public CopyOnWriteArrayList<ReservationInfo> getOneCoachORMReservationInfo(
            @Param("date") String date,@Param("tablename") String tablename,
            @Param("timepart") String timepart);

    /**
     * 教练查询当天和下一天的所有预约信息
     *
     * @param tablename
     * @return
     */
    @Cacheable(cacheNames = "reservationinfos",key = "#tablename+'all'")
    @Select("SELECT rd.id,rd.timepart,rd.`status`,rd.userid,rd.time,rd.timeid,rd.`name` FROM ${tablename} AS rd where rd.timeid=#{now} or rd.timeid=#{next} order by timeid asc")
    public CopyOnWriteArrayList<ReservationInfo> getOneDayReservationInfo(@Param("tablename") String tablename,@Param("now") String now,@Param("next") String next);
}
