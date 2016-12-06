package com.xlx.healthfood.activity;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener{
	Button btnFoodList;
	Button btnFoodAbout;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.main);

        btnFoodList = (Button) findViewById(R.id.btn_food_list);
        btnFoodList.setOnClickListener(this);
        
        btnFoodAbout = (Button) findViewById(R.id.btn_food_about);
        btnFoodAbout.setOnClickListener(this);
        
    }
    
	public void onClick(View v) {
		if(v.getId() == R.id.btn_food_list){
			//食物营养表
			btnFoodList.setBackgroundResource(R.drawable.btn_food_list_active);
			Intent intent = new Intent(this, FoodListActivity.class);
			startActivity(intent);
		}else if(v.getId() == R.id.btn_food_about){
			//关于本软件
			btnFoodAbout.setBackgroundResource(R.drawable.btn_food_about_active);
			Intent intent = new Intent(this, AboutActivity.class);
			startActivity(intent);
		}
	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		btnFoodList.setBackgroundResource(R.drawable.btn_food_list);
		btnFoodAbout.setBackgroundResource(R.drawable.btn_food_about);
	}
    
}