package com.wl.library.utils;

import android.widget.TextView;

public class UiUtil {

    public static void setText(String text, TextView textView) {
        if (textView != null) {
            if (StringUtil.isEmpty(text)) {
                textView.setText("");
            } else {
                textView.setText(text);
            }
        }
    }

}
