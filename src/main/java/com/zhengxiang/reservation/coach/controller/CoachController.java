package com.zhengxiang.reservation.coach.controller;

import com.github.pagehelper.PageHelper;
import com.zhengxiang.reservation.coach.service.CoachORMScholarService;
import com.zhengxiang.reservation.coach.service.CoachService;
import com.zhengxiang.reservation.commonPOJO.Coach;
import com.zhengxiang.reservation.commonPOJO.ReservationInfo;
import com.zhengxiang.reservation.commonPOJO.Scholar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.CopyOnWriteArrayList;

@Controller
@RequestMapping("/cc")
public class CoachController {

    @Autowired
    CoachService sc;
    @Autowired
    CoachORMScholarService cms;
    /*
    获取一个教练的信息
     */
    @ResponseBody
    @RequestMapping("/info")
    public String getCoachInfo(HttpServletRequest req, @RequestParam(value = "coachid",required = false)String coachid){
       if(coachid!=null){
           return sc.getOneCoachInfobyIDcard(coachid).toString();
       }
        Scholar scholar =(Scholar) req.getSession().getAttribute("scholar");
        return sc.getOneCoachInfobyIDcard(scholar.getCoachid()).toString();
    }


    public String a(){
        return "succ";
    }
    /*
    教练登录并返回sessionid
     */
    @ResponseBody
    @RequestMapping("/login")
    public String login(HttpServletRequest req,@RequestParam(value = "username")String coachid
     ,@RequestParam("password")String password){
        if(sc.existCoach(coachid,password)){
            req.getSession().setAttribute("coach", sc.getOneCoachInfobyIDcard(coachid));
            return req.getSession().getId();
        }
        return "0";
    }
    /*
    修改公告信息
     */
    @ResponseBody
    @RequestMapping("/advice")
    public String updateAdvice(HttpServletRequest req,@RequestParam("advice") String advice){
         Coach coach = (Coach) req.getSession().getAttribute("coach");
        PageHelper.clearPage();
        return sc.updateAdvice(coach.getIdcard(),advice).toString();
    }


    /*
     查询当前时间段预约人的信息
     根据 时间，表名，哪个时间段
   */
    @ResponseBody
    @RequestMapping("/tpri")
    public String getCoachReservationtimepartInfo(
            @RequestParam("date")String date,@RequestParam("timepart")String timepart,HttpServletRequest req
    ){
        CopyOnWriteArrayList<ReservationInfo> coachParttimeReservationInfo = cms.getCoachParttimeReservationInfo(req, date, timepart);
        if(coachParttimeReservationInfo!=null){
            return coachParttimeReservationInfo.toString();
        }
        return "0";
    }

    /**
     * 教练端查询今天和明天的所有约车记录
     * @param req
     * @return
     */
    @ResponseBody
    @RequestMapping("/ri")
    public String getTwoReseraction(HttpServletRequest req){

        PageHelper.clearPage();
        return  cms.getOneDayReservation(req).toString();
    }


    /**
     * 若学员已经预约但未去，则修改学员为不诚信状态
     *
     * 改状态连续两次则三个工作日内不能进行预约
     * @param date
     * @param userid
     * @param req
     * @return
     */
    @ResponseBody
    @RequestMapping("/attrstate")
    public String updateScholarReservationState(@RequestParam("date") String date,@RequestParam("username") String userid,HttpServletRequest req){
        PageHelper.clearPage();
        return sc.updateScholarReservationState(date,userid,req)==1?"1":"0";
    }







}
