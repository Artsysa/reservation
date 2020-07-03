package com.zhengxiang.reservation.back.controller;/*

 * @return: $return$

 * @Author: $user$

 * @Date: $date$ $time$

 */

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhengxiang.reservation.back.service.ScholarBackService;
import com.zhengxiang.reservation.commonPOJO.Scholar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/sb")
public class ScholarBackController {

    @Autowired
    ScholarBackService sbs;

    /**
     * 添加学员信息
     * @param scholar
     * @return
     */
    @ResponseBody
    @RequestMapping("/add")
    public String insertScholar(Scholar scholar){
        System.out.println(scholar.toString());
        return sbs.insertScholar(scholar);
    }

    /**
     * 根据教练id
     * 查询改id下所有对应的学员简要信息
     * @param m
     * @param coachid
     * @return
     */
    @RequestMapping("/sl")
    public String getScholarBrief(Model m, @RequestParam("coachid") String coachid){
        PageHelper.clearPage();
        m.addAttribute("scholarinfo",sbs.getScholarBriefInfo(coachid));
         return "reservationtable::shcolarlist";
    }

    /**
     * 根据教练id查询学员具体信息
     * @param m
     * @param coachid
     * @return
     */
    @RequestMapping("/sde")
    public String getScholarInfoByCoachid(Model m, @RequestParam("coachid")String coachid, @RequestParam(value = "p",defaultValue = "1") int PageNow,
                                          @RequestParam(value = "s",defaultValue = "4",required = false) int PageSize){
        PageHelper.startPage(PageNow,PageSize);
        List<Scholar> scholarByCoachid = sbs.getScholarByCoachid(coachid,PageNow,PageSize);
        PageInfo<Scholar> page = new PageInfo<>(scholarByCoachid);
        m.addAttribute("scholardetail",scholarByCoachid);
        m.addAttribute("page",page);
        m.addAttribute("coachid",coachid);
        return "scholarmassage::scholarinfo";
    }

    /**
     * 查询一个学员所有预约记录
     * @param m
     * @param coachid
     * @param scholarid
     * @param PageNow
     * @param PageSize
     * @return
     */
    @RequestMapping("/reinfo")
    public String getReservationByscholarid(Model m, @RequestParam("coachid")String coachid,@RequestParam("scholarid")String scholarid,
             @RequestParam(value = "p",defaultValue = "1") int PageNow,
             @RequestParam(value = "s",defaultValue = "4",required = false) int PageSize){
        sbs.getReservationByShcolarid(scholarid,coachid,PageNow,PageSize,m);
        m.addAttribute("coachid",coachid);
        m.addAttribute("scholarid",scholarid);
       return "reservationtable::reservation";
    }

    /**
     * 删除用户所有1预约练车记录
     * @param coachid
     * @param scholarid
     * @return
     */
    @ResponseBody
    @RequestMapping("/det")
    public String DeleteScholarReservationAll(@RequestParam("coachid")String coachid,@RequestParam("scholarid")String scholarid){
       return sbs.deleterScholarAllByid(coachid, scholarid);
    }

    /**
     * 修改学员是否可以练车字段
     * 让用户无法继续预约练车
     * @param scholarid
     * @return
     */
    @ResponseBody
    @RequestMapping("/cost")
    public String updateScholarCostStatus(@RequestParam("scholarid")String scholarid,@RequestParam("coachid")String coachid){
        return sbs.UpdateSetScholarReservationStatusTo0(scholarid,coachid);
    }

    /**
     * 删除一个学员所有信息
     * 个人信息
     * 约车记录
     * @param scholar
     * @return
     */
    @ResponseBody
    @RequestMapping("/deta")
    public String deteleScholarAllInfo(@RequestParam("scholarid") String scholar){
        return sbs.deteleSchoalIDbYscholarid(scholar);
    }


}
