package com.zhengxiang.reservation.scholar.mapper;

import com.zhengxiang.reservation.commonPOJO.ReservationCount;
import com.zhengxiang.reservation.commonPOJO.ReservationInfo;
import com.zhengxiang.reservation.commonPOJO.Scholar;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


@Mapper
public interface ScholarMapper {

    /*
    验证用户名密码是否符合规范
     */
    @Cacheable(cacheNames = "scholarinfo",key = "#username+#password")
    @Select("select count(id) from scholar where idcard=#{username} and password=#{pass}")
    public int scholarlogin(@Param("username")String username,@Param("pass") String password);

    /*
    查询用户具体信息
     */
    @Cacheable(cacheNames = "scholarinfo",key = "#user")
    @Select("SELECT scholar.id,scholar.name,scholar.idcard,scholar.telephone,scholar.gender,scholar.address,scholar.cost,\n" +
            "scholar.`password`,scholar.coachid FROM scholar WHERE scholar.idcard= #{username}")
    public Scholar searchoneinfo(@Param("username")String user);

    /*
    修改密码并返回结果集
     */
    @Select("update  scholar set password=#{pass} where idcard=#{id};SELECT scholar.id,scholar.name,scholar.idcard,scholar.telephone,scholar.gender,scholar.address,scholar.cost,scholar.`password`,scholar.coachid FROM scholar WHERE scholar.idcard= #{id};")
    public Scholar alterpass(@Param("pass")String pass,@Param("id")String id);


    /*
     预约
     需要 时间，预约部分段时间，对应的教练预约表名
     返回集合
     */

    //@CachePut(cacheNames = "reservationinfo",key = "#tablename+#now+#next")
    @Select("update ${tablename} " +
            "set ${timepart}=${timepart}-1" +
            " where ${tablename}.id=#{date};SELECT rc.id,rc.`status`,rc.time1,rc.time2,rc.time3," +
            "rc.time4,rc.time5,rc.time6,rc.time7,rc.time8,rc.time9," +
            "rc.time10,rc.time11,rc.time12,rc.time13,rc.time14,rc.time15," +
            "rc.time16,rc.time17,rc.time18,rc.time19,rc.time20" +
            " FROM ${tablename} AS rc where rc.id=#{now} or rc.id=#{next} order by id asc")
    public List<ReservationCount> scholarreservation(@Param("date")String date, @Param("now")String now, @Param("next")String next, @Param("timepart")String timepart, @Param("tablename")String tablename);


    /**
     * 预约修改表字段
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
    @Select("update ${tablename} " +
            "set ${timepart}=${timepart}-1" +
            " where ${tablename}.id=#{date}")
    public String scholarreservationNoSearch(@Param("date")String date, @Param("now")String now, @Param("next")String next, @Param("timepart")String timepart, @Param("tablename")String tablename);


    /*
    存放预约信息
    "scholarreservationinfo",key = "#tablename+#date+#timepart
     */
    @Caching(
            evict = {
                    @CacheEvict(cacheNames = "reservationinfo",key = "#tablename+#ri.timeid+#ri.timepart"),
                    @CacheEvict(cacheNames = "reservationinfo",key = "#tablename+#ri.userid")
            }
    )
    @Insert("INSERT INTO ${tablename}(timepart,`status`,userid,time,timeid,name) values(#{ri.timepart},#{ri.status},#{ri.userid},#{ri.time},#{ri.timeid},#{ri.name})")
    public int saveReservationMassage(@Param("ri")ReservationInfo ri,@Param("tablename")String tablename);

    /*
    查询具体一个时间段的预约信息
     */
    public int getOneReservationMassage(@Param("date")String date,@Param("timepart")String timepart,@Param("tablename")String tablename);

    /**
     * 查看这个人当天是否有预约记录
     */
   // @Cacheable(cacheNames = "scholarreservationinfo",key="#date+#username+#tablename")
    @Select("select count(userid) from ${tablename} where userid=#{username} and timeid=#{date}")
    public Integer getWhetherReservation(@Param("date")String date,@Param("username")String username,@Param("tablename")String tablename);

    /*
    根据预约时间，预约状态，查询
     */

    @Select("SELECT rd.id,rd.timepart,rd.`status`,rd.userid,rd.time,rd.timeid,rd.`name` FROM ${tablename} AS rd where rd.userid=#{userid} and rd.status=0 order by timeid desc")
    public CopyOnWriteArrayList<ReservationInfo> getReservationInfoAllByStatusWhetheris0(@Param("tablename")String tablename,@Param("userid")String userid);

     @Select("select scholar.cost from scholar where idcard=#{userid}")
    public Integer Inreservation(@Param("userid")String userid);
}
