package com.xlx.healthfood.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
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
			btnBack.setBackgroundResource(R.drawable.btn_back_active);
			Intent intent = new Intent(this, FoodListActivity.class);
			startActivity(intent);
		}
		
	}
}
