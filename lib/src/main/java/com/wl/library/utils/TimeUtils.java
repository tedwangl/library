package com.wl.library.utils;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
* @Package: com.thfund.common.utils
* @Title: TimeUtil.java
* @Description:  
* @date 2015年9月2日 上午9:18:34
* @version V1.0
**/
public class TimeUtils {


	public static final String YYYY_MM_DD = "yyyy-MM-dd";

	/*
	 * 获取当前时间
	 */
	public static String getTime() {
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		String sj_str = dateFormat.format(new Date());

		return sj_str;
	}

	/*
	 * 获取当前日期
	 */
	public static String getDate() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String sj_str = dateFormat.format(new Date());

		return sj_str;
	}

	/**
	 * 获取当前年
	 * @return
	 */
	public static int getCuYear() {
		Calendar c = Calendar.getInstance();
		return c.get(Calendar.YEAR);
	}

	/**
	 * 获取当前月
	 * @return
	 */
	public static int getCuMonth() {
		Calendar c = Calendar.getInstance();
		return c.get(Calendar.MONTH);
	}

	/**
	 * 获取当前月的第几天
	 * @return
	 */
	public static int getCuDay() {
		Calendar c = Calendar.getInstance();
		return c.get(Calendar.DAY_OF_MONTH);
	}

	/*
	 * 获取当前日期
	 */
	public static String getDate(String formatstr) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(formatstr);
		String sj_str = dateFormat.format(new Date());

		return sj_str;
	}

	/*
	 * 格式化时间
	 */
	public static String formatTime(String timeStr) {
		if (null == timeStr) {
			return null;
		}

		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		Date date = parseTime(timeStr);
		String sj_str = dateFormat.format(date);

		return sj_str;
	}

	/*
	 * 格式化日期
	 */
	public static String formatDate(String dateStr) {
		if (null == dateStr) {
			return null;
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = parseDate(dateStr);
		String sj_str = dateFormat.format(date);

		return sj_str;
	}
	
	/*
	 * 格式化日期
	 */
	public static String formatDate(String pattern, String dateStr) {
		if (null == dateStr) {
			return null;
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		Date date = parseDate(dateStr);
		String sj_str = dateFormat.format(date);

		return sj_str;
	}

	/*
	 * 解析日期字符串
	 */
	public static Date parseDate(String dateStr) {
		if (null == dateStr) {
			return null;
		}
		Date date = null;

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		try {
			date = dateFormat.parse(dateStr);
		} catch (ParseException e) {
		}

		return date;
	}
	
	/*
	 * 解析日期字符串
	 */
	public static Date parseDate(String pattern, String dateStr) {
		if (null == dateStr) {
			return null;
		}
		Date date = null;

		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);

		try {
			date = dateFormat.parse(dateStr);
		} catch (ParseException e) {
		}

		return date;
	}

	/*
	 * 解析时间字符串
	 */
	public static Date parseTime(String timeStr) {
		if (null == timeStr) {
			return null;
		}

		Date date = null;

		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");

		try {
			date = dateFormat.parse(timeStr);
		} catch (ParseException e) {
		}

		return date;
	}

	public static String getCountDown(String startTime){
		int timeLen= (int) ((System.currentTimeMillis()-parseTime(startTime).getTime())/1000);
		//30分钟内
		if(timeLen<30*60){
			int timeLeft=30*60-timeLen;
			int tenMinute=timeLeft/(10*60);
			int minute=(timeLeft-tenMinute*10*60)/60;
			int tenSecond=(timeLeft-(tenMinute*10+minute)*60)/10;
			int second=timeLeft%10;
			return tenMinute+""+minute+":"+tenSecond+second;
		}else {
			return null;
		}
	}




	/*
	 * 时间偏移运算
	 */
	public static String getTime(int skipDay) {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(new Date());

		cal.add(GregorianCalendar.DAY_OF_MONTH, skipDay);
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");

		return dateFormat.format(cal.getTime());
	}

	/*
	 * 某一时间的偏移运算
	 */
	public static String getTime(String timeStr, int skipDay) {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(parseTime(timeStr));

		cal.add(GregorianCalendar.DAY_OF_MONTH, skipDay);
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");

		return dateFormat.format(cal.getTime());
	}

	/*
	 * 日期偏移运算(增、减几日）
	 */
	public static String getDate(int skipDay) {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(new Date());

		cal.add(GregorianCalendar.DAY_OF_MONTH, skipDay);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		return dateFormat.format(cal.getTime());
	}

	/*
	 * 日期偏移运算(增、减几日）
	 */
	public static String getDate(String dateStr, int skipDay) {
		if (null == dateStr) {
			return null;
		}

		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(parseDate(dateStr));

		cal.add(GregorianCalendar.DAY_OF_MONTH, skipDay);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		return dateFormat.format(cal.getTime());
	}

	/*
	 * 时间偏移运算(增、减几日、几小时、几分）
	 */
	public static String getTime(int skipDay, int skipHour, int skipMinute) {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(new Date());

		cal.add(GregorianCalendar.DAY_OF_MONTH, skipDay);
		cal.add(GregorianCalendar.HOUR_OF_DAY, skipHour);
		cal.add(GregorianCalendar.MINUTE, skipMinute);

		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");

		return dateFormat.format(cal.getTime());
	}

	/*
	 * 某一时间的偏移运算(增、减几日、几小时、几分）
	 */
	public static String getTime(String timeStr, int skipDay, int skipHour,
                                 int skipMinute) {
		if (null == timeStr) {
			return null;
		}

		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(parseTime(timeStr));

		cal.add(GregorianCalendar.DAY_OF_MONTH, skipDay);
		cal.add(GregorianCalendar.HOUR_OF_DAY, skipHour);
		cal.add(GregorianCalendar.MINUTE, skipMinute);
		cal.get(GregorianCalendar.DAY_OF_WEEK_IN_MONTH);

		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");

		return dateFormat.format(cal.getTime());
	}

	/*
	 * 计算日期相差几天
	 */
	public static long subtraction(Date minuend, Date subtrahend) {

		long daterange = minuend.getTime() - subtrahend.getTime();
		long time = 1000 * 3600 * 24;

		return (daterange % time == 0) ? (daterange / time)
				: (daterange / time + 1);
	}

	public static boolean notAfter(String startDate, String endDate) {
		return startDate.compareTo(endDate) <= 0;
	}

	public static boolean before(String startDate, String endDate) {
		return startDate.compareTo(endDate) < 0;
	}

	public static boolean noMoreThanYear(String fromDate, String toDate) {
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat(
					"yyyy-MM-dd");
			Date fromD = dateFormat.parse(fromDate);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(fromD);
			calendar.add(Calendar.YEAR, 1);
			fromD = calendar.getTime();
			Date toD = dateFormat.parse(toDate);
			return toD.getTime() <= fromD.getTime();
		} catch (Exception e) {

		}
		return true;
	}

	public static long subtraction(String fromDate, String toDate, String format) {
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat(
					format);
			Date fromD = dateFormat.parse(fromDate);
			Date toD = dateFormat.parse(toDate);
			return subtraction(toD, fromD);
		} catch (Exception e) {

		}
		return 0;
	}

	public static long getM(Date date) {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		return cal.get(GregorianCalendar.DAY_OF_WEEK);
	}

	public static String getLastDate(String temp) { // 变量temp是看几天前的天数
		if (temp == null || temp.equals("")) {
			temp = "1";
		}
		int i = Integer.parseInt(temp);
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM);
		Calendar grc = Calendar.getInstance();
		grc.add(GregorianCalendar.DATE, -i);
		return dateFormat.format(grc.getTime());
	}

	// 获取上一年的日期（用来设置查询日期条件）
	public static String getLastYearDate() { // 上一年

		Calendar c = Calendar.getInstance();
		int y = c.get(Calendar.YEAR);
		String year = String.valueOf(y - 1);
		return year;
	}

	// 获取上个月的日期（用来设置查询日期条件）
	public static String getLastMonthDate() { // 上一月
		Calendar c = Calendar.getInstance();
		int y = c.get(Calendar.YEAR);
		int m = c.get(Calendar.MONTH) + 1;
		String month = null;
		String year = String.valueOf(y);
		if (m > 1) {
			if (m > 10) {
				month = String.valueOf(m - 1);
			} else {
				month = "0" + String.valueOf(m - 1);
			}
		} else {
			year = String.valueOf(y - 1);
			month = String.valueOf(12);
		}

		return year + "-" + month;
	}

	// 获取前一天的日期（用来设置查询日期条件）
	public static String getLastDayDate() { // 前一天
		Calendar c = Calendar.getInstance();
		int y = c.get(Calendar.YEAR);
		int m = c.get(Calendar.MONTH) + 1;
		int d = c.get(Calendar.DAY_OF_MONTH);
		int days = 0;
		if (m > 1) {
			days = getMonthsDays(m - 1, y);
		} else {
			days = 31;
		}
		String day = null;
		String month = null;
		String year = String.valueOf(y);
		if (d > 1) { // 大于1号
			day = String.valueOf(d - 1);
			if (m > 9) {
				month = String.valueOf(m);
			} else {
				month = "0" + String.valueOf(m);
			}
		} else if ((d < 2) && (m < 2)) { // 一月一号
			day = String.valueOf(31);
			month = String.valueOf(12);
			year = String.valueOf(y - 1);
		} else if ((d < 2) && (m > 2)) {
			day = String.valueOf(days);
			if (m > 10) {
				month = String.valueOf(m - 1);
			} else {
				month = "0" + String.valueOf(m - 1);
			}
		}

		return year + "-" + month + "-" + day;
	}

	// 判断是否闰年
	public static boolean isLeapYear(int year) {
		if ((((year % 4) == 0) && ((year % 100) != 0)) || ((year % 4) == 0)
				&& ((year % 400) == 0)) {
			return true;
		} else {
			return false;
		}
	}

	// 获取每个月的天数
	public static int getMonthsDays(int month, int year) {
		if ((isLeapYear(year) == true) && (month == 2)) {
			return 29;
		} else if ((isLeapYear(year) == false) && (month == 2)) {
			return 28;
		}

		if ((month == 1) || (month == 3) || (month == 5) || (month == 7)
				|| (month == 8) || (month == 10) || (month == 12)) {
			return 31;
		}
		return 30;
	}

	public static String getWeekDay() {
		DateFormatSymbols symboles = new DateFormatSymbols(Locale.getDefault());
		symboles.setShortWeekdays(new String[] { "", "7", "1", "2", "3", "4",
				"5", "6" });
		SimpleDateFormat date = new SimpleDateFormat("E", symboles);
		return date.format(new Date());
	}

	// 获取年
	public static int getYear() {
		Calendar c = Calendar.getInstance();
		return c.get(Calendar.YEAR);
	}

	// 获取月
	public static int getMonth() {
		Calendar c = Calendar.getInstance();
		return c.get(Calendar.MONTH);
	}

	// 获取日
	public static int getDay() {
		Calendar c = Calendar.getInstance();
		return c.get(Calendar.DAY_OF_MONTH);
	}

	public static String getLastMonthDay(int lastmonths) {
		int month = getMonth() + 1;
		if (month - lastmonths > 0) {
			return String.valueOf(getYear()) + "-"
					+ String.valueOf(month - lastmonths) + "-1";
		} else {
			return String.valueOf(getYear() - 1) + "-"
					+ String.valueOf(12 + month - lastmonths) + "-1";
		}
	}
	
	/**
	 * 判断时间是否重叠交叉
	 * @param fromDate1
	 * 		时间段一（开始时间）
	 * @param toDate1
	 * 		时间段一（结束时间）
	 * @param fromDate2
	 * 		时间段二（开始时间）
	 * @param toDate2
	 * 		时间段二（结束时间）
	 * @return
	 * 		时间存在交叉重叠则返回true，否则返回false.
	 */
	public static boolean isDateCross(Date fromDate1, Date toDate1, Date fromDate2, Date toDate2){
		if(subtraction(toDate1, fromDate1) >= 0 
				&& subtraction(fromDate1, toDate2) > 0){
			return false;
		}
		if(subtraction(toDate1, fromDate1) >= 0 
				&& subtraction(fromDate2, toDate1) > 0){
			return false;
		}
		return true;
	}

	public static  long getTimeFromNow(Date toDate){
		return toDate.getTime()- System.currentTimeMillis();
	}
	public static  int getTimeFromNow(String dateStr){
		try {
			return (int) (System.currentTimeMillis()-parseTime(dateStr).getTime());
		}catch (Exception e){

		}
		return Integer.MAX_VALUE;
	}


	public static void main(String[] args) {
//		System.out.print(TimeUtil.parseDate("yyyyMMdd", "20061001"));
		System.out.print(getCountDown("2017-12-26 15:01:24"));
	}

	public static int[] getDayHourMin(int time){
		int day=time/(24*60*60*1000);
		time=time-day*24*60*60*1000;
		int hour=time/(60*60*1000);
		time=time-hour*60*60*1000;
		int minute=time/(60*1000);
		int [] times=new int[3];
		times[0]=day;
		times[1]=hour;
		times[2]=minute;
		return  times;
	}

	/**
	 * 计算两个时间之间相差多少小时 多少分
	 * @param time1
	 * @param time2
	 * @param pattern
     * @return hourMin[0] 小时 hourMin[1] 分钟
     */
	public static int[] getCrossHourMin(String time1, String time2, String pattern){
		int[]hourMin=new int[2];
		Date date1=parseDate(pattern,time1);
		Date date2=parseDate(pattern,time2);

		if(null==date1||null==date2){
			hourMin[0]=0;
			hourMin[1]=1;
			return hourMin;
		}
		int crossMins= Math.abs((int)(date2.getTime()-date1.getTime()))/1000/60;
		hourMin[0]=crossMins/60;
		hourMin[1]=crossMins%60;
		return hourMin;
	}
	public static int[] getCrossHourMinSec(String time1, String time2, String pattern){
		int[]hourMin=new int[3];
		Date date1=parseDate(pattern,time1);
		Date date2=parseDate(pattern,time2);

		if(null==date1||null==date2){
			hourMin[0]=0;
			hourMin[1]=1;
			return hourMin;
		}
		int crossMins= Math.abs((int)(date2.getTime()-date1.getTime()))/1000/60;
		hourMin[0]=crossMins/60;
		hourMin[1]=crossMins%60;
		hourMin[2]= Math.abs((int)(date2.getTime()-date1.getTime()))/1000%60;
		return hourMin;
	}




	public static int[] getCuTime(){
        Calendar calendar= Calendar.getInstance();
        calendar.setTime(new Date());
        int [] times=new int[5];
        times[0]=calendar.get(Calendar.YEAR);
        times[1]=calendar.get(Calendar.MONTH)+1;
        times[2]=calendar.get(Calendar.DAY_OF_MONTH);
        times[3]=calendar.get(Calendar.HOUR_OF_DAY);
        times[4]=calendar.get(Calendar.MINUTE);

        return times;
    }

    public static String getDateFromTime(String dateTime) {
		if (StringUtils.isNull(dateTime) || dateTime.length() < 10) {
			return dateTime;
		}
		return dateTime.substring(0, 10);
	}
    public static String getDateMinuteFromTime(String dateTime) {
		if (StringUtils.isNull(dateTime) || dateTime.length() < 13) {
			return dateTime;
		}
		return dateTime.substring(0, 13);
	}

	private static String[] weekDays = new String[] {"未知","星期日","星期一","星期二","星期三","星期四","星期五","星期六","星期七"};
	public static String getWeekDay(String date) {
		try {
			Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.YEAR, Integer.valueOf(date.substring(0, 4)));
			calendar.set(Calendar.MONTH, Integer.valueOf(date.substring(5, 7)) - 1);
			calendar.set(Calendar.DAY_OF_MONTH, Integer.valueOf(date.substring(8, 10)));
			int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
			return weekDays[dayOfWeek];
		} catch (Exception e) {

		}
		return weekDays[0];
	}
	private static String[] weekDaysSimple = new String[] {"未知","日","一","二","三","四","五","六","七"};
	public static String getWeekDaySimple(String date) {
		try {
			Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.YEAR, Integer.valueOf(date.substring(0, 4)));
			calendar.set(Calendar.MONTH, Integer.valueOf(date.substring(5, 7)) - 1);
			calendar.set(Calendar.DAY_OF_MONTH, Integer.valueOf(date.substring(8, 10)));
			int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
			return weekDaysSimple[dayOfWeek];
		} catch (Exception e) {

		}
		return weekDaysSimple[0];
	}



    public static String friendlyTime(String dateTime){
		if(StringUtils.isNull(dateTime))
			return "";
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String cuDate = dateFormat.format(new Date());
		Calendar calendar= Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.DAY_OF_MONTH,1);
		String tomorrowDate=dateFormat.format(calendar.getTime());
		String date=dateTime.substring(0,10);
		if(cuDate.equals(date)){
			return "今天"+dateTime.substring(11,16);
		}else if(tomorrowDate.equals(date)){
			return "明天"+dateTime.substring(11,16);
		}else {
			return dateTime.substring(5,16);
		}

	}
}

