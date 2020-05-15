package com.example.springbootdemo;

import android.content.Context;

import androidx.recyclerview.widget.GridLayoutManager;

public class MyGridLayoutManager extends GridLayoutManager {

    private boolean mCanVerticalScroll = true;

    public MyGridLayoutManager(Context context, int spanCount) {
        super(context, spanCount);
    }

    @Override
    public boolean canScrollVertically() {
        if (!mCanVerticalScroll){
            return false;
        }else {
            return super.canScrollVertically();
        }
    }

    public void setmCanVerticalScroll(boolean b){
        mCanVerticalScroll = b;
    }
}
