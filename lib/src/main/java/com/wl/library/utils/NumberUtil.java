package com.wl.library.utils;


import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class NumberUtil {

    /**
     * 使用默认方式显示货币：
     * 例如:￥12,345.46 默认保留2位小数，四舍五入
     *
     * @param d double
     * @return String
     */
    public static String formatCurrency(double d) {
        String s = "";
        try {
            DecimalFormat nf = (DecimalFormat) NumberFormat.getCurrencyInstance(Locale.CHINA);
            s = nf.format(d);
        } catch (Exception e) {
            e.printStackTrace();
            return "" + d;
        }
        return s;
    }

    /**
     * 去掉无效小数点 ".00"
     */
    public static String formatMoney(double d) {
        String tmp = formatCurrency(d);

        if (tmp.endsWith(".00")) {
            return tmp.substring(0, tmp.length() - 3);
        } else {
            return tmp;
        }
    }

    /**
     * |普通数字字符串转换带，的字符串
     * @param numStr
     * @return
     */
    public static String formatNum(String numStr) {
        if (numStr == null || numStr.length() == 0)
            return "";
        StringBuilder sb = new StringBuilder();
        if (numStr.contains(".")) {
            sb.append(formatInteger(numStr.substring(0, numStr.indexOf("."))));
            sb.append(numStr.substring(numStr.indexOf(".")));
        } else {
            return formatInteger(numStr);
        }

        return sb.toString();

    }

    /**
     * 整数字符串转换带，的字符串
     * @param intStr
     * @return
     */
    public static String formatInteger(String intStr) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        StringBuilder sbNum = new StringBuilder(intStr);
        sbNum.reverse();
        while (count < sbNum.length()) {
            if (count != 0 && count % 3 == 0)
                sb.append(",");
            sb.append(sbNum.charAt(count));
            count++;

        }

        sb.reverse();
        return sb.toString();
    }
}
