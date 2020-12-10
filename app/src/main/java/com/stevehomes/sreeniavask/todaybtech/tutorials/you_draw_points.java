package com.stevehomes.sreeniavask.todaybtech.tutorials;


import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.stevehomes.sreeniavask.todaybtech.R;
import com.stevehomes.sreeniavask.todaybtech.Utils;

public class you_draw_points extends AppCompatActivity {


    private WebView mWebView;

    Toolbar toolbar;
    ProgressDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utils.onActivityCreateSetTheme(this);
        setContentView(R.layout.you_draw_points);
        toolbar=findViewById(R.id.toolbar);
        mWebView = (WebView) findViewById(R.id.you_draw_points_web);

        // Enable Javascript
        mWebView.setBackgroundResource(R.drawable.loder);
        mWebView.setBackgroundColor(0x00000);

        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        if (savedInstanceState == null)
        {
            mWebView.loadUrl("https://m.youtube.com/playlist?list=PLIhUrsYr8yHxEk_Jv8yOatn3Dcr6KYK3j");
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
    protected void onSaveInstanceState(Bundle outState )
    {
        super.onSaveInstanceState(outState);
        mWebView.saveState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState)
    {
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
        getMenuInflater().inflate(R.menu.main_manu,menu);
        return true;

    }


}