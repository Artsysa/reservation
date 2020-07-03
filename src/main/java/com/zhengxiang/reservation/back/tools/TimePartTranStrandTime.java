package com.zhengxiang.reservation.back.tools;/*

 * @return: $return$

 * @Author: $user$

 * @Date: $date$ $time$

 */

/**
 * 将time1转换为8~9这样
 */
public  class  TimePartTranStrandTime {

    public final static String Tran(String time){
        if(time.equals("time1")){
            return "8:00~8:30";
        }else if(time.equals("time2")){
            return "8:30~9:00";
        }else if(time.equals("time3")){
            return "9:00~9:30";
        }else if(time.equals("time4")){
            return "9:30~10:00";
        }else if(time.equals("time5")){
            return "10:00~10:30";
        }else if(time.equals("time6")){
            return "10:30~11:00";
        }else if(time.equals("time7")){
            return "11:00~11:30";
        }else if(time.equals("time8")){
            return "11:30~12:00";
        }else if(time.equals("time9")){
            return "12:00~12:30";
        }else if(time.equals("time10")){
            return "12:30~13:00";
        }else if(time.equals("time11")){
            return "13:00~13:30";
        }else if(time.equals("time12")){
            return "13:30~14:00";
        }else if(time.equals("time13")){
            return "14:00~14:30";
        }else if(time.equals("time14")){
            return "14:30~15:00";
        }else if(time.equals("time15")){
            return "15:00~15:30";
        }else if(time.equals("time16")){
            return "15:30~16:00";
        }else if(time.equals("time17")){
            return "16:00~16:30";
        }else if(time.equals("time18")){
            return "16:30~17:00";
        }else if(time.equals("time19")){
            return "17:00~17:30";
        }else if(time.equals("time20")){
            return "17:30~18:00";
        }
        return "null";
    }
}
