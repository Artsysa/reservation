package com.zhengxiang.reservation.timetask.service;

import com.zhengxiang.reservation.coach.service.CoachService;
import com.zhengxiang.reservation.commonPOJO.Coach;
import com.zhengxiang.reservation.commonPOJO.ReservationCount;
import com.zhengxiang.reservation.commonPOJO.Scholar;
import com.zhengxiang.reservation.timetask.mapper.PublicTaskFunctionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

/*
公共预约信息查询等功能
 */

@Service
public class PublicTaskFunctionService {


    @Autowired
    PublicTaskFunctionMapper ptm;
    @Autowired
    CoachService sc;
    @Autowired
    CoachService cs;
    /*
    获取身份证为id的教练的data这一天预约信息情况
     */

    public List<ReservationCount> getReservationCountTable(HttpServletRequest req){

        Scholar scholar = (Scholar) req.getSession().getAttribute("scholar");
        String next =null,now=null;
               try {
                   SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                   Calendar date = Calendar.getInstance();
                    now = sdf.format(date.getTime());
                   date.add(Calendar.DAY_OF_MONTH,1);
                 next=sdf.format(date.getTime());
               } catch (Exception e) {
                   e.printStackTrace();
               }
         if(scholar!=null) {
             return ptm.getReservationOneInfo(now, next, cs.CoachGetReservationcountTablename(scholar.getCoachid()));
         }else{
             Coach coach = (Coach) req.getSession().getAttribute("coach");
             return ptm.getReservationOneInfo(now, next, cs.CoachGetReservationcountTablename(coach.getIdcard()));
         }
    }

    /*
    获取某一天，某一个预约时间段的剩余预约次数
     */

    public String getReservationTimepartRemainderCount(String date,String timepart,HttpServletRequest req){
        Scholar scholar = (Scholar) req.getSession().getAttribute("scholar");
        return String.valueOf(ptm.getReservationOneTimePartRemainderCount(date,
                cs.CoachGetReservationcountTablename(scholar.getCoachid()), timepart));
    }
}
