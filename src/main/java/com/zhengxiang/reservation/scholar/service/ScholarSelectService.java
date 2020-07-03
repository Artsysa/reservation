package com.zhengxiang.reservation.scholar.service;

import com.zhengxiang.reservation.commonPOJO.Scholar;
import com.zhengxiang.reservation.scholar.mapper.ScholarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class ScholarSelectService {
    @Autowired
    ScholarMapper sm;
    /*
    若登录用户名或密码不存在或错误则返回值为0否则为1
     */

    public String ScholarLogin(String user,String password,HttpServletRequest req){
        if(sm.scholarlogin(user,password)!=0){
            //获取用户信息
            getOneScholar(user,req);
            return req.getSession().getId();
        }
            return "0";




    }
    /*
    查询学员信息
     */

    public Scholar getOneScholar(String username, HttpServletRequest req){
        Scholar searchoneinfo = sm.searchoneinfo(username);
        req.getSession().setAttribute("scholar",searchoneinfo);
//        req.getSession().setAttribute("scholarid",username);
//        req.getSession().setAttribute("coachid",searchoneinfo.getCoachid());
        return searchoneinfo;
    }
    @CachePut(cacheNames = "scholar",key = "#id")
    public Scholar attrPass(String id,String pass){
         return sm.alterpass(pass,id);

    }
}
