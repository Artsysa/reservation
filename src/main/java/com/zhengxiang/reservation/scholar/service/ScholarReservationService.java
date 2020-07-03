package com.zhengxiang.reservation.scholar.service;

import com.zhengxiang.reservation.back.mapper.CoachBackMapper;
import com.zhengxiang.reservation.coach.mapper.CoachMapper;
import com.zhengxiang.reservation.coach.service.CoachService;
import com.zhengxiang.reservation.commonPOJO.ReservationInfo;
import com.zhengxiang.reservation.commonPOJO.Scholar;
import com.zhengxiang.reservation.scholar.mapper.ScholarMapper;
import com.zhengxiang.reservation.timetask.service.PublicTaskFunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class ScholarReservationService {
    @Autowired
    ScholarMapper sm;
    @Autowired
    CoachService sc;
    @Autowired
    PublicTaskFunctionService pts;
    @Autowired
    CoachMapper cm;
    @Autowired
    SimpleDateFormat sdf;
    @Autowired
    CoachBackMapper cbm;
/*
学员约车操作
首先先吧当前时间段剩余次数减少一次
在往约车信息表中插入具体预约信息
 */

    public  String Reservation(HttpServletRequest req, String date, String timepart){
       Scholar scholar =(Scholar) req.getSession().getAttribute("scholar");
       //查询教练对应的约车表
       String reservationDetailTableName = sc.getReservationDetailTableName(scholar.getCoachid());
       String reservationcountname = sc.CoachGetReservationcountTablename(scholar.getCoachid());
       String mass="";
     //判断是否满足预约条件
      mass=  ReservationCondition(req,date,reservationDetailTableName,reservationcountname,scholar);
      if(mass.equals("1")){
          return updatereservation(date,timepart,req,reservationcountname,scholar,reservationDetailTableName,1);
      }

      return mass;
    }

    /**
     * 判断学生当前是否可以预约
     * @param scholar
     * @return
     */
    public boolean ifreservation(Scholar scholar){
        System.out.println(sm.Inreservation(scholar.getIdcard()));
        return sm.Inreservation(scholar.getIdcard())==1?true:false;
    }

    /*
    预约前先检查是否符合预约条件
    1.选择的当前日期是否已经预约过
    2.是否连续两天预约过但没有到现场
    3.查询当前预约时间段是否已经被管理员设置为禁止预约
     */
    public String ReservationCondition(HttpServletRequest req, String date,
            String reservationDetailTableName,String reservationcountname,Scholar scholar){
        String mass="预约失败";
        mass=getOneScholarWhetherReservationInfo(scholar.getIdcard(),date,reservationDetailTableName);
       if(mass.equals("1")){
           if(!ifreservation(scholar)) {
               mass="当前管理员已禁止您预约";
               return mass;

           }
           mass = ReservationCondition1(reservationDetailTableName, date, scholar);
               if (mass.equals("1")) {
                   return "1";
               }
       }
       return mass;
    }

    /*
    预约条件判断
    是否连续两天预约过但没有赴约
     */

    public String ReservationCondition1(String reservationDetailTableName,String reservationdate,Scholar scholar){
        CopyOnWriteArrayList<ReservationInfo> reversationWheterStatusis0 =
                getReversationWheterStatusis0(reservationDetailTableName, scholar.getIdcard());
        Calendar date = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
       try {
           //遍历预约日期，看是否存在有两天连续的情况
           long time2=0;
           //设置标志位,如果存在两天连续则设置为true
           boolean flage=false;
           for (ReservationInfo ri:
                   reversationWheterStatusis0) {

               long time1 = sdf.parse(ri.getTimeid()).getTime();
               if((Math.abs((time2-time1))/(1000 * 60 * 60 * 24))>=1){
                   flage=true;
                   time2=sdf.parse(ri.getTimeid()).getTime();
                   break;
               }

               System.out.println((Math.abs((time2-time1))/(1000 * 60 * 60 * 24)));
              // System.out.println(ri.getTimeid());
               time2=sdf.parse(ri.getTimeid()).getTime();
           }
           System.out.println(flage);
           if(flage){
               //用选择预约的日子减去查出来的time2日子，如果小于三天则不让预约
               long reservationtime = sdf.parse(reservationdate).getTime();
               long l = (reservationtime - time2) / (1000 * 60 * 60 * 24);
               if(l<=3){
                //   System.out.println(l);
                   if((3-l)==0)
                       return "由于您已连续两次预约成功但未到，系统将限制您在三个工作日后可进行预约，但您可以预约明天";
                   return "由于您已连续两次预约成功但未到，系统将限制您在三个工作日后可进行预约，"+(3-l)+"天后可进行预约";
               }
           }

       } catch (Exception e) {
           e.printStackTrace();
       }

        return "1";
    }

    /*
    预约修改数据库操作
     */

    @Scope(proxyMode = ScopedProxyMode.INTERFACES)
    @Transactional(rollbackFor=Exception.class)
    public synchronized String updatereservation(String date,
          String timepart, HttpServletRequest req,String reservationcountname,Scholar scholar,
           String reservationDetailTableName,int state){
      if(state==1){
          try {
              //当前时间段时候还有剩余预约数量
              String reservationTimepartRemainderCount = pts.getReservationTimepartRemainderCount(date, timepart, req);
              if(Integer.parseInt(reservationTimepartRemainderCount)==0){
                  return "本时间段预约的人数已满";
              }else if(Integer.parseInt(reservationTimepartRemainderCount)==9){
                  return "当前时间段已被管理员设置为不可预约状态，请选择其他时间段预约";
              }

              String next =null,now=null;
              try {
                  Calendar date1 = Calendar.getInstance();
                  now = sdf.format(date1.getTime());
                  date1.add(Calendar.DAY_OF_MONTH,1);
                  next=sdf.format(date1.getTime());

              } catch (Exception e) {
                  e.printStackTrace();
              }
              if(!"0".equals( String.valueOf(sm.scholarreservationNoSearch(date,now,next,timepart,reservationcountname)))){
                  SimpleDateFormat st = new SimpleDateFormat("yyyy-MM-dd:HH:mm:ss");
                  sm.saveReservationMassage(new ReservationInfo(timepart,"1",
                                  scholar.getIdcard(),st.format(new Date()),scholar.getName(),date)
                          ,reservationDetailTableName);
                  return "1";
              }

          } catch (Exception e) {
              e.printStackTrace();
          }
          return "预约失败";
      }else{
          String next =null,now=null;
          Calendar date1 = Calendar.getInstance();
          now = sdf.format(date1.getTime());
          date1.add(Calendar.DAY_OF_MONTH,1);
          next=sdf.format(date1.getTime());
          if(String.valueOf(cm.setreservationequal9(date,now,next,timepart,reservationcountname)).equals("1")){
         cbm.deleteReservationInfoTimepartAll(timepart,date,reservationDetailTableName);
              return "修改成功";
          }
          return "服务器繁忙请稍重新尝试";
      }
    }






    /*
    查询某人当天是否已经有预约记录
    如果没有则返回true反之如果已经预约了则返回false
    @Param("date")String date,@Param("username")String username,@Param("tablename")String tablename);
     */
    public String getOneScholarWhetherReservationInfo(String userid, String date,String tablename){
        return sm.getWhetherReservation(date,userid,tablename)==0?"1":"您今天已经预约过了";
    }

    /*
    查询某人预约状态为0的所有预约信息
     */
    public CopyOnWriteArrayList<ReservationInfo> getReversationWheterStatusis0(String tablename,String userid){
        return sm.getReservationInfoAllByStatusWhetheris0(tablename,userid);
    }

}
