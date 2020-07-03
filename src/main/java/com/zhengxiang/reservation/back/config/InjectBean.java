package com.zhengxiang.reservation.back.config;/*

 * @return: $return$

 * @Author: $user$

 * @Date: $date$ $time$

 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;

@Configuration
public class InjectBean {

    @Bean
    public SimpleDateFormat getSimpleDateFormate(){
        return new SimpleDateFormat("yyyy-MM-dd");
    }
}
