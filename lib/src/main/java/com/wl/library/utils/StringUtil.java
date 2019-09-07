package com.wl.library.utils;

import android.widget.TextView;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;


public class StringUtil {
    /**
     * 去掉字符串的空格
     *
     * @param str 字符串
     * @return 去掉空格都的字符串
     */
    public static String spaceTrim(String str) {
        if (null == str) {
            return null;
        }
        return str.replaceAll("^[\\s]+", "").trim();
    }

    /**
     * 判断字符串是否为空
     *
     * @param str        字符串
     * @param isDelSpace 是否去掉空格
     * @return 是true, 否false
     */
    public static boolean isEmpty(String str, boolean isDelSpace) {
        if (null == str) {
            return true;
        }
        if (isDelSpace) {
            str = str.trim();
        }
        if (str.equals("")) {
            return true;
        }
        return false;
    }

    /**
     * 判断字符串是否为空, 默认去掉空格
     *
     * @param str 字符串
     * @return 是true, 否false
     */
    public static boolean isEmpty(String str) {
        return isEmpty(str, true);
    }

    public static boolean isNotEmpty(String str) {
        return !isEmpty(str, true);
    }


    /**
     * 过滤掉字符串中重复的字符
     *
     * @param str
     * @param separator 分割符
     * @return
     */
    public static String filterDuplicate(String str, String separator) {
        if (isEmpty(str))
            return "";
        String[] temp_str = str.split(separator);
        Set<String> set = new HashSet<String>();
        for (String string : temp_str) {
            if (!isEmpty(string))
                set.add(string);
        }

        Iterator<String> it = set.iterator();
        String new_str = "";
        while (it.hasNext()) {
            new_str += it.next() + separator;
        }

        return new_str.substring(0, new_str.length() - 1);
    }

    /***
     * 过滤掉重复字符串 用于IN方法，给字符串添加''
     *
     * @return
     */
    public static String filterDuplicateForIN(String str, String separator) {

        if (isEmpty(str))
            return "";

        String[] temp_str = str.split(separator);
        Set<String> set = new HashSet<String>();
        for (String string : temp_str) {
            if (!isEmpty(string))
                set.add(string);
        }

        Iterator<String> it = set.iterator();
        String new_str = "";
        while (it.hasNext()) {
            new_str += ("'" + it.next() + "'") + separator;
        }

        return new_str.substring(0, new_str.length() - 1);
    }

    /**
     * 得到String的MD5码
     *
     * @param srcString 将要加密码的字符串
     * @return String 加密后的字符串
     */
    public static String getMD5(String srcString) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(srcString.getBytes("UTF8"));
            byte s[] = md.digest();
            String result = "";
            for (int i = 0; i < s.length; i++) {
                result += Integer.toHexString((0x000000FF & s[i]) | 0xFFFFFF00).substring(6);
            }
            return result;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 按指定的编码把字符串转换成byte数组
     *
     * @param str
     * @param charset
     * @return Byte封装类
     * @throws UnsupportedEncodingException
     */
    public static Byte[] decodeConvert(String str, String charset) throws UnsupportedEncodingException {
        byte[] b = str.getBytes(charset);

        Byte[] temp = new Byte[b.length];

        for (int i = 0; i < b.length; i++) {
            temp[i] = Byte.valueOf(b[i]);
        }

        return temp;
    }

    /**
     * 把Byte封装类转换成byte(基础数据类型)
     *
     * @param b
     * @return
     */
    public static byte[] convertByteTo(Byte[] b) {
        byte[] temp = new byte[b.length];
        for (int i = 0; i < b.length; i++) {
            temp[i] = b[i].byteValue();
        }
        return temp;
    }

    /**
     * 对byte 数组按一定的编码转换成字符串
     *
     * @param b
     * @param charset
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String encodeString(byte[] b, String charset) throws UnsupportedEncodingException {
        return new String(b, charset);
    }

    public static String subFirstLastString(String str) {
        String contetString = str.substring(1, str.length() - 1);
        return contetString;
    }

    /**
     * 默认分隔符 ,
     *
     * @param list
     * @return
     */
    public static String stringlist2String(List<String> list) {
        StringBuilder sBuilder = new StringBuilder();
        for (Object object : list) {
            sBuilder.append(object.toString() + ",");
        }
        sBuilder.deleteCharAt(sBuilder.length() - 1);

        return sBuilder.toString();
    }

