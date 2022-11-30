package com.benjamin.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateToolUtil {

    public final static String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    public final static String YYYY_MM_DD = "yyyy-MM-dd";
    public final static String HH_MM_SS = "HH:mm:ss";



    public static String getDateStr(String format) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }
}
