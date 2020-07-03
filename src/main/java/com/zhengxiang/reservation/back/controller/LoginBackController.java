package com.zhengxiang.reservation.back.controller;/*

 * @return: $return$

 * @Author: $user$

 * @Date: $date$ $time$

 */

import com.zhengxiang.reservation.back.service.AdminBasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Controller
@RequestMapping("/back")
public class LoginBackController {

    @Autowired
    AdminBasicService abs;
    @Autowired
    SimpleDateFormat sdf;

    @ResponseBody
    @RequestMapping("/login")
    public String login(@RequestParam(value = "username",required = true)
    String username, @RequestParam(value = "password",required = true)
            String password, HttpServletRequest req){
        return  abs.login(username,password,req);
    }

    @RequestMapping("/date")
    public String getDate(Model m){
        String now = sdf.format(new Date());
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.DAY_OF_MONTH,1);
        String next=sdf.format(instance.getTime());
        m.addAttribute("now",now);
        m.addAttribute("next",next);
        return "reservationsettingtable::date";

    }
}
