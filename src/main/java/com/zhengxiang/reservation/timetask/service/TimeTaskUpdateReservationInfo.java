package com.zhengxiang.reservation.timetask.service;

import com.zhengxiang.reservation.commonPOJO.coachORMreservationTable;
import com.zhengxiang.reservation.timetask.mapper.TimeTaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class TimeTaskUpdateReservationInfo {

    @Autowired
    TimeTaskMapper ttm;
    @Autowired
    SimpleDateFormat sdf;

    /*
    获取所有教练自己对应的具体预约信息表名
     */

    public CopyOnWriteArrayList<coachORMreservationTable> getReservationdetailTableName(){
        return ttm.getcaochormreservationdetail();
    }

    /*
     获取所有教练对应自己的预约情况表
     */

    public CopyOnWriteArrayList<coachORMreservationTable> getReservationcountTableName(){
        return ttm.getcaochormreservationcount();
    }
    /*
    更新预约表
     */
    public int updateTableMassage(String data,String tablename){
        return ttm.updateDayReservation(data, tablename);
    }

//    @Scheduled(fixedRate = 3000)
//    public void scheduled(){
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        System.out.println("pass 3 "+sdf.format(new Date()));
//    }
    /*
    每天12点定时在每个教练预约信息表中定时插入当天预约具体信息
    同时备份数据库信息
    @Param("day")String data,@Param("table")String table
     */

    @CacheEvict(allEntries = true,value = {"coachinfo","reservationcount",
            "reservationdetial","reservationinfo","scholarinfo","reservationinfos"
    ,"reservationinfopart","coachinfoall","admininfo",
            "scholarinfoall","scholarinfobriefall","scholarinfoallbyid"
    ,"reservationinfoall"})
    @Scheduled(cron = "0 0 0 * * *")
    public void updateReservationCount(){
        CopyOnWriteArrayList<coachORMreservationTable> tableName =getReservationcountTableName();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar date = Calendar.getInstance();
        date.add(Calendar.DAY_OF_MONTH,1);
        for (coachORMreservationTable table:tableName
             ) {
            System.out.println("insert to" +table.getTablename());
            ttm.updateDayReservation(sdf.format(date.getTime()),table.getTablename());
        }


    }


    /**备份数据库
     * mysqldump  -uroot -pGet02178 -h 49.235.43.59  reservations > /mysql/sqlreservations/
     * "touch /mysql/sqlreservations/"+name+";
     * @param cmd
     */
    public void cmdLinux(){
        String name= sdf.format(new Date()) + ".sql";
     String   cmd="mysqldump  -uroot -pGet02178 -h 49.235.43.59  reservations > /mysql/sqlreservations/1.sql";
     Runtime runtime = Runtime.getRuntime();
        PrintWriter printWriter = null;
        BufferedReader bufferedReader = null;
        if(runtime!=null) {
            try {
            //    cmd = cmd +name;
                Process exec = runtime.exec(cmd);

                printWriter = new PrintWriter(new OutputStreamWriter(new FileOutputStream(cmd), "utf8"));
                InputStreamReader inputStreamReader = new InputStreamReader(exec.getInputStream(), "utf8");
                bufferedReader = new BufferedReader(inputStreamReader);
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    printWriter.println(line);
                }
                printWriter.flush();
                //0 表示线程正常终止。
                if (exec.waitFor() == 0) {
                    System.out.println("异常！！！！！=======##############》》》》########");
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    if (printWriter != null) {
                        printWriter.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }}

}
