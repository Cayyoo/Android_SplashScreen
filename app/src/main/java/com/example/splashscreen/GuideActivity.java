package com.example.splashscreen;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.example.splashscreen.utils.GuidePagerAdapter;
import com.example.splashscreen.utils.CreateShut;
import com.example.splashscreen.utils.SharedConfig;

/**
 * 引导页
 */
public class GuideActivity extends Activity implements OnPageChangeListener,OnClickListener {
	private Context context;

	private ViewPager viewPager;
	private PagerAdapter pagerAdapter;

	private Button startButton;
	private LinearLayout indicatorLayout;

	private ArrayList<View> views;
	private ImageView[] indicators = null;
	private int[] images;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_guide);
		context = this;

		// 创建桌面快捷方式
		new CreateShut(this);

		// 设置引导图片
		//仅需在这设置图片，指示器和page自动添加
		images = new int[] { R.drawable.welcome_01, R.drawable.welcome_02,R.drawable.welcome_03 };

		initView();
	}

	/**
	 * 初始化视图
	 */
	private void initView() {
		// 实例化视图控件
		viewPager = (ViewPager) findViewById(R.id.viewpage);

		startButton = (Button) findViewById(R.id.start_Button);
		startButton.setOnClickListener(this);

		indicatorLayout = (LinearLayout) findViewById(R.id.indicator);

		views = new ArrayList<View>();
		indicators = new ImageView[images.length]; //定义指示器数组大小

		for (int i = 0; i < images.length; i++) {
			// 循环加入图片
			ImageView imageView = new ImageView(context);
			imageView.setBackgroundResource(images[i]);
			views.add(imageView);

			// 循环加入指示器
			indicators[i] = new ImageView(context);
			indicators[i].setBackgroundResource(R.drawable.indicators_default);

			if (i == 0) {
				indicators[i].setBackgroundResource(R.drawable.indicators_now);
			}

			indicatorLayout.addView(indicators[i]);
		}

		pagerAdapter = new GuidePagerAdapter(views);
		viewPager.setAdapter(pagerAdapter); // 设置适配器
		viewPager.addOnPageChangeListener(this);

		viewPager.setCurrentItem(0);//设置ViewPager的默认项, 开始时不能往左滑动
		//viewPager.setCurrentItem(views.size() * 100);//开始即可向左轮播，若不设置开始时不可向左
	}

	//按钮的点击事件
	@Override
	public void onClick(View v) {
		if (v.getId() == R.id.start_Button) {
			SharedPreferences shared = new SharedConfig(this).GetConfig();
			Editor editor = shared.edit();
			editor.putBoolean("First", false);
			editor.commit();
			
			startActivity(new Intent(GuideActivity.this, MainActivity.class));
			overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
			this.finish();
		}
	}

	@Override
	public void onPageScrollStateChanged(int arg0) {

	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {

	}

	// 监听viewpage
	@Override
	public void onPageSelected(int arg0) {
		changeIndicatorImage(arg0);//非循环轮播
		//changeIndicatorImage(arg0 % views.size());//循环轮播

		getStarted(arg0);//显示体验按钮
	}

	/**
	 * 显示最后一个图片时显示按钮
	 */
	public void getStarted(int i) {
		if (i == indicators.length - 1) {
			startButton.setVisibility(View.VISIBLE);
		} else {
			startButton.setVisibility(View.GONE);
		}
	}

	/**
	 * 更改指示器图片
	 */
	public void changeIndicatorImage(int position) {
		for (int i = 0; i < indicators.length; i++) {
			indicators[position].setBackgroundResource(R.drawable.indicators_now);

			if (position != i) {
				indicators[i].setBackgroundResource(R.drawable.indicators_default);
			}
		}
	}

}
