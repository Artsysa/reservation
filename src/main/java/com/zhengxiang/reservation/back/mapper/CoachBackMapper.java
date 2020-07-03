package com.zhengxiang.reservation.back.mapper;/*

 * @return: $return$

 * @Author: $user$

 * @Date: $date$ $time$

 */


import com.zhengxiang.reservation.commonPOJO.Coach;
import com.zhengxiang.reservation.commonPOJO.ReservationCount;
import org.apache.ibatis.annotations.*;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;

import java.util.List;

@Mapper
public interface CoachBackMapper {


    /**
     * 查询当前系统中所有教练的信息
     * @return
     */
    @Cacheable(cacheNames = "coachinfoall",key = "#PageSize+#PageNow")
    @Select("SELECT coach.id,coach.`name`,coach.idcard,coach.carid,coach.telephone," +
            "coach.advice,coach.picture,coach.gender FROM coach")
    public List<Coach> getAllCoachInfo(String PageNow,String PageSize);

    /**
     * 查询当前系统中所有教练的信息
     * @return
     */
    @Cacheable(cacheNames = "coachinfoall",key = "'list'")
    @Select("SELECT coach.id,coach.`name`,coach.idcard FROM coach")
    public List<Coach> getAllCoachInfoList();

    /**
     * 获取教练对应学员信息表的表名称
     * @param coachid
     * @return
     */
    @Cacheable(cacheNames = "coachormscholar",key = "#coachid")
    @Select("SELECT a.tablename FROM coach_orm_scholar AS a WHERE a.id=#{tablename}")
    public String getCoachORMScholarTablename(@Param("tablename") String coachid);

    /**
     * 获取教练对应学员表中所有学员的身份证号
     * @param tablename
     * @return
     */
    @Cacheable(cacheNames = "coachormscholaridcard",key = "#tablename")
    @Select("select scholarid from ${tablename}")
    public List<String> getCoachORMAllScholar(@Param("tablename") String tablename);

    /**
     * 插入一条教练信息
     * 默认密码为身份证后6位
     * @param coach
     * @return
     */
    @CacheEvict(cacheNames = "coachinfoall",allEntries = true)
    @Select({"insert into coach(name,idcard,carid,telephone,advice," +
            "picture,password,gender)" +
            " values(#{c.name},#{c.idcard},#{c.carid}," +
            "#{c.telephone},'暂无通知','http://49.235.43.59/p/d.jpg'," +
            "#{c.password},#{c.gender});select c.id from coach c where idcard=#{c.idcard}"})
    public Integer addCoach(@Param("c") Coach coach);


    /**
     * 调用存储过程，创建教练对应的映射表
     *
     * @param id
     * @param index
     */

    @Select("call addcoachorm(#{index},#{id})")
    public void CallInsertCoachProcedure(@Param("id") String id, @Param("index") String index);

    @Insert("insert into coach_${index}_reservationcount  VALUES(#{date},1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1),(#{next},1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1)")
    public Integer insetCurrentReservationCountData(@Param("index") String index, @Param("date") String date,@Param("next") String next);

    /**
     * 方法抛出异常调用
     * 进行事务回滚
     * @param index
     * @param id
     */
   @Select("call detelcoachorm(#{index},#{id})")
    public void rollback(@Param("index") String index, @Param("id") String id);

    /**
     * 查询指定的一天的所有预约信息
     *
     * @param tablename
     * @return
     */
    @Cacheable(cacheNames = "reservationinfo",key = "#tablename+#now")
    @Select("SELECT rc.id,rc.`status`,rc.time1,rc.time2,rc.time3,rc.time4,rc.time5,rc.time6,rc.time7" +
            ",rc.time8,rc.time9,rc.time10,rc.time11,rc.time12,rc.time13,rc.time14,rc.time15,rc.time16" +
            ",rc.time17,rc.time18,rc.time19,rc.time20 FROM ${tablename} AS rc where rc.id=#{now} ")
    public ReservationCount getOneDayReservationInfo(@Param("tablename") String tablename, @Param("now") String now);

    /**
     * 删除教练所有信息
     * 映射表
     * @param coachid
     */
    @Caching(
            evict = {
                    @CacheEvict(cacheNames = "coachinfoall",allEntries = true),
                    @CacheEvict(cacheNames = "coachinfo",allEntries = true)
            }
    )
    @Select("call detechoach(#{id}) ")
    public void detelCoachAll(@Param("id") String coachid);

    /**
     * 管理员设置完不可预约后调用方法
     * 进行删除操作，删除已经预约的信息
     * @param timepart
     * @param date
     * @return
     */
    @Caching(
            evict = {
                    @CacheEvict(cacheNames = "reservationinfo",allEntries = true)
            }
    )
    @Delete("delete from ${tablename} where timepart=#{timepart} and timeid=#{date}")
    public Integer deleteReservationInfoTimepartAll(@Param("timepart")String timepart
    ,@Param("date")String date,@Param("tablename")String tablename);


    /**
     * 上传头像
     * @param coachid
     * @param path
     * @return
     */

    @Caching(
            evict = {
                    @CacheEvict(cacheNames = "coachinfo",key = "#coachid"),
                    @CacheEvict(cacheNames = "coachinfoall",allEntries = true)
            }
    )
    @Update("update  coach set picture=#{path} where idcard=#{coachid}")
    public void attrpicture(@Param("coachid")String coachid,@Param("path")String path);

    /**
     * 查询当前1图片路径
     * @param coachid
     * @return
     */
    @Select("select picture from coach where idcard=#{coachid}")
    public String getpicture(@Param("coachid")String coachid);
}
