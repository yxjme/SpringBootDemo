package com.example.springbootdemo;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

public class HomeIndexTabView extends LinearLayout {


    ViewPager mViewPager ;
    IndicatorView mIndicatorView ;

    public HomeIndexTabView(Context context) {
        this(context,null);
    }


    public HomeIndexTabView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }


    public HomeIndexTabView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        View view = LayoutInflater.from(context).inflate(R.layout.home_index_tab_layout,this,false) ;
        mViewPager = view.findViewById(R.id.mViewPager);
        mIndicatorView = view.findViewById(R.id.mIndicatorView);
        addView(view);
    }


    /**
     * @param <T>
     * @param list
     */
    public void init(List<List<String>> list){
        List<View> views = new ArrayList<>() ;
        for (List<String> t: list){
            CommonImgAndTextTabView commonImgAndTextTabView = new CommonImgAndTextTabView(getContext());
            commonImgAndTextTabView.setAdapter(t,5);
            views.add(commonImgAndTextTabView) ;
        }
        mViewPager.setAdapter(new ViewPagerAdapter(views));
        mIndicatorView.setViewPager(mViewPager);
        mIndicatorView.setCount(views.size());
    }


    public class ViewPagerAdapter extends PagerAdapter{

        List<View> list ;
        public ViewPagerAdapter(  List<View> list){
            this.list = list ;
        }

        @Override
        public int getCount() {
            return list==null?0:list.size();
        }
        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(final ViewGroup container, final int position) {
            container.addView(list.get(position));
            return list.get(position) ;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            Log.i("PagerAdapter" , "method destroyItem be calling");
            container.removeView((View)object);
        }
    }
}
