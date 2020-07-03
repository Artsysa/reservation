package com.zhengxiang.reservation.back.mapper;/*

 * @return: $return$

 * @Author: $user$

 * @Date: $date$ $time$

 */


import com.zhengxiang.reservation.commonPOJO.ReservationInfo;
import com.zhengxiang.reservation.commonPOJO.Scholar;
import org.apache.ibatis.annotations.*;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Mapper
public interface ScholarBackMapper {


    /**
     * 查询教练地下对应的学员信息
     * 缓存存放 一个教练对应地下所有学员的信息
     * @param coachid
     * @return
     */
    @Cacheable(cacheNames = "coachormallschoalr",key = "#coachid")
    @Select("SELECT a.id,a.`name`,a.a.telephone,a.a.address,a.cost,a.coachid" +
            " FROM scholar AS a WHERE a.coachid=#{coachid}")
    public CopyOnWriteArrayList<Scholar> getORMcoachAllScholar(String coachid);

    /**
     * 插入一个学员信息
     * @param scholar
     * @return
     */
    @Caching(evict = {
            @CacheEvict(cacheNames = "scholarinfoallbyid", allEntries = true)
            ,@CacheEvict(cacheNames = "scholarinfobriefall" ,allEntries = true)
    })
    @Insert("insert into scholar(name,idcard,telephone,gender,address,cost,password,coachid) " +
            "values(#{s.name},#{s.idcard},#{s.telephone},#{s.gender}," +
            "#{s.address},#{s.cost},#{s.password},#{s.coachid})")
    public Integer insertScholar(@Param("s") Scholar scholar);

    /**
     * 根据教练id
     * 获取他地下的学员简要信息填充下拉菜单
     * @param coachid
     * @return
     */
    @Cacheable(cacheNames = "scholarinfobriefall",key = "#coachid")
    @Select("select name,idcard from scholar where coachid=#{id}")
    public List<Scholar> getScholarBriefInfo(@Param("id") String coachid);

    /**
     * 查询某个教练下的所有学员
     * @param user
     * @return
     */
    @Cacheable(cacheNames = "scholarinfoallbyid",key = "#coachid+#PageSize+#PageNow")
    @Select("SELECT scholar.id,scholar.name,scholar.idcard,scholar.telephone,scholar.gender,scholar.address,scholar.cost,scholar.`password`,scholar.coachid FROM scholar WHERE scholar.coachid= #{id}")
    public List<Scholar> searchscholarbycoachidinfo(@Param("id")String coachid,String PageNow,String PageSize);

    /**
     * 查询学员预约记录
     * 根据学员id
     * 缓存关系---和插入学员预约记录有关
     * @param tablename
     * @param scholarid
     * @return
     */

    @Cacheable(cacheNames = "reservationinfoall",key = "#tablename+#scholarid+#pagesize+#pagenow")
    @Select("SELECT c.id,c.timepart,c.`status`,c.userid,c.time," +
            "c.timeid,c.`name` FROM" +
            "  ${tablename} AS c WHERE c.userid=#{id} order by c.timeid desc")
    public List<ReservationInfo> getReservationInfoByCoachidAndScholar(
            @Param("tablename") String tablename,@Param("id") String scholarid,String pagesize,String pagenow);

    /**
     * 删除该用户所有练车记录
     *
     * @param tablename
     * @param scholarid
     * @return
     */
    @Caching(
            evict = {
                    @CacheEvict(cacheNames = "reservationinfo",allEntries = true),
            @CacheEvict(cacheNames = "reservationinfoall",allEntries = true),
            @CacheEvict(cacheNames = "reservationinfopart",allEntries = true)
            }
    )
    @Delete("delete from ${tablename}  where userid=#{id} ")
    public Integer DeleteReservationInfo(@Param("tablename") String tablename,@Param("id") String scholarid);

    /**
     * 将用户预约状态设置为0
     * 即不可进行预约操作
     * @param scholarid
     * @return
     */
    @CacheEvict(cacheNames = "scholarinfoallbyid",allEntries = true)
    @Update("update  scholar set cost=0 where idcard=#{id}")
    public Integer UpdateScholarStatus(@Param("id") String scholarid,String coachid);

    /**
     * 删除一个学员，包括信息以及约车记录
     * @param shcolarid
     * @return
     */
    @Caching(evict = {
            @CacheEvict(cacheNames = "scholarinfoallbyid", allEntries = true)
            ,@CacheEvict(cacheNames = "scholarinfobriefall" ,allEntries = true),
            @CacheEvict(cacheNames = "reservationinfo",allEntries = true),
            @CacheEvict(cacheNames = "reservationinfopart",allEntries = true)
    })
    @Delete("call detescholar(#{id})")
    public Integer deteleScholar(@Param("id") String shcolarid);
}
