package com.zhengxiang.reservation.back.service;/*

 * @return: $return$

 * @Author: $user$

 * @Date: $date$ $time$

 */

import com.zhengxiang.reservation.back.mapper.CoachBackMapper;
import com.zhengxiang.reservation.back.mapper.ScholarBackMapper;
import com.zhengxiang.reservation.back.tools.TimePartTranStrandTime;
import com.zhengxiang.reservation.back.tools.UploadFileTools;
import com.zhengxiang.reservation.coach.mapper.CoachMapper;
import com.zhengxiang.reservation.coach.mapper.CoachORMScholarMapper;
import com.zhengxiang.reservation.coach.service.CoachService;
import com.zhengxiang.reservation.commonPOJO.Coach;
import com.zhengxiang.reservation.commonPOJO.ReservationCount;
import com.zhengxiang.reservation.commonPOJO.ReservationInfo;
import com.zhengxiang.reservation.commonPOJO.Scholar;
import com.zhengxiang.reservation.scholar.service.ScholarReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class CoachBackService {
    @Autowired
    CoachBackMapper cm;
    @Autowired
    SimpleDateFormat sdf;
    @Autowired
    CoachMapper cms;
    @Autowired
    CoachService sc;
    @Autowired
    CoachORMScholarMapper cmm;
    @Autowired
    ScholarBackMapper sbm;
    @Autowired
    ScholarReservationService srs;

    public List<Coach> getAllCoach(int PageNow, int PageSize){
        return cm.getAllCoachInfo(String.valueOf(PageNow),String.valueOf(PageSize+'i'));
    }

    /**
     * 添加教练信息
     * 创建对应的表
     * 插入表之间的映射关系
     * @param coach
     * @return
     */
    @Transactional(rollbackFor={Exception.class,Error.class})
    public Integer insertMassage(Coach coach){
        Integer id=-1;
        try {
            coach.setPassword(coach.getIdcard().substring(12));
            id = cm.addCoach(coach);
          if(id>0){
              //创建表
            cm.CallInsertCoachProcedure(coach.getIdcard(),String.valueOf(id));
              String now = sdf.format(new Date());
              Calendar instance = Calendar.getInstance();
              instance.add(Calendar.DAY_OF_MONTH,1);
              String next=sdf.format(instance.getTime());
              cm.insetCurrentReservationCountData(String.valueOf(id),now,next);
            return 1;
          }
      } catch (Exception e) {
            cm.rollback(String.valueOf(id),coach.getId());
          e.printStackTrace();
          return 0;
      }

        return 0;
    }

    /**
     * 查询所有教练信息填充下拉菜单
     * @return
     */
    public List<Coach> getAllCoachInfoList(){
        return cm.getAllCoachInfoList();
    }


    public void getReservationOneCount(String date,
            String coachid, Model m){
        String reservationcountTableName = cms.getReservationcountTableName(coachid);
        ReservationCount oneDayReservationInfo = cm.getOneDayReservationInfo(
                reservationcountTableName, date);
        m.addAttribute("onecount",oneDayReservationInfo);
    }
    /**
     * 在预约管理中心
     * 查询某一时间段
     * 所有预约信息 detail
     * @param m
     * @param coachid
     * @param date
     * @param timepart
     * @return
     */
    public void getReservationTimepartInfoList(String date,String timepart,String coachid,Model m){
        String reservationDetailTableName = cms.getReservationDetailTableName(coachid);
        CopyOnWriteArrayList<ReservationInfo> oneCoachORMReservationInfo
                = cmm.getOneCoachORMReservationInfo(date, reservationDetailTableName, timepart);
        for (ReservationInfo r:oneCoachORMReservationInfo
             ) {
            r.setTimepart(TimePartTranStrandTime.Tran(r.getTimepart()));
        }
        m.addAttribute("info",oneCoachORMReservationInfo);
    }

    public String deleteCoachAll(String coachid){
        try {
       cm.detelCoachAll(coachid);
       return "删除成功";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "服务器繁忙,请稍后尝试";
    }

    public void GetCoachAndScholarList(Model m,String coachid){
        Coach coach = cms.searchoneinfobyidbyidcard(coachid);
        List<Scholar> searchscholarbycoachidinfo =
                sbm.searchscholarbycoachidinfo(coachid, "1", "1");
        m.addAttribute("scholarlistorm",searchscholarbycoachidinfo);
        m.addAttribute("detialcoach",coach);
    }

    public String setReservationequal9(String date,
           String timepart,String coachid){
        String reservationDetailTableName = sc.getReservationDetailTableName(coachid);
        String reservationcountTableName = cms.getReservationcountTableName(coachid);
      return  srs.updatereservation(date,timepart,null,reservationcountTableName,
                null,reservationDetailTableName,2);
    }

    public String attrpicture(String coachid, HttpServletRequest req){
      try {
          String uploadfile = UploadFileTools.uploadfile(req,coachid);
          String getpicture = cm.getpicture(coachid);
          if(!"null".equals(getpicture)){
              new File(getpicture).mkdirs();
              File file = new File(getpicture);
              if(file.exists()){
                  file.delete();
              }
          }
          cm.attrpicture(coachid,uploadfile);
          return "1";
      } catch (Exception e) {
          e.printStackTrace();
      }
        return "0";
    }
}
