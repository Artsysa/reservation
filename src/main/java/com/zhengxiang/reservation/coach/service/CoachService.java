package com.zhengxiang.reservation.coach.service;

import com.zhengxiang.reservation.coach.mapper.CoachMapper;
import com.zhengxiang.reservation.commonPOJO.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class CoachService {

    @Autowired
    CoachMapper cm;
    /*
    获取教练对应的预约学员信息的表名
     */

    public String getReservationDetailTableName(String id){
        return cm.getReservationDetailTableName(id);
    }

    /*
   获取教练对应每天预约信息的表名
    */
    public String CoachGetReservationcountTablename(String id){
        return cm.getReservationcountTableName(id);
    }

    /*
    获取教练基本信息 根据id
     */

    public Coach getOneCoachInfo(String coachid){
        return cm.searchoneinfobyid(coachid);
    }
  /*
    获取教练基本信息 根据身份证号
     */

    public Coach getOneCoachInfobyIDcard(String coachid){
        return cm.searchoneinfobyidbyidcard(coachid);
    }
    /*
    判断是否存在用户名和密码
     */
    public boolean existCoach(String username,String password){
        return cm.scholarlogin(username,password)==0?false:true;
    }

    /*
    更新教练通知信息
     */
    public String updateAdvice(String coachid,String advice){
        return cm.updateAdvice(coachid,advice)!=null?"通告发布成功":"网络拥塞请稍后重新发布";
    }

    /**
     * 更新学员是否预约成功但没有去
     * @param date
     * @param userid
     * @param req
     * @return
     */
    public Integer updateScholarReservationState(String date,String userid,HttpServletRequest req){
        Coach coach = (Coach)req.getSession().getAttribute("coach");
        return cm.UpdateScholarReservationState(date,userid,cm.getReservationDetailTableName(coach.getIdcard()));
    }


}
