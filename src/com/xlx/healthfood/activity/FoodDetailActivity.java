package com.xlx.healthfood.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

import com.xlx.healthfood.data.Context;
import com.xlx.healthfood.data.FoodInfo;

public class FoodDetailActivity extends Activity implements OnClickListener{
	
	Button btnBack = null;
	Button buttonView = null;
	TextView foodDescTextView = null;
	TextView eFoodNameTextView = null;
	TextView eFoodDescTextView = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.food_detail);
		
		btnBack = (Button) findViewById(R.id.btn_back);
		btnBack.setOnClickListener(this);
		buttonView = (Button) findViewById(R.id.food_detail_button);
		buttonView.setOnClickListener(this);
		foodDescTextView = (TextView) findViewById(R.id.food_detail_foodDesc);
		eFoodNameTextView = (TextView) findViewById(R.id.eFoodName);
		eFoodDescTextView = (TextView) findViewById(R.id.eFoodDesc);
		
		Bundle bundle = getIntent().getExtras();
		String foodName = bundle.getString("foodName");
		for(FoodInfo foodInfo : Context.source){
			if(foodName.equals(foodInfo.getName())){
				buttonView.setText(foodName);
				buttonView.setBackgroundResource(foodInfo.getResourceId());
				foodDescTextView.setText(foodInfo.getFoodInfo());
				eFoodNameTextView.setText(foodInfo.geteName());
				eFoodDescTextView.setText(foodInfo.geteInfo());
			}
		}
		
		
	}

	public void onClick(View paramView) {
		if(paramView.getId() == R.id.btn_back){
			//返回按钮
			btnBack.setBackgroundResource(R.drawable.btn_back_active);
			Intent intent = new Intent(this, FoodListActivity.class);
			startActivity(intent);
		}else if(paramView.getId() ==  R.id.food_detail_button){
			//点击图片，打开webview搜索关键词
			Intent intent = new Intent(this, WebActivity.class);
			String word = buttonView.getText().toString();
			
			intent.putExtra("url", "http://m.baidu.com/"+"s?ie=utf-8&f=8&rsv_bp=0&rsv_idx=1&tn=baidu&wd="+word+"&rsv_pq=a8f5902800000971&rsv_t=9685tkOSjtIeU%2BfHg%2B%2BNCwo0NU3GjCbgYUZ1PKwKBm9C2YzixA0V%2BDPrRDk&rqlang=cn&rsv_enter=0&rsv_sug3=11&rsv_sug1=10&rsv_sug7=100&inputT=1197&rsv_sug4=1648&rsv_sug=1");
			startActivity(intent);
			
		}
		
	}
	
}
