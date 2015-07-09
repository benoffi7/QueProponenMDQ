package com.coffeeandcookies.queproponenmdq;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ProgressBar;

@SuppressLint("SetJavaScriptEnabled")
public class WebviewActivity extends Activity	
{
	private WebView webview;
	private ProgressBar progressBar;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.web_view);
		setUI();
		setWebView();
	}
	
	void setUI()
	{
		webview = (WebView) findViewById(R.id.webview);
		progressBar = (ProgressBar) findViewById(R.id.progressBar);
		webview.setVisibility(View.GONE);
		progressBar.setVisibility(View.VISIBLE);
		
	}
	
	WebChromeClient wcc = new WebChromeClient()
	{
		public void onProgressChanged(WebView view, int newProgress) 
		{
			if (newProgress == 100)
			{
				webview.setVisibility(View.VISIBLE);
				progressBar.setVisibility(View.GONE);
			}
		};
	};
	
	void setWebView()
	{
		webview.getSettings().setJavaScriptEnabled(true);
		webview.setWebChromeClient(wcc);
		webview.loadUrl(getIntent().getExtras().getString("URL"));
	}
	
	@Override
	public void onBackPressed()
	{
		finish();
		super.onBackPressed();
	}
}
