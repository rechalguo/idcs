package com.blc.apps.idcs.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

public class DateTimeUtil {

	//java.text.NumberFormat.getInstance(); 
//	private static final ThreadLocal<java.text.NumberFormat> NumberFormatter = new ThreadLocal<java.text.NumberFormat>();
	private static final ThreadLocal<SimpleDateFormat> DateFormatter = new ThreadLocal<SimpleDateFormat>();
	private static final Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
	
	/**
	 * 根据给定的格式格式化时间 
	 * @param value 
	 * @param format  默认格式 yyyy-MM-dd
	 * @return
	 */
	public static String formatDate(Object value,String format) {
		if(value==null) return "";
		if(format==null) format = "yyyy-MM-dd";
		SimpleDateFormat nf = ( SimpleDateFormat ) DateFormatter.get();
		if(nf==null) {
			nf = new SimpleDateFormat(format);
			DateFormatter.set(nf);
		} else {
			nf.applyPattern(format);
		}
		return nf.format(value);
	}
	
	/**
	 * 根据给定的格式格式化时间 
	 * @param value 
	 * @param format  默认格式 yyyy-MM-dd
	 * @return
	 */
	public static Date parseToDate(String value,String format) {
		if(value==null) return null;
		if(format==null) format = "yyyy-MM-dd";
		SimpleDateFormat nf = ( SimpleDateFormat ) DateFormatter.get();
		if(nf==null) {
			nf = new SimpleDateFormat(format);
			DateFormatter.set(nf);
		} else {
			nf.applyPattern(format);
		}
		try {
			return nf.parse(value);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static Date getDate(Date refer, int interval) {
		if(refer==null) return refer;
		Calendar c=Calendar.getInstance();
		c.setTime(refer);
		c.add(Calendar.DATE, interval);
		return c.getTime();
	}
	public static Date getCurrentDateTime() {
		return Calendar.getInstance().getTime();
	}
	public static Date getCurrentDate() {
		Calendar c=Calendar.getInstance();
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		return c.getTime();
	}
	public static Date trunc(Date refer, int grade) {
		if(refer==null) return refer;
		Calendar c=Calendar.getInstance();
		c.setTime(refer);
		switch(grade){
		case Calendar.YEAR:
			c.set(Calendar.MONTH, 1);
		case Calendar.MONTH:
			c.set(Calendar.DAY_OF_MONTH, 1);
		case Calendar.DAY_OF_MONTH:
			c.set(Calendar.HOUR_OF_DAY, 0);
		case Calendar.HOUR_OF_DAY:
			c.set(Calendar.MINUTE, 0);
		case Calendar.MINUTE:
			c.set(Calendar.SECOND, 0);
		case Calendar.SECOND:
			c.set(Calendar.MILLISECOND, 0);
		case Calendar.MILLISECOND:
		}
		return c.getTime();
	}
	 /**
     * 常规自动日期格式识别
     * @param str 时间字符串
     * @return 格式字符串
     * @author dc
     */
    public static String getDateFormat(String str) {
        boolean year = false;
        if(pattern.matcher(str.substring(0, 4)).matches()) {
            year = true;
        }
        StringBuilder sb = new StringBuilder();
        int index = 0;
        if(!year) {
            if(str.contains("月") || str.contains("-") || str.contains("/")) {
                if(Character.isDigit(str.charAt(0))) {
                    index = 1;
                }
            }else {
                index = 3;
            }
        }
        for (int i = 0; i < str.length(); i++) {
            char chr = str.charAt(i);
            if(Character.isDigit(chr)) {
                if(index==0) {
                    sb.append("y");
                }
                if(index==1) {
                    sb.append("M");
                }
                if(index==2) {
                    sb.append("d");
                }
                if(index==3) {
                    sb.append("H");
                }
                if(index==4) {
                    sb.append("m");
                }
                if(index==5) {
                    sb.append("s");
                }
                if(index==6) {
                    sb.append("S");
                }
            }else {
                if(i>0) {
                    char lastChar = str.charAt(i-1);
                    if(Character.isDigit(lastChar)) {
                        index++;
                    }
                }
                sb.append(chr);
            }
        }
        return sb.toString();
    }
}
