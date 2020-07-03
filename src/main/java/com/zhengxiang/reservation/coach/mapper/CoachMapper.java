package com.zhengxiang.reservation.coach.mapper;


import com.zhengxiang.reservation.commonPOJO.Coach;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;

@Mapper
public interface CoachMapper {
    /*
   验证用户名密码是否符合规范
    */
    @Cacheable(cacheNames = "coachinfo",key = "#username+#password")
    @Select("select count(id) from coach where idcard=#{username} and password=#{pass}")
    public Integer scholarlogin(@Param("username")String username, @Param("pass") String password);


    /*
    查询用户具体信息 根据id
     */
    @Cacheable(cacheNames = "coachinfo",key = "#id")
    @Select("SELECT coach.id,coach.`name`,coach.idcard,coach.carid,coach.telephone,coach.advice,coach.picture,coach.gender\n" +
            "FROM coach WHERE coach.id = #{id}")
    public Coach searchoneinfobyid(@Param("id")String id);
    /*
    查询用户具体信息 根据身份证号
     */
    @Cacheable(cacheNames = "coachinfo",key = "#id")
    @Select("SELECT coach.id,coach.`name`,coach.idcard,coach.carid,coach.telephone,coach.advice,coach.picture,coach.gender\n" +
            "FROM coach WHERE coach.idcard = #{id}")
    public Coach searchoneinfobyidbyidcard(@Param("id")String id);

    /*
    查询教练对应的那张预约表 reservationscount
     */
    @Cacheable(cacheNames = "reservationcount",key = "#id")
    @Select("select tablename from coach_orm_reservationcount where id=#{id}")
    public String getReservationcountTableName(@Param("id")String id);
        /*
    查询教练对应的那张预约表 reservationsdetail
     */@Cacheable(cacheNames = "reservationdetial",key = "#id")
    @Select("select tablename from coach_orm_reservationdetail where id=#{id}")
    public String getReservationDetailTableName(@Param("id")String id);


    /**
     * 更新教练通知信息
     */
    @CachePut(cacheNames = "coachinfo",key = "#coachid")
    @Select("update coach set advice=#{advice} where idcard=#{coachid};" +
            "SELECT c.id,c.`name`,c.idcard,c.carid,c.telephone," +
            "c.advice,c.picture,c.`password`,c.gender FROM coach" +
            " AS c WHERE c.idcard=#{coachid};")
    public Coach updateAdvice(@Param("coachid") String coachid,@Param("advice") String advice);


    /**
     * 教练操作，学员是否已预约但未到
     * @param date
     * @param userid
     * @return
     */
    @Caching(
            evict = {
                    @CacheEvict(cacheNames = {"reservationinfos"},allEntries = true),
                    @CacheEvict(cacheNames = "reservationinfo",allEntries = true),
                    @CacheEvict(cacheNames = "reservationinfopart",allEntries = true),
                    @CacheEvict(cacheNames = "reservationinfoall",allEntries = true)
            }
    )
    @Update("update ${tablename} set `status`=0 where userid=#{userid} and timeid=#{date}")
    public Integer UpdateScholarReservationState(@Param("date") String date,@Param("userid") String userid,@Param("tablename") String tablename);


    /**
     * 预约修改表字段设置为
     * 不可逾越  对应的值为 9
     * 同时清理缓存
     * @param date 预约的日期
     * @param now
     * @param next
     * @param timepart 预约拿一个时间段
     * @param tablename 表名
     * @return
     */
    //@CacheEvict(cacheNames = {"reservationinfos"},allEntries = true)
    //@CacheEvict(cacheNames = "reservationinfo",key = "#tablename+#now+#next")
    @Caching(
            evict = {
                    @CacheEvict(cacheNames = {"reservationinfos"},allEntries = true),
                    @CacheEvict(cacheNames = "reservationinfo",key = "#tablename+#now+#next"),
                    @CacheEvict(cacheNames = "reservationinfo",key = "#tablename+#date"),
                    @CacheEvict(cacheNames = "reservationinfopart",allEntries = true),
                    @CacheEvict(cacheNames = "reservationinfoall",allEntries = true)
            }
    )
    @Update("update ${tablename} " +
            "set ${timepart}='9'" +
            " where ${tablename}.id=#{date};")
    public Integer setreservationequal9(@Param("date")String date, String now,String next, @Param("timepart")String timepart, @Param("tablename")String tablename);



}
