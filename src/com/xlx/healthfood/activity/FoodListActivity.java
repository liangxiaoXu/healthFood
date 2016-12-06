package com.xlx.healthfood.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.xlx.healthfood.data.Context;
import com.xlx.healthfood.data.FoodInfo;

public class FoodListActivity extends ListActivity implements OnItemClickListener, OnClickListener{
	ListView listView = null;
	Button searchBtn = null;
	Button clearBtn = null;
	EditText searchFoodNameEditText = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.foodlist);
		searchBtn = (Button) findViewById(R.id.search);
		searchBtn.setOnClickListener(this);
		searchFoodNameEditText = (EditText) findViewById(R.id.searchFoodName);
		clearBtn = (Button) findViewById(R.id.clear);
		clearBtn.setOnClickListener(this);
		
		show("");
		
		listView = this.getListView();
		listView.setOnItemClickListener(this);
	}
	
	public void onItemClick(AdapterView<?> paramAdapterView, View paramView,
			int position, long id) {
		Intent intent = new Intent(getApplicationContext(), FoodDetailActivity.class);
		intent.putExtra("foodName", Context.source.get(position).getName());
		startActivity(intent);
	}

	public void onClick(View paramView) {
		if(paramView.getId() == R.id.search){
			//搜索
			String searchFoodName = searchFoodNameEditText.getText().toString();
			show(searchFoodName);
		}else if(paramView.getId() == R.id.clear){
			//刷新
			searchFoodNameEditText.setText("");
			show("");
			
		}
		
	}
	
	
	public void show(String searchName){
		List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
		if(searchName == null || "".equals(searchName)){
			for(FoodInfo foodInfo : Context.source){
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("name", foodInfo.getName());
				map.put("dietName", foodInfo.getDietName());
				map.put("resourceId", foodInfo.getResourceId());
				data.add(map);
			}
		}else{
			for(FoodInfo foodInfo : Context.source){
//				if(searchName.equals(foodInfo.getName())){
				if(foodInfo.getName().contains(searchName)){
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("name", foodInfo.getName());
					map.put("dietName", foodInfo.getDietName());
					map.put("resourceId", foodInfo.getResourceId());
					data.add(map);
				}
			}
		}
		
		if(data.isEmpty()){
			Toast toast = Toast.makeText(getApplicationContext(), "没有查到内容", Toast.LENGTH_SHORT);
			setListAdapter(null);
			toast.show();
			return;
		}
		
		SimpleAdapter adapter = new SimpleAdapter(this, data, R.layout.food_list_row, 
				new String[]{"name","dietName","resourceId"}, new int[]{R.id.foodName, R.id.dietName, R.id.foodImage});
		setListAdapter(adapter);
	}
	
}
