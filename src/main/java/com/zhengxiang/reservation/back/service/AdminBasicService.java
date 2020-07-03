package com.zhengxiang.reservation.back.service;/*

 * @return: $return$

 * @Author: $user$

 * @Date: $date$ $time$

 */

import com.zhengxiang.reservation.back.mapper.AdminBasicMapper;
import com.zhengxiang.reservation.commonPOJO.AdminUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class AdminBasicService {

    @Autowired
    AdminBasicMapper abm;


    /**
     * 判断是否存在用户
     * @param username
     * @return
     */
    public Integer ifexitAdminUser(String username){
        return abm.ifexitAdminUser(username);
    }

    /**
     * 查询用户信息并返回实体对象
     * @param username
     * @param password
     * @return
     */
    public AdminUser getOneAdminUser(String username, String password){
        return abm.getOneAdminUser(username, password);
    }

    /**
     * 登陆逻辑处理
     * @param username
     * @param password
     * @param req
     * @return
     */
    public String login(String username, String password, HttpServletRequest req){
       //查数据库，先判断是否用此用户若没有直接返回
        if(ifexitAdminUser(username)==1){
            //在判断用户和密码是否正确
            AdminUser oneAdminUser = getOneAdminUser(username, password);
            if(oneAdminUser!=null){
                req.getSession().setAttribute("admin",oneAdminUser);
                return "1";
            }
            return "用户名或密码错误";
        }
        return "用户名不存在";
    }
}
