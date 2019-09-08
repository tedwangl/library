package com.wl.library.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneUtil {

    public static boolean isMobileNO(String mobiles){

        Pattern p = Pattern.compile("^1[345789]\\d{9}$");
//        Pattern p = Pattern.compile("^1\\d{10}$");

        Matcher m = p.matcher(mobiles);

        return m.matches();

    }

    public static String splitPhone(String phone){
        StringBuilder sb=new StringBuilder();
        for(int i=phone.length();i>0;i=i-4){
            if((i-4)>0){
                sb.insert(0, phone.substring(i-4, i));
                sb.insert(0, " ");
            }else{
                sb.insert(0, phone.substring(0, i));
            }

        }

        return sb.toString();
    }

}
