package com.example.splashscreen.utils;

import java.util.ArrayList;
import java.util.List;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * 引导页GuideActivity使用的PageView适配器
 */
public class GuidePagerAdapter extends PagerAdapter{
	private List<View> views=new ArrayList<View>();
	
	public GuidePagerAdapter(List<View> views){
		this.views=views;
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		return arg0 == arg1;
	}

	@Override
	public int getCount() {
		return views!=null? views.size():0;//非循环轮播
		//return  Integer.MAX_VALUE;//循环轮播
	}

	/**
         * 当只有3张图片或者2张图片的时候，滑动存在BUG，需要注释掉removeView()
         */
	@Override
	public void destroyItem(View container, int position, Object object) {
		((ViewPager) container).removeView(views.get(position));//非循环轮播
		//((ViewPager) container).removeView(views.get(position % views.size()));//循环轮播需注销
	}

	/**
         * 载入图片进去，用当前的position 除以 图片数组长度取余数是关键
         *
         * 当只有3张图片或者2张图片的时候，滑动存在BUG，需要捕获异常，即使用try...catch
         */
	@Override
	public Object instantiateItem(View container, int position) {
		//非循环轮播
		((ViewPager) container).addView(views.get(position));
		return views.get(position);

		//循环轮播
        /*try{
			((ViewPager)container).addView(views.get(position % views.size()),0);
        }catch(Exception e) {
            e.printStackTrace();
        }
        return views.get(position % views.size());*/
	}

}
