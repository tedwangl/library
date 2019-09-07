package com.wl.library.utils;


public class NumberUtil {

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
