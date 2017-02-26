package com.example.splashscreen;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.example.splashscreen.utils.SharedConfig;

/**
 * 首页
 */
public class MainActivity extends AppCompatActivity implements OnClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button button=(Button)findViewById(R.id.button);
		assert button != null;
		button.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		new SharedConfig(this).ClearConfig();//清除配置

        Toast.makeText(MainActivity.this,"已清除配置",Toast.LENGTH_SHORT).show();
	}

}
