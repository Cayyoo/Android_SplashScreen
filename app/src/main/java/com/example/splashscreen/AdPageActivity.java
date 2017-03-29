package com.example.splashscreen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * 广告页
 */
public class AdPageActivity extends Activity {
    private LinearLayout mLayoutSkip;
    private TextView mTime;

    private int time=3;//倒计时时间

    private Animation mTimeAnim;
    private boolean jumpTo=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad_page);

        mLayoutSkip=(LinearLayout)findViewById(R.id.ll_countdown);
        mTime=(TextView)findViewById(R.id.tv_countdown);

        mTimeAnim= AnimationUtils.loadAnimation(this,R.anim.set_app_ad_page);

        handler.sendEmptyMessageDelayed(0,1000);

        mLayoutSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jumpIntoMainOrLogin();
            }
        });
    }

    private void getCount(){
        time--;
        mTime.setText(String.valueOf(time));
        mTimeAnim.reset();
        mTime.startAnimation(mTimeAnim);
    }

    private Handler handler=new Handler(){
        public void handleMessage(Message msg){
            if (msg.what == 0){
                getCount();

                if (time != 0){
                    handler.sendEmptyMessageDelayed(0,1000);
                }else {
                    handler.sendEmptyMessageDelayed(1,1000);
                }
            }else if(msg.what == 1 && !jumpTo){
                jumpIntoMainOrLogin();
            }
        }
    };

    private void jumpIntoMainOrLogin(){
        startActivity(new Intent(AdPageActivity.this,MainActivity.class));
        jumpTo=true;
        finish();
    }

}
