package com.example.springbootdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ImageView im_bg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        im_bg = findViewById(R.id.im_bg);
        submergedBar(this);
        initView();
    }

    private void initView() {
        RecyclerView mRecyclerView = findViewById(R.id.mRecyclerView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);

        //SnapHelper
        /*选中项总是居中*/
//        SnapHelper snapHelper = new LinearSnapHelper();
        /*PagerSnapHelper实现 viewPager的效果*/
        PagerSnapHelper snapHelper = new PagerSnapHelper(){
            @Override
            public int findTargetSnapPosition(RecyclerView.LayoutManager layoutManager, int velocityX, int velocityY) {
                int  p = super.findTargetSnapPosition(layoutManager, velocityX, velocityY);
                Glide.with(MainActivity.this)
                        .load(list.get(p))
                        .asBitmap()
                        .into(new SimpleTarget<Bitmap>() {
                            @Override
                            public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                                im_bg.setImageBitmap(StackBlurUtil.doBlur(resource,20,true));
                            }
                        });
                return p;
            }
        };
        snapHelper.attachToRecyclerView(mRecyclerView);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        list.addAll(getList0());
        mRecyclerView.setAdapter(new TabRecyclerViewAdapter());


        Glide.with(MainActivity.this)
                .load(list.get(0))
                .asBitmap()
                .into(new SimpleTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                        im_bg.setImageBitmap(StackBlurUtil.doBlur(resource,20,true));
                    }
                });
    }

    /**
     * 沉嵌式 状态栏
     *
     * @param context
     */
    public static void submergedBar(Activity context){
        if (Build.VERSION.SDK_INT >=19 && Build.VERSION.SDK_INT < 21) {
            //透明状态栏
            context.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }else if (Build.VERSION.SDK_INT >= 21) {
            View decorView =context. getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE ;
            decorView.setSystemUiVisibility(option);
            context.getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
    }

    List<String> list=new ArrayList<>();
    public class TabRecyclerViewAdapter extends RecyclerView.Adapter<TabRecyclerViewAdapter.MyHolder> {


        @NonNull
        @Override
        public TabRecyclerViewAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new TabRecyclerViewAdapter.MyHolder(LayoutInflater.from(MainActivity.this).inflate(R.layout.item_common_tab,parent,false));
        }

        @Override
        public void onBindViewHolder(@NonNull TabRecyclerViewAdapter.MyHolder holder, int position) {
            Glide.with(MainActivity.this).load(list.get(position)).into(holder.im);
        }

        @Override
        public int getItemCount() {
            return list == null ? 0 : list.size();
        }

        class MyHolder extends RecyclerView.ViewHolder{
            public ImageView im;
            public TextView tv ;
            MyHolder(@NonNull View itemView) {
                super(itemView);
                im=itemView.findViewById(R.id.im);
                tv = itemView.findViewById(R.id.tv) ;
            }
        }
    }




    public List<String> getList0(){
        List<String>  listAll = new ArrayList <>();
        listAll.add("https://dss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=1618309945,4014036594&fm=26&gp=0.jpg");
        listAll.add("https://dss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=1072286108,2382947322&fm=26&gp=0.jpg");
        listAll.add("https://dss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=1078226477,1597555537&fm=26&gp=0.jpg");
        listAll.add("https://img11.360buyimg.com/da/s590x470_jfs/t1/113273/4/5687/50864/5eb50c1dE57ae0bdf/1bddbd7892346e23.jpg.webp");
        listAll.add("https://dss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=1618309945,4014036594&fm=26&gp=0.jpg");
        listAll.add("https://dss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=1072286108,2382947322&fm=26&gp=0.jpg");
        listAll.add("https://dss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=1078226477,1597555537&fm=26&gp=0.jpg");
        listAll.add("https://img11.360buyimg.com/da/s590x470_jfs/t1/113273/4/5687/50864/5eb50c1dE57ae0bdf/1bddbd7892346e23.jpg.webp");
        listAll.add("https://dss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=1618309945,4014036594&fm=26&gp=0.jpg");
        listAll.add("https://dss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=1072286108,2382947322&fm=26&gp=0.jpg");
        listAll.add("https://dss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=1078226477,1597555537&fm=26&gp=0.jpg");
        listAll.add("https://img11.360buyimg.com/da/s590x470_jfs/t1/113273/4/5687/50864/5eb50c1dE57ae0bdf/1bddbd7892346e23.jpg.webp");
        listAll.add("https://dss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=1618309945,4014036594&fm=26&gp=0.jpg");
        listAll.add("https://dss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=1072286108,2382947322&fm=26&gp=0.jpg");
        listAll.add("https://dss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=1078226477,1597555537&fm=26&gp=0.jpg");
        listAll.add("https://img11.360buyimg.com/da/s590x470_jfs/t1/113273/4/5687/50864/5eb50c1dE57ae0bdf/1bddbd7892346e23.jpg.webp");
        return listAll;
    }


    public static int screenWidth(){
        return MyApp.getContext().getResources().getDisplayMetrics().widthPixels;
    }
}
