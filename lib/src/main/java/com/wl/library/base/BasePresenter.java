package com.wl.library.base;

import java.lang.ref.WeakReference;

/**
 * 作者：author wl
 * 时间：2019/5/12:15:44
 * 说明：
 */
public class BasePresenter<V extends BaseView> {

    protected V mView;

    private WeakReference<V> weakReferenceView;

    /**
     * 绑定view，一般在初始化中调用该方法
     *
     * @param view view
     */
    public void attachView(V view) {
        weakReferenceView = new WeakReference<>(view);
        this.mView = weakReferenceView.get();
    }

    /**
     * 解除绑定view，一般在onDestroy中调用
     */

    public void detachView() {
        weakReferenceView.clear();
        weakReferenceView = null;
        mView = null;
    }

    /**
     * View是否绑定
     *
     * @return
     */
    public boolean isViewAttached() {
        return mView != null;
    }


}
