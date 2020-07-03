package com.zhengxiang.reservation;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan(value = {"com.zhengxiang.reservation.scholar.mapper",
        "com.zhengxiang.reservation.coach.mapper",
        "com.zhengxiang.reservation.timetask.mapper",
        "com.zhengxiang.reservation.back.mapper"})
@EnableCaching
@EnableScheduling//定时任务
public class ReservationApplication {
    public static void main(String[] args) {
        SpringApplication.run(ReservationApplication.class, args);
    }

}
