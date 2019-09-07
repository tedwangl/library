package com.wl.library.views.youthbanner;


import com.wl.library.views.youthbanner.transformer.AccordionTransformer;
import com.wl.library.views.youthbanner.transformer.BackgroundToForegroundTransformer;
import com.wl.library.views.youthbanner.transformer.CubeInTransformer;
import com.wl.library.views.youthbanner.transformer.CubeOutTransformer;
import com.wl.library.views.youthbanner.transformer.DefaultTransformer;
import com.wl.library.views.youthbanner.transformer.DepthPageTransformer;
import com.wl.library.views.youthbanner.transformer.FlipHorizontalTransformer;
import com.wl.library.views.youthbanner.transformer.FlipVerticalTransformer;
import com.wl.library.views.youthbanner.transformer.ForegroundToBackgroundTransformer;
import com.wl.library.views.youthbanner.transformer.RotateDownTransformer;
import com.wl.library.views.youthbanner.transformer.RotateUpTransformer;
import com.wl.library.views.youthbanner.transformer.ScaleInOutTransformer;
import com.wl.library.views.youthbanner.transformer.StackTransformer;
import com.wl.library.views.youthbanner.transformer.TabletTransformer;
import com.wl.library.views.youthbanner.transformer.ZoomInTransformer;
import com.wl.library.views.youthbanner.transformer.ZoomOutSlideTransformer;
import com.wl.library.views.youthbanner.transformer.ZoomOutTranformer;

import androidx.viewpager.widget.ViewPager;

public class Transformer {
    public static Class<? extends ViewPager.PageTransformer> Default = DefaultTransformer.class;
    public static Class<? extends ViewPager.PageTransformer> Accordion = AccordionTransformer.class;
    public static Class<? extends ViewPager.PageTransformer> BackgroundToForeground = BackgroundToForegroundTransformer.class;
    public static Class<? extends ViewPager.PageTransformer> ForegroundToBackground = ForegroundToBackgroundTransformer.class;
    public static Class<? extends ViewPager.PageTransformer> CubeIn = CubeInTransformer.class;
    public static Class<? extends ViewPager.PageTransformer> CubeOut = CubeOutTransformer.class;
    public static Class<? extends ViewPager.PageTransformer> DepthPage = DepthPageTransformer.class;
    public static Class<? extends ViewPager.PageTransformer> FlipHorizontal = FlipHorizontalTransformer.class;
    public static Class<? extends ViewPager.PageTransformer> FlipVertical = FlipVerticalTransformer.class;
    public static Class<? extends ViewPager.PageTransformer> RotateDown = RotateDownTransformer.class;
    public static Class<? extends ViewPager.PageTransformer> RotateUp = RotateUpTransformer.class;
    public static Class<? extends ViewPager.PageTransformer> ScaleInOut = ScaleInOutTransformer.class;
    public static Class<? extends ViewPager.PageTransformer> Stack = StackTransformer.class;
    public static Class<? extends ViewPager.PageTransformer> Tablet = TabletTransformer.class;
    public static Class<? extends ViewPager.PageTransformer> ZoomIn = ZoomInTransformer.class;
    public static Class<? extends ViewPager.PageTransformer> ZoomOut = ZoomOutTranformer.class;
    public static Class<? extends ViewPager.PageTransformer> ZoomOutSlide = ZoomOutSlideTransformer.class;
}
