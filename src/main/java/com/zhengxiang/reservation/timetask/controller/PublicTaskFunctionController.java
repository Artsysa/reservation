package com.zhengxiang.reservation.timetask.controller;


import com.github.pagehelper.PageHelper;
import com.zhengxiang.reservation.timetask.service.PublicTaskFunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/pfc")
public class PublicTaskFunctionController {

    @Autowired
    PublicTaskFunctionService pts;

    /*
    获取data这天的预约信息,,此处需要学员对应教练的id
     */
    @RequestMapping("/info")
    @ResponseBody
    public String getOneDayReservationInfo(HttpServletRequest request){
        PageHelper.clearPage();
     return  pts.getReservationCountTable(request).toString();
    }

    /*
    根据日期，预约时间段查询改时间段剩余预约次数
     */
    @RequestMapping("/remainder")
    @ResponseBody
    public String getReservationOneTimepartRemainderCount(
            @RequestParam("timepart")String timepart, @RequestParam("date")String date,
            HttpServletRequest req){
      return pts.getReservationTimepartRemainderCount(date,timepart,req);
    }
}
