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
		Log.i(tag, "���յ���url:" + url);
		webView.loadUrl(url);
		
		//����webViewĬ��ʹ�õ���������Ĭ�����������ҳ����Ϊ��ʹ��ҳ��webView��
		webView.setWebViewClient(new WebViewClient(){
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				// TODO Auto-generated method stub
				view.loadUrl(url);
				return true;
			}
		});
		//֧��js
		WebSettings settings = webView.getSettings();
		settings.setJavaScriptEnabled(true);
		
		
	}
	
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		//��д���ذ�����������һ����ҳ���������˳������
		if(keyCode == KeyEvent.KEYCODE_BACK){
			if(webView.canGoBack()){
				webView.goBack();//������һ��ҳ��
				return true;
			}else{
				System.exit(0);//�˳�����
			}
		}
		
		return super.onKeyDown(keyCode, event);
		
	}

}
