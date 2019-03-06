package com.zhaowh.travel.Adapter;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class MyPageAdapter extends PagerAdapter {

    private List<View> list;


    public MyPageAdapter(List<View> list) {
        super();
        this.list = list;
    }

    //获得viewpager中有多少个view
    @Override
    public int getCount() {
        return list.size();
    }

    /**
     * 判断isViewFromObject(ViewGroup, int)函数返回的Key与
     * 一个页面视图是否是代表的是同一个试图（即他俩是对应的，对应的表示同一个View）
     * 通常直接写成return view = object
     * @param view
     * @param object
     * @return
     */
    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    /**
     * 将给定位置的view添加到ViewGroup中，创建并显示出来
     * 返回一个代表新增页面的Object(key)，通常都是直接返回view本身就可以了
     * 当然你也可以自定义自己的key，但是key和每个view要一一对应
     * @param container
     * @param position
     * @return
     */
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        container.addView(list.get(position));
        return list.get(position);
    }

    //移除一个给定位置的页面
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView(list.get(position));
    }
}
