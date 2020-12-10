package com.stevehomes.sreeniavask.todaybtech.tutorials;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.stevehomes.sreeniavask.todaybtech.R;
import com.stevehomes.sreeniavask.todaybtech.Utils;

public class you_all_android_app_videos extends AppCompatActivity {

    private WebView mWebView;

    Toolbar toolbar;
    ProgressDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utils.onActivityCreateSetTheme(this);
        setContentView(R.layout.you_all_android_app_videos);
        toolbar = findViewById(R.id.toolbar);
        mWebView = (WebView) findViewById(R.id.you_android_app_videos_web);

        // Enable Javascript
        mWebView.setBackgroundResource(R.drawable.loder);
        mWebView.setBackgroundColor(0x00000);

        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        if (savedInstanceState == null) {
            mWebView.loadUrl("https://www.youtube.com/watch?v=3mtr0ouSwRo&list=PLWPirh4EWFpFO9DnEwsLF4hjPio7aD9Qc");
//            mWebView.loadUrl("https://www.youtube.com/watch?v=oPpnCh7InLY&list=PLRqwX-V7Uu6ZF9C0YMKuns9sLDzK6zoiV&t=0s");
        }

        mWebView.setWebViewClient(new WebViewClient());
        mWebView.getSettings().setLoadWithOverviewMode(true);


        mWebView.setDownloadListener(new DownloadListener() {
            public void onDownloadStart(String url, String userAgent,
                                        String contentDisposition, String mimetype,
                                        long contentLength) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);

            }

        });


    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mWebView.saveState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mWebView.restoreState(savedInstanceState);
    }

    @Override
    public void onBackPressed() {
        if (mWebView.canGoBack()) {
            mWebView.goBack();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_manu, menu);
        return true;

    }
}




