package com.wl.library.utils;

import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;

public class SpanUtil {

    public static CharSequence textColorSpan(String content, int start, int end, int color){
        ForegroundColorSpan span=new ForegroundColorSpan(color);
        SpannableString spannableString = new SpannableString(content);
        spannableString.setSpan(span,start,end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return spannableString;
    }

}
