package com.example.android_e_learning.adapter;
;
import android.view.View;
import android.view.ViewGroup;

import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class ViewPagerAdapter extends PagerAdapter {
    private List<View> datas;

    public ViewPagerAdapter(List<View> datas){
        this.datas=datas;
    }
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }
    @Override
    public int getCount() {
        return datas.size();
    }
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View v=datas.get(position);
        container.addView(v);
        return v;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(datas.get(position));
    }
}
