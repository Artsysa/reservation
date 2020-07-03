package com.zhengxiang.reservation.back.mapper;/*

 * @return: $return$

 * @Author: $user$

 * @Date: $date$ $time$

 */


import com.zhengxiang.reservation.commonPOJO.AdminUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.cache.annotation.Cacheable;

/**
 * 用于查询管理员基本信息
 */

@Mapper
public interface AdminBasicMapper {

    /**
     *判断当前用户名或密码是否正确
     * 若正确则返回实体对象否则返回null
     * @param username
     * @param password
     * @return
     */
    @Cacheable(cacheNames = "admininfo" ,key = "#username+#password")
    @Select("SELECT a.username,a.`password`" +
            " FROM admin AS a WHERE a.username=#{username} AND a.`password`=#{password}")
    public AdminUser getOneAdminUser(@Param("username") String username,
                                     @Param("password") String password);

    /**
     * 查询当前是否存在
     * @param username
     * @return
     */
    @Cacheable(cacheNames = "admininfo" ,key = "#username")
    @Select("SELECT COUNT(a.username) FROM admin AS a WHERE a.username =#{username}")
    public Integer ifexitAdminUser(@Param("username") String username);




}
