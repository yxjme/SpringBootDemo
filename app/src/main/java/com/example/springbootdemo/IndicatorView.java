package com.example.springbootdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;
public class IndicatorView extends LinearLayout {

    private ViewPager viewPager ;
    private RadioGroup radioGroup ;
    int count ;

    public void setCount(int count) {
        this.count = count;
        init();
    }


    public void setViewPager(ViewPager viewPager) {
        this.viewPager = viewPager;
    }

    public IndicatorView(Context context) {
        this(context,null);
    }

    public IndicatorView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public IndicatorView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        radioGroup = new RadioGroup(context) ;
        radioGroup.setOrientation(HORIZONTAL);
        addView(radioGroup);
    }



    public void init(){
        if (viewPager!=null){
            for (int i = 0 ; i < count;i++){
                RadioButton radioButton=new RadioButton(getContext());
                radioButton.setFocusable(false);
                radioButton.setClickable(false);
                radioButton.setButtonDrawable(0);
                radioButton.setBackgroundResource(R.drawable.change_page_bg);
                ViewGroup.MarginLayoutParams params = new ViewGroup.MarginLayoutParams(30,30);
                params.leftMargin = 10 ;
                params.rightMargin = 10 ;
                radioGroup.addView(radioButton,params);
            }
            selectByPosition(0);
            viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                }

                @Override
                public void onPageSelected(int position) {
                    selectByPosition(position);
                }

                @Override
                public void onPageScrollStateChanged(int state) {

                }
            });
        }
    }




    /**
     * @param position
     */
    public void selectByPosition(int position){
        if (viewPager!=null&&viewPager.getChildCount()>0){
            if (radioGroup!=null&&radioGroup.getChildCount()>0){
                RadioButton radioButton= (RadioButton) radioGroup.getChildAt(position);
                radioButton.setChecked(true);
            }
        }
    }
}
