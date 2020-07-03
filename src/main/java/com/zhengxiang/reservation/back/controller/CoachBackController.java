package com.zhengxiang.reservation.back.controller;/*

 * @return: $return$

 * @Author: $user$

 * @Date: $date$ $time$

 */

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhengxiang.reservation.back.service.CoachBackService;
import com.zhengxiang.reservation.commonPOJO.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/co")
public class CoachBackController {
    @Autowired
    CoachBackService cs;
    /**
     * 查询所有教练信息
     * @param mv
     * @return
     */
    @RequestMapping("/all")
    public ModelAndView getAllCoach(ModelAndView mv, @RequestParam(value = "p",defaultValue = "1") int PageNow,
     @RequestParam(value = "s",defaultValue = "7",required = false) int PageSize){
        PageHelper.startPage(PageNow,PageSize);
        List<Coach> allCoach = cs.getAllCoach(PageNow,PageSize);
        PageInfo<Coach> page = new PageInfo<>(allCoach);
        mv.addObject("coach",allCoach);
        mv.addObject("page",page);
        mv.setViewName("coachtable");
        return mv;
    }

    /**
     * 添加教练信息
     * @param coach
     * @return
     */
    @RequestMapping("/add")
    @ResponseBody
    public Integer addCoach(Coach coach){

        return cs.insertMassage(coach);
    }

    /**
     * 获取教练姓名列表填充下拉菜单
     * @param mv
     * @return
     */
    @RequestMapping("/gcl")
    public ModelAndView getAllCoachInfoList(ModelAndView mv,@RequestParam("vn") String viewname){
        PageHelper.clearPage();
        mv.addObject("coachlist",cs.getAllCoachInfoList());
        mv.setViewName(viewname);
        return mv;
    }

    /**
     * 查询某个教练的某一天预约信息count表
     * @param m
     * @param coachid
     * @param date
     * @return
     */
    @RequestMapping("/oner")
    public String getReservationcountOne(Model m, @RequestParam("coachid")String coachid,
           @RequestParam("date")  String date){
        PageHelper.clearPage();
       cs.getReservationOneCount(date, coachid, m);
       return "reservationsettingtable::manager";
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
    @RequestMapping("/tpl")
    public String  getReservationList(Model m, @RequestParam("coachid")String coachid,
            @RequestParam("date")  String date,@RequestParam("timepart")String timepart){
        PageHelper.clearPage();
        cs.getReservationTimepartInfoList(date,timepart,coachid,m);
        return "reservationsettingtable::infodetial";
    }

    @ResponseBody
    @RequestMapping("/deta")
    public String deleteCoachAll(@RequestParam("coachid") String coachid){
        return cs.deleteCoachAll(coachid);
    }


    /**
     * 查询教练具体信息以及
     * 地下所带学员信息
     * @param coachid
     * @return
     */
    @RequestMapping("/detial")
    public String SelectCoachInfo(Model m,@RequestParam("coachid")String coachid){
        PageHelper.clearPage();
        cs.GetCoachAndScholarList(m,coachid);
        return "coachtable::detials";
    }

    /**
     * 将当前时间段设置为不可预约状态
     * @param coachid
     * @param timepart
     * @param date
     * @return
     */
    @ResponseBody
    @RequestMapping("/set")
    public String setReservationequal9(@RequestParam("coachid")String coachid,
           @RequestParam("timepart") String timepart,@RequestParam("date") String date){
        PageHelper.clearPage();
      return  cs.setReservationequal9(date,timepart,coachid);
    }

    @ResponseBody
    @RequestMapping("/attr")
    public String attrpicture(@RequestParam("coachid")String coachid, HttpServletRequest req) {
        PageHelper.clearPage();
        return cs.attrpicture(coachid,req)=="1"?"上传成功请刷新查看":"服务器繁忙";

    }

}
