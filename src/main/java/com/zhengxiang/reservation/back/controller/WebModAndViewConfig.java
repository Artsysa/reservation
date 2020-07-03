package com.zhengxiang.reservation.back.controller;/*

 * @return: $return$

 * @Author: $user$

 * @Date: $date$ $time$

 */

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Component
public class WebModAndViewConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/main").setViewName("main");
        registry.addViewController("/coachpage").setViewName("coachtable");
        registry.addViewController("/co/insert").setViewName("insertcoach");
    }
}
