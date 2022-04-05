package com.example.webview_example;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    WebView webview;
    String currentPage;
    Editable search;
    TextInputEditText txtInput;
    TextInputLayout til;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webview = findViewById(R.id.webView);
        webview.setWebViewClient(new WebViewClient());
        webview.getSettings().setJavaScriptEnabled(true);
        webview.loadUrl("http://www.lut.fi");
    }

    public void refresh(View v){
        currentPage = webview.getUrl();
        webview.loadUrl(currentPage);
    }

    public void executeJavascript(View a){
        webview.loadUrl("file:///android_asset/index.html");
        webview.evaluateJavascript("javascript:shoutOut()", null);
    }

    public void initialize(View v){
        webview.loadUrl("file:///android_asset/index.html");
        webview.evaluateJavascript("javascript:initialize()", null);
    }
}