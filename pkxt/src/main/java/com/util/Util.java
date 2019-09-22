package com.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Util {
    public static Date newDate(String s) throws ParseException {
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
                "yyyy-MM-dd");
        Date date = new Date();
        date = sdf.parse(s);
        return date;
    }

    public static Date newDate1(String s) throws ParseException {
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
                "yyyy-MM-dd HH:mm");
        Date date = new Date();
        date = sdf.parse(s);
        return date;
    }

    public static Date FormatFullDate(String s) throws ParseException {
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        date = sdf.parse(s);
        return date;

    }

    public static String splitDate(Date d) {
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
                "yyyy-MM-dd");
        return sdf.format(d);
    }

    public static String splitDate1(Date d) {
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
                "yyyy年MM月dd日");
        return sdf.format(d);
    }

    public static String getWeekStr(String sdate) throws ParseException {

        Date date = Util.newDate(sdate);
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        String str = new SimpleDateFormat("EEEE").format(c.getTime());
        if ("1".equals(str)) {
            str = "星期日";
        } else if ("2".equals(str)) {
            str = "星期一";
        } else if ("3".equals(str)) {
            str = "星期二";
        } else if ("4".equals(str)) {
            str = "星期三";
        } else if ("5".equals(str)) {
            str = "星期四";
        } else if ("6".equals(str)) {
            str = "星期五";
        } else if ("7".equals(str)) {
            str = "星期六";
        }
        return str;
    }

    /**
     * 将字符串截短，取前n个字符，英文算半个字符。
     *
     * @param orignalString 原字符串
     * @param length        长度
     * @param chopedString  超过部分的表示字符串
     * @return 截取的字符串
     */
    public static String chop(String orignalString, double length,
                              String chopedString) {
        if (orignalString == null || orignalString.length() == 0) {
            return orignalString;
        }
        orignalString = orignalString.replaceAll(" ", " ");
        if (orignalString.length() < length) {
            return orignalString;
        }
        StringBuffer buffer = new StringBuffer((int) length);
        length = length * 2;
        int count = 0;
        int stringLength = orignalString.length();
        int i = 0;
        for (; count < length && i < stringLength; i++) {
            char c = orignalString.charAt(i);
            if (c < '\u00ff') {
                count++;
            } else {
                count += 2;
            }
            buffer.append(c);
        }
        if (i < stringLength) {
            buffer.append(chopedString);
        }
        return buffer.toString();
    }

    public static long getPrimeKey() {
        GregorianCalendar calendar = new GregorianCalendar();
        return calendar.getTimeInMillis();
    }

    public static long stringToLong(String source) {
        return Long.parseLong(source);
    }
    /*
     * public static void main(String[] args){ for(int i=0;i<10;i++){
     * System.out.println(Util.getPrimeKey()); } }
     */
}
