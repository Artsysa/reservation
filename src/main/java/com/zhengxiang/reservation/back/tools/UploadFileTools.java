package com.zhengxiang.reservation.back.tools;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

/*
上传文件类
 */
public class UploadFileTools {

    /*
    path：上传文件路径
     */

    public static String uploadfile(HttpServletRequest req,  String name)throws IOException {

        //获得解析器
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver(req.getSession().getServletContext());
       //检查form是否有entype
        String path=null;
        if(commonsMultipartResolver.isMultipart(req)){
            MultipartHttpServletRequest mreq= (MultipartHttpServletRequest) req;
            Iterator<String> fileNames = mreq.getFileNames();
            while(fileNames.hasNext()){
                MultipartFile file = mreq.getFile(fileNames.next().toString());

                if(file!=null){
                    String originalFilename = file.getOriginalFilename();
                    originalFilename=originalFilename.substring(originalFilename.indexOf("."));
                  //  String substring = file.getName().substring(file.getName().indexOf("."));
                   // String oldName = cfile.getOriginalFilename();
                             // 截取后缀名
                //  String suffix = oldName.substring(oldName.lastIndexOf("."));
                    path = req.getSession().getServletContext().getRealPath("/picture");
                    System.out.println(path);
                    path=path+"/"+name+originalFilename;
                    new File(path).mkdirs();
                    file.transferTo(new File(path));
                    path="/picture/"+name+originalFilename;
                }
            }
        }
        return path;
    }
}
