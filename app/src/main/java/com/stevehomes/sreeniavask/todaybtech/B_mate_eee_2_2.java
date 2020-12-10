package com.stevehomes.sreeniavask.todaybtech;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class B_mate_eee_2_2 extends AppCompatActivity {


    private WebView mWebView;
    Toolbar toolbar;
    ProgressDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utils.onActivityCreateSetTheme(this);
        setContentView(R.layout.b_mate_eee_2_2);

//        actionBar = getSupportActionBar();
//        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#212121")));


        mWebView = (WebView) findViewById(R.id.mate_eee_2_2_web);

        // Enable Javascript
        toolbar=findViewById(R.id.toolbar);
        mWebView.setBackgroundResource(R.drawable.loder);
        mWebView.setBackgroundColor(0x00000);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("JNTUA Notes");
//        toolbar.setSubtitle("     SteveHomes");
//        toolbar.setLogo(R.drawable.tool_icon);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu2);

        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        if (savedInstanceState == null)
        {
            mWebView.loadUrl("https://todaybtech.blogspot.com/p/blog-page_31.html");
        }



        mWebView.setWebViewClient(new WebViewClient());



        mWebView.setDownloadListener(new DownloadListener() {
            public void onDownloadStart(String url, String userAgent,
                                        String contentDisposition, String mimetype,
                                        long contentLength) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

//        if (savedInstanceState == null) {
//            getSupportFragmentManager().beginTransaction()
//                    .add(R.id.container, new PlaceholderFragment())
//                    .commit();
//
//
//        }



        init();
        listener();


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
    private void init() {


        pDialog = new ProgressDialog(B_mate_eee_2_2.this);
        pDialog.setTitle("Please Wait...");
        pDialog.setMessage("Wait for few seconds till the PDF file loads...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(true);
    }

    private void listener() {
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                try{
                    pDialog.show();
                }
                catch (WindowManager.BadTokenException exception ) {


                }catch(IllegalArgumentException e){

                }

            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                try{
                    pDialog.dismiss();
                }
                catch (WindowManager.BadTokenException exception ) {


                }catch(IllegalArgumentException e){

                }

            }
        });
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.home:
                Intent intent=new Intent(this,features.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                Toast.makeText(this, "You are at Home ", Toast.LENGTH_SHORT).show();
                break;

            case android.R.id.home:
                finish();
                break;
        }


        return super.onOptionsItemSelected(item);

    }
}