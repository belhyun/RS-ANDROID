package team.subwaycommnunity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class FragmentWeb extends Fragment {

	private WebView mWebView;
	private ProgressBar mProgressBar;
	private Bundle mWebBundle;
	private String mTag;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_web, container, false);

		return v;
	}
	

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		mTag = getTag();
		
		mProgressBar = (ProgressBar) getView()
				.findViewById(R.id.webProgressBar);
		mProgressBar.setMax(100);
		mProgressBar.setProgress(0);
		
		
		
		
		mWebView = (WebView) getView().findViewById(R.id.webContainer);

		mWebView.getSettings().setBuiltInZoomControls(false);
		mWebView.getSettings().setJavaScriptEnabled(true);
		mWebView.setOnKeyListener(new WebView.OnKeyListener() {

			@Override
			public boolean onKey(View v, int keyCode, KeyEvent event) {
				if ((keyCode == KeyEvent.KEYCODE_BACK) && mWebView.canGoBack()) {
					mWebView.goBack();
					return true;
				}
				return false;

			}
		});
		mWebView.setOnLongClickListener(new WebView.OnLongClickListener() {
			
			@Override
			public boolean onLongClick(View v) {
				
				return false;
			}
		});

		if (mWebBundle != null) {
			mWebView.restoreState(mWebBundle);
		} else {
			if(mTag == "easy"){
				mWebView.loadUrl("http://easytwitter.co.kr?m=y()/");
			}
			else if(mTag == "event"){
				mWebView.loadUrl("http://eventstore.co.kr/");
			}
			
		}

		mWebView.setWebChromeClient(new WebChromeClient() {
			@Override
			public void onProgressChanged(WebView view, int newProgress) {
				mProgressBar.setProgress(newProgress);
				super.onProgressChanged(view, newProgress);
			}

		});
		mWebView.setWebViewClient(new WebViewClient() {
			@Override
			public void onPageStarted(WebView view, String url, Bitmap favicon) {
				mProgressBar.setVisibility(View.VISIBLE);
				super.onPageStarted(view, url, favicon);
			}
			@Override
			public void onPageFinished(WebView view, String url) {
				mProgressBar.setVisibility(View.GONE);
				super.onPageFinished(view, url);
			}
			
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				view.loadUrl(url);
				return true;
			}

		});

	}
	@Override
	public void onPause() {
		
		super.onPause();
		
		mWebBundle = new Bundle();
		mWebView.saveState(mWebBundle);
	}
	
	

}
