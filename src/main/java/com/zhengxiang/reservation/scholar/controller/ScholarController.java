package com.zhengxiang.reservation.scholar.controller;

import com.github.pagehelper.PageHelper;
import com.zhengxiang.reservation.coach.service.CoachService;
import com.zhengxiang.reservation.commonPOJO.Scholar;
import com.zhengxiang.reservation.scholar.service.ScholarReservationService;
import com.zhengxiang.reservation.scholar.service.ScholarSelectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/sl")
public class ScholarController {
    @Autowired
    ScholarSelectService sss;
    @Autowired
    ScholarReservationService srs;
    @Autowired
    CoachService cs;
    /*
    密码和用户名校验
    @RequestParam("username")String username, @RequestParam("password")String pass){
     */

    @RequestMapping(value = "/login")
    @ResponseBody
    public String scholarlogin(HttpServletResponse rep, HttpServletRequest req, @RequestParam("username") String username, @RequestParam("password")  String password){
        String sessionid = sss.ScholarLogin(username, password, req);

        if(!sessionid.equals("0")){
            Scholar scholar = (Scholar)req.getSession().getAttribute("scholar");
            if(cs.getOneCoachInfobyIDcard(scholar.getCoachid())!=null)
            return sessionid;
            else return "2";

        }
        return "0";
    }

    /*
    获取用户信息
     */
    @ResponseBody
    @RequestMapping("/info")
    public String getOneScholar(@RequestParam("username") String username, HttpServletRequest req){
        return sss.getOneScholar(username,req).toString();
    }

    /*
    修改密码
        @RequestParam("username")String username,@RequestParam("pass")String pass){

     */
    @RequestMapping("/attr")
    @ResponseBody
    public String atterpass(@RequestParam("username")String username,@RequestParam("pass")String pass){
        return String.valueOf(sss.attrPass(username, pass));
    }

    /*
    预约练车
     */
    @ResponseBody
    @RequestMapping("/rt")
    public String Reservation(@RequestParam("date")String date,@RequestParam("timepart")String timepart,
                              HttpServletRequest request){
        PageHelper.clearPage();
        String mass= srs.Reservation(request, date, timepart);
       return mass.equals("1")?"预约成功":mass;
    }

//    @Transactional
//    @RequestMapping("/a")
//    @ResponseBody
//    public String aa(){
//        String mas=null;
//        ScholarController scholarController = new ScholarController();
//        System.out.println("hhh"+scholarController.hashCode());
//       try {
//           System.out.println(1/0);
//       } catch (Exception e) {
//          mas="error";
//       }finally {
//           return mas;
//       }
//    }
}
