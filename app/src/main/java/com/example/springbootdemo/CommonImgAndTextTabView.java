package com.example.springbootdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;


public class CommonImgAndTextTabView extends RecyclerView {

    int spanCount =  8;

    public CommonImgAndTextTabView(Context context) {
        this(context,null);
    }
    public CommonImgAndTextTabView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }
    public CommonImgAndTextTabView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
    private void init() {
        setNestedScrollingEnabled(false);
        MyGridLayoutManager linearLayoutManager=new MyGridLayoutManager(getContext(),5);
        linearLayoutManager.setOrientation(VERTICAL);
        linearLayoutManager.setmCanVerticalScroll(false);
        setLayoutManager(linearLayoutManager);
    }


    public <T> void setAdapter(List<T> l,int spanCount){
        this.spanCount = spanCount ;
        TabRecyclerViewAdapter<T> adapter = new TabRecyclerViewAdapter<>(l);
        setAdapter(adapter);
    }


    @Override
    protected void onMeasure(int widthSpec, int heightSpec) {
        super.onMeasure(widthSpec, heightSpec);
    }

    public class TabRecyclerViewAdapter<T> extends RecyclerView.Adapter<TabRecyclerViewAdapter.MyHolder> {

        List<T> list ;
        public TabRecyclerViewAdapter( List<T> list){
            this.list=list ;
        }

        @NonNull
        @Override
        public TabRecyclerViewAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new TabRecyclerViewAdapter.MyHolder(LayoutInflater.from(getContext()).inflate(R.layout.item_common_tab,parent,false));
        }

        @Override
        public void onBindViewHolder(@NonNull TabRecyclerViewAdapter.MyHolder holder, int position) {
            ViewGroup.LayoutParams params = holder.itemView.getLayoutParams();
            params.width = MainActivity.screenWidth() / spanCount;
            holder.itemView.setLayoutParams(params);
            holder.tv.setText((String)list.get(0));
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
}
