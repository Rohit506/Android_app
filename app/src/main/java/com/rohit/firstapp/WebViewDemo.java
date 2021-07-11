package com.rohit.firstapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Build;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class WebViewDemo extends AppCompatActivity {
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_demo);
        webView=findViewById(R.id.webView);
        final ProgressDialog pd=new ProgressDialog(this);
        pd.setMessage("Loading...");
        pd.setCancelable(false);
        webView.setVerticalScrollBarEnabled(true);
        webView.requestFocus();
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDefaultTextEncodingName("utf-8");
        webView.loadUrl("https://www.geeksforgeeks.org/");
        webView.setWebViewClient(new WebViewClient()
        {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadUrl(String.valueOf(request.getUrl()));
                return true;
            }
        });
        webView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                if(newProgress<100)
                {
                    pd.show();
                }
                else
                {
                    pd.dismiss();
                }
            }
        });

    }

    @Override
    public void onBackPressed() {
        if (webView!=null && webView.canGoBack())
        {
            webView.goBack();
        }
        else
        super.onBackPressed();
    }
}
