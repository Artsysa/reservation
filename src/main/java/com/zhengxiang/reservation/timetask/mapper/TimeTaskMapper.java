package com.zhengxiang.reservation.timetask.mapper;

import com.zhengxiang.reservation.commonPOJO.coachORMreservationTable;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.concurrent.CopyOnWriteArrayList;

/*
动态插入当天约车时间表
 */
@Mapper
public interface TimeTaskMapper {
    /*
    查询出所有教练对应的具体预约表名称
     */
    @Select("SELECT coach_orm_reservationdetail.id,coach_orm_reservationdetail.tablename FROM coach_orm_reservationdetail")
   public CopyOnWriteArrayList<coachORMreservationTable> getcaochormreservationdetail();

    /*
    查询教练对应的预约表信息的表名
     */
    @Select("SELECT id,tablename FROM coach_orm_reservationcount")
    public CopyOnWriteArrayList<coachORMreservationTable> getcaochormreservationcount();

    /*
     更新当天预约信息
     */
    @Insert("insert into ${table}  VALUES(#{day},1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1) ")
    public int updateDayReservation(@Param("day")String date,@Param("table")String table);


}
