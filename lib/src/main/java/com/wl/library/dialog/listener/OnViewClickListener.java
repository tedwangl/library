package com.wl.library.dialog.listener;

import android.view.View;

import com.wl.library.dialog.TDialog;
import com.wl.library.dialog.base.BindViewHolder;

public interface OnViewClickListener {
    void onViewClick(BindViewHolder viewHolder, View view, TDialog tDialog);
}
