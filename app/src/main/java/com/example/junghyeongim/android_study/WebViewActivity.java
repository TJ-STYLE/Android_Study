package com.example.junghyeongim.android_study;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * 웹뷰 화면
 * @author junghyeon
 * @
 */
public class WebViewActivity extends AppCompatActivity {

    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        setWebView();
    }

    /**
     * 웹뷰 초기화 설정
     */
    @SuppressLint("SetJavaScriptEnabled")
    private void setWebView() {
        mWebView = (WebView) findViewById(R.id.web_view_wv);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        mWebView.setWebViewClient(new WebClient());
        mWebView.loadUrl("http://futureplay.co");
    }

    class WebClient extends WebViewClient {
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            //tel://, mailto://, intent://
            return true;
        }
    }
}
