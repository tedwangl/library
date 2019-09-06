package com.wl.library.utils;


import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

/**
 * @author peishuaihui
 * @data 2018/10/20  19:43
 */
public class ViewUtils {


    public static  <T extends View> T findView(View parent, int id) {
        return parent.findViewById(id);
    }

    public static TextView findTextView(View parent, int id) {
        return findView(parent, id);
    }
    public static ImageView findImageView(View parent, int id) {
        return findView(parent, id);
    }
    public static ToggleButton findToggleButton(View parent, int id) {
        return findView(parent, id);
    }

    public static boolean isNullText(TextView textView) {
        return StringUtils.isNull(textView.getText().toString());
    }

}
