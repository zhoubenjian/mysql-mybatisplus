package com.benjamin.util;

import javax.swing.plaf.PanelUI;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateToolUtil {

    public final static String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    public final static String YYYY_MM_DD = "yyyy-MM-dd";
    public final static String HH_MM_SS = "HH:mm:ss";


    public final static String YEAR = "YEAR";

    public final static String MONTH = "MONTH";

    public final static String DAY = "DAY";

    public final static String HOUR = "HOUR";

    public final static String MINUTE = "MINUTE";

    public final static String SECOND = "SECOND";



    /**
     * 当前日期（Date）
     * @return
     */
    public static Date getDate() {
        return new Date();
    }

    /**
     * String => Date
     * @param dateStr
     * @return
     * @throws ParseException
     */
    public static Date DateStr2Date(String dateStr) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = simpleDateFormat.parse(dateStr);
        return date;
    }

    /**
     * 当前日期（String）
     * @param format
     * @return
     */
    public static String getDateStr(String format) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    /**
     * 昨日日期
     * @return
     */
    public static String getYesterday() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1);
        return new SimpleDateFormat(YYYY_MM_DD).format(calendar.getTime());
    }

    /**
     * 时间差
     * @param startDate
     * @param endDate
     * @param format
     * @return
     */
    public static long diffDate(Date startDate, Date endDate, String format) {
        long diff = endDate.getTime() - startDate.getTime();
        if (DAY.equals(format)) {
            diff = diff / (1000 * 60 * 60 * 24);
        } else if (HOUR.equals(format)) {
            diff = diff / (1000 * 60 * 60);
        } else if (MINUTE.equals(format)) {
            diff = diff / (1000 * 60);
        } else if (SECOND.equals(format)) {
            diff = diff / 1000;
        }
        return diff;
    }
}
