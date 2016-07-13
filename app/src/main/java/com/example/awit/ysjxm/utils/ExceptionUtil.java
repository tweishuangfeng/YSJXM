package com.example.awit.ysjxm.utils;

import com.example.awit.ysjxm.YSJXMTApplication;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Created by Lenvovo on 2016/6/20.
 *
 * 异常统一处理类
 */
public class ExceptionUtil {

    public static void handleException(Exception e)
    {
        if (YSJXMTApplication.isRelease)
        {
            //把异常信息变成字符串
            StringWriter stringWriter=new StringWriter();
            PrintWriter printWriter=new PrintWriter(stringWriter);
            e.printStackTrace(printWriter);
            String string=stringWriter.toString();


            //发邮件，发到服务器
            LogUtil.i("", string);
        }else
        {
            StringWriter stringWriter=new StringWriter();
            PrintWriter printWriter=new PrintWriter(stringWriter);
            e.printStackTrace(printWriter);
            String string=stringWriter.toString();
            LogUtil.i("异常信息必须看", "  ");
            LogUtil.i("异常信息必须看", "  ");
            LogUtil.i("异常信息必须看", string);
            e.printStackTrace();
        }
    }


}
