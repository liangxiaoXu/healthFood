package com.xlx.healthfood.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebActivity extends Activity{
	private static final String tag = "WebActivity";
	WebView webView = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.webview);
		webView = (WebView) findViewById(R.id.webView);
		
		Bundle bundle = getIntent().getExtras();
		String url = bundle.getString("url");
		Log.i(tag, "接收到的url:" + url);
		webView.loadUrl(url);
		
		//覆盖webView默认使用第三方或者默认浏览器打开网页的行为，使网页用webView打开
		webView.setWebViewClient(new WebViewClient(){
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				// TODO Auto-generated method stub
				view.loadUrl(url);
				return true;
			}
		});
		//支持js
		WebSettings settings = webView.getSettings();
		settings.setJavaScriptEnabled(true);
		
		
	}
	
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		//改写返回按键，返回上一个网页，而不是退出浏览器
		if(keyCode == KeyEvent.KEYCODE_BACK){
			if(webView.canGoBack()){
				webView.goBack();//返回上一个页面
				return true;
			}else{
				System.exit(0);//退出程序
			}
		}
		
		return super.onKeyDown(keyCode, event);
		
	}

}