    /**
     * 默认分隔符 ,
     *
     * @param source
     * @return
     */
    public static List<String> string2Stringlist(String source) {
        List<String> list = new ArrayList<>();
        String[] split = source.split(",");
        for (String spice : split) {
            list.add(spice);
        }
        return list;

    }

    public static boolean stringEqlInt(String source, int dest) {
        return ("" + dest).equals(source);
    }

    public static boolean stringGTInt(String source, int dest) {
        if (source == null)
            return false;
        int sourceInt = Integer.valueOf(source);
        return sourceInt > dest;
    }

    public static int sum(String source1, String source2) {
        int sum = 0;
        if (source1 != null) {
            sum = sum + Integer.valueOf(source1);
        }
        if (source2 != null) {
            sum = sum + Integer.valueOf(source2);
        }
        return sum;
    }

    public static String fenToYuan(String cents) {
        if (cents == null) {
            return "0";
        } else if (cents.length() > 2) {
            return "¥" + cents.substring(0, cents.length() - 2) + "." + cents.substring(cents.length() - 2, cents.length());
        } else {
            return "¥" + "0." + String.format("%02d", Integer.valueOf(cents));
        }
    }

    public static String fenToYuanWithoutSign(String cents) {
        if (cents == null) {
            return "0";
        } else if (cents.length() > 2) {
            return cents.substring(0, cents.length() - 2) + "." + cents.substring(cents.length() - 2, cents.length());
        } else {
            return "0." + String.format("%02d", Integer.valueOf(cents));
        }
    }

    public static boolean isNull(String str) {
        return (str == null || str.length() == 0 || str.equalsIgnoreCase("null")) ? true : false;
    }

    public static boolean isNull(TextView tv) {
        return isNull(tv.getText().toString());
    }

    public static boolean hasNull(String... strings) {
        boolean isNull = false;
        for (String str : strings) {
            isNull = isNull | isNull(str);
        }
        return isNull;
    }

