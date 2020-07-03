package com.zhengxiang.reservation.back.service;/*

 * @return: $return$

 * @Author: $user$

 * @Date: $date$ $time$

 */

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhengxiang.reservation.back.mapper.ScholarBackMapper;
import com.zhengxiang.reservation.back.tools.TimePartTranStrandTime;
import com.zhengxiang.reservation.coach.mapper.CoachMapper;
import com.zhengxiang.reservation.commonPOJO.ReservationInfo;
import com.zhengxiang.reservation.commonPOJO.Scholar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class ScholarBackService {
    @Autowired
    ScholarBackMapper sbm;
    @Autowired
    CoachMapper cm;
    public String insertScholar(Scholar scholar){
        scholar.setCost(1);
        scholar.setPassword(scholar.getIdcard().substring(12));
        return sbm.insertScholar(scholar)==1?"1":"0";
    }

    public List<Scholar> getScholarBriefInfo(String coachid){
        return sbm.getScholarBriefInfo(coachid);
    }

    public List<Scholar> getScholarByCoachid(String coachid,int PageNow,int PageSize){
        return sbm.searchscholarbycoachidinfo(coachid, String.valueOf(PageSize + 'i'), String.valueOf(PageNow));

    }

    /**
     * 获取某一个学员所有预约记录
     * @param shcolarid
     * @param tablename
     * @return
     */
    public void getReservationByShcolarid(String shcolarid, String coachid,
                         int pagenow, int pagesize, Model m){
        String detialname = cm.getReservationDetailTableName(coachid);
        PageHelper.startPage(pagenow,pagesize);
        List<ReservationInfo> reservationInfoByCoachidAndScholar = sbm.getReservationInfoByCoachidAndScholar
                (detialname, shcolarid, String.valueOf(pagesize + 'i'), String.valueOf(pagenow));
        PageInfo<ReservationInfo> page = new PageInfo<>(reservationInfoByCoachidAndScholar);
        for (ReservationInfo s:reservationInfoByCoachidAndScholar
             ) {
            s.setTimepart(TimePartTranStrandTime.Tran(s.getTimepart()));
        }
        m.addAttribute("reservationinfo",reservationInfoByCoachidAndScholar);
        m.addAttribute("page",page);
    }
    public String deleterScholarAllByid(String coachid,String scholarid){
        String detialname = cm.getReservationDetailTableName(coachid);
        Integer integer = sbm.DeleteReservationInfo(detialname, scholarid);
        return "共删除了"+String.valueOf(integer)+"记录";
    }

    public String UpdateSetScholarReservationStatusTo0(String scholarid,String coachid){
       return sbm.UpdateScholarStatus(scholarid,coachid)==1?"设置成功":"服务器繁忙请稍后尝试";
    }

    public String deteleSchoalIDbYscholarid(String shcolarid){
        try {
            sbm.deteleScholar(shcolarid);
            return "删除成功";
        } catch (Exception e) {

            e.printStackTrace();
        }
        return "服务器繁忙请稍后再试";
    }
}
