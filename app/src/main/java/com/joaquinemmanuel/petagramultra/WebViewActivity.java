package com.joaquinemmanuel.petagramultra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class WebViewActivity extends AppCompatActivity {
    WebView webView;
    String user;
    Button button;
    String url;
    String autCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        webView = findViewById(R.id.wvMiPagina);
        button = findViewById(R.id.btnRegistro);
        Bundle parametros = getIntent().getExtras();
        user = parametros.getString("A");
        webView.canGoBack();
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                Log.d("ME" , url);
            }
        });
        webView.loadUrl(ConstantesUrl.REAL_URL);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                url = webView.getUrl();
                String[] url2 = url.split("code=");
                String real = url2[1];
                String real_string = real.replace("#_" , "");
                autCode = real_string;
                Intent intent = new Intent(WebViewActivity.this , MainActivity.class);
                intent.putExtra("A" , user);
                intent.putExtra("B" , autCode);
                startActivity(intent);
                finish();
            }
        });


    }
}