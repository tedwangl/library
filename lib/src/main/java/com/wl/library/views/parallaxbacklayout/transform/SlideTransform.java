package com.wl.library.views.parallaxbacklayout.transform;

import android.graphics.Canvas;
import android.view.View;

import com.wl.library.views.parallaxbacklayout.widget.ParallaxBackLayout;

import static com.wl.library.views.parallaxbacklayout.ViewDragHelper.EDGE_LEFT;
import static com.wl.library.views.parallaxbacklayout.ViewDragHelper.EDGE_TOP;
import static com.wl.library.views.parallaxbacklayout.ViewDragHelper.EDGE_RIGHT;
import static com.wl.library.views.parallaxbacklayout.ViewDragHelper.EDGE_BOTTOM;

/**
 * ParallaxBackLayout
 *
 * @author An Zewei (anzewei88[at]gmail[dot]com)
 * @since ${VERSION}
 */

public class SlideTransform implements ITransform {
    @Override
    public void transform(Canvas canvas, ParallaxBackLayout parallaxBackLayout, View child) {
        int mEdgeFlag = parallaxBackLayout.getEdgeFlag();
        int width = parallaxBackLayout.getWidth();
        int height = parallaxBackLayout.getHeight();
        int leftBar = parallaxBackLayout.getSystemLeft();
        int topBar = parallaxBackLayout.getSystemTop();
        if (mEdgeFlag == EDGE_LEFT) {
            int left = (child.getLeft() - child.getWidth()) - leftBar;
            canvas.translate(left, 0);
        } else if (mEdgeFlag == EDGE_TOP) {
            int top = (child.getTop() - child.getHeight()) + topBar;
            canvas.translate(0, top);
        } else if (mEdgeFlag == EDGE_RIGHT) {
            int left = child.getRight() - leftBar;
            canvas.translate(left, 0);
            canvas.clipRect(leftBar, 0, width, height);
        } else if (mEdgeFlag == EDGE_BOTTOM) {
            int top = child.getBottom() - topBar;
            canvas.translate(0, top);
            canvas.clipRect(0, topBar, child.getRight(), height);
        }
    }
}