    public static String randomNums(int length) {
        Random random = new Random();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < length; i++) {
            stringBuffer.append(random.nextInt(9) + 1);
        }
        return stringBuffer.toString();
    }

    public static String formatNumber(int number) {
        DecimalFormat df = (DecimalFormat) NumberFormat.getInstance();
        df.applyPattern("###,###");
        if (number < 100000) {
            return df.format(number);
        } else {
            df.applyPattern("###,###.#");
            float num = number * 1.0f / 10000;
            return df.format(num) + "万";
        }
    }

    public static String formatNumber2(int number) {
        DecimalFormat df = (DecimalFormat) NumberFormat.getInstance();
        df.applyPattern("######");
        if (number < 10000) {
            return df.format(number);
        } else {
            df.applyPattern("###,###.#");
            float num = number * 1.0f / 10000;
            return df.format(num) + "万";
        }
    }

    public static String formatPrice(double price) {
        DecimalFormat df = (DecimalFormat) NumberFormat.getInstance();
        df.applyPattern("###,##0.00");
        return df.format(price) + "元";
    }

    public static String formatInteger(int number) {
        DecimalFormat df = (DecimalFormat) NumberFormat.getInstance();
        df.applyPattern("###,###");
        return df.format(number);
    }

    public static String formatInteger2(int number) {
        DecimalFormat df = (DecimalFormat) NumberFormat.getInstance();
        df.applyPattern("###,###");
        if (number < 10000) {
            return df.format(number);
        } else {
            df.applyPattern("###,###.#");
            float num = number * 1.0f / 10000;
            return df.format(num) + "万";
        }
    }


    public static String doEmojiCharInterceptor(String s) {
        if (s == null || s.length() == 0)
            return s;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if (!isEmojiCharacter(new Integer(s.charAt(i)))) {
                sb.append(s.charAt(i));
            }
        }
        String ss = sb.toString();
        return ss;
    }

    public static boolean isEmojiCharacter(int codePoint) {
        return !((codePoint == 0x0) || (codePoint == 0x9) || (codePoint == 0xA)
                || (codePoint == 0xD)
                || ((codePoint >= 0x20) && (codePoint <= 0xD7FF))
                || ((codePoint >= 0xE000) && (codePoint <= 0xFFFD)) || ((codePoint >= 0x10000) && (codePoint <= 0x10FFFF)));
    }


    public static String getMMddFromStr(String time) {

        Date date = TimeUtil.parseTime(time);
        if (date == null) {
            return "未知";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        long time1 = calendar.getTimeInMillis();

        calendar.add(Calendar.DAY_OF_MONTH, 1);
        long time2 = calendar.getTimeInMillis();
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        long time3 = calendar.getTimeInMillis();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        if (date.getTime() < time1) {
            simpleDateFormat.applyPattern("MM月dd日");
            return simpleDateFormat.format(date);
        } else if (time1 <= date.getTime() && date.getTime() < time2) {
            simpleDateFormat.applyPattern("HH:mm");

            return simpleDateFormat.format(date);
        } else if (time2 <= date.getTime() && date.getTime() < time3) {
            simpleDateFormat.applyPattern("HH:mm");

            return "明天 " + simpleDateFormat.format(date);
        } else {
            simpleDateFormat.applyPattern("MM月dd日");
            return simpleDateFormat.format(date);
        }

    }

    public static int countOfChar(String str, char ch) {
        int count = 0;
        if (isNull(str))
            return count;
        for (int i = 0; i < str.length(); i++)
            if (str.charAt(i) == ch)
                count++;
        return count;
    }

    public static String resetToMoney(String str) {
        if (isNull(str))
            return "";
        if ("0".equals(str))
            return str;
        int j = -1;
        int k = -1;
        StringBuilder sb = new StringBuilder(str);
        while (sb.length() > 0 && sb.charAt(0) == '0')
            sb.deleteCharAt(0);
        while ((j = sb.indexOf(".")) > 0 && sb.length() > (j + 1)) {
            if ((k = sb.indexOf(".", j + 1)) > 0) {
                sb.deleteCharAt(k);
            } else {
                break;
            }
        }
        if (sb.length() >= 1)
            if (sb.charAt(0) == '.')
                sb.insert(0, '0');
        while ((j = sb.indexOf(".")) > 0 && (sb.length() - j - 1) > 2)
            sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public static String resetToNum(String str) {
        if (isNull(str))
            return "";
        if ("0".equals(str))
            return str;
        int j = -1;
        int k = -1;
        StringBuilder sb = new StringBuilder(str);
        while ((j = sb.indexOf(".")) >= 0) {
            sb.deleteCharAt(j);
        }
        while (sb.length() > 1 && sb.charAt(0) == '0')
            sb.deleteCharAt(0);
        if (sb.length() >= 1)
            if (sb.charAt(0) == '.')
                sb.insert(0, '0');
        return sb.toString();
    }


    public static String resetToRate(String str, String lastEt) {
        if (isNull(str))
            return "";
        if ("0".equals(str))
            return str;
        int j = -1;
        int k = -1;
        StringBuilder sb = new StringBuilder(str);
        while (sb.length() > 0 && sb.charAt(0) == '0')
            sb.deleteCharAt(0);
        while ((j = sb.indexOf(".")) > 0 && sb.length() > (j + 1)) {
            if ((k = sb.indexOf(".", j + 1)) > 0) {
                sb.deleteCharAt(k);
            } else {
                break;
            }
        }
        if (sb.length() >= 1)
            if (sb.charAt(0) == '.')
                sb.insert(0, '0');
        while ((j = sb.indexOf(".")) > 0 && (sb.length() - j - 1) > 8)
            sb.deleteCharAt(sb.length() - 1);
        String s =  sb.toString();

        if (!s.contains(".") && (lastEt != null && (!lastEt.contains(".") && lastEt.length() <= s.length()))) {
            if (s.length() > 2) {

            } else if (s.length() == 2) {
                int numPercent = Integer.valueOf(s.charAt(0) + "");
                if (numPercent < 3) {
                    sb = new StringBuilder(s);
                    sb.insert(2, ".");
                    s = sb.toString();
                }
            } else if (s.length() == 1) {
                int numPercent = Integer.valueOf(s);
                if (numPercent >= 3) {
                    s += ".";
                }
            }
        }

        return s;
    }

}
