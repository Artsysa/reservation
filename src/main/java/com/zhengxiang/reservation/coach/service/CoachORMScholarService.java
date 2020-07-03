package com.zhengxiang.reservation.coach.service;


import com.zhengxiang.reservation.coach.mapper.CoachMapper;
import com.zhengxiang.reservation.coach.mapper.CoachORMScholarMapper;
import com.zhengxiang.reservation.commonPOJO.Coach;
import com.zhengxiang.reservation.commonPOJO.ReservationInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class CoachORMScholarService {

    @Autowired
    CoachORMScholarMapper cmm;
    @Autowired
    CoachMapper cm;

    /*
     查询当前时间段预约人的信息
     根据 时间，表名，哪个时间段
   */
    public CopyOnWriteArrayList<ReservationInfo> getCoachParttimeReservationInfo(HttpServletRequest req, String date, String timepart){
        Coach coach = (Coach) req.getSession().getAttribute("coach");
        return cmm.getOneCoachORMReservationInfo(date, cm.getReservationDetailTableName(coach.getIdcard()), timepart);
    }


    /**
     * 查询教练今天和明天所有预约记录
     * @param req
     * @return
     */
    public CopyOnWriteArrayList<ReservationInfo> getOneDayReservation(HttpServletRequest req){
        Coach coach = (Coach) req.getSession().getAttribute("coach");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar date = Calendar.getInstance();
        String now = sdf.format(new Date());
        date.add(Calendar.DAY_OF_MONTH,1);
        String next = sdf.format(date.getTime());
        CopyOnWriteArrayList<ReservationInfo> oneDayReservationInfo = cmm.getOneDayReservationInfo(cm.getReservationDetailTableName(coach.getIdcard()), now, next);
        return oneDayReservationInfo;
    }
}
