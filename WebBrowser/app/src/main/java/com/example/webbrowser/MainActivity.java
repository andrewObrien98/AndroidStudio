package com.example.webbrowser;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout mainlayout = new LinearLayout(this);
        mainlayout.setOrientation(LinearLayout.VERTICAL);

        //create linked list of URL
        URLLinkedlList urlList = new URLLinkedlList();

        //create Browser layout and button params
        LinearLayout browserLayout = new LinearLayout(this);
        LinearLayout.LayoutParams buttonParams = new LinearLayout.LayoutParams(150, LinearLayout.LayoutParams.WRAP_CONTENT);

        //create url text place
        AppCompatEditText urlText = new AppCompatEditText(this);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        params.weight = 1;
        urlText.setLayoutParams(params);

        //Create web layout and show Web
        WebView webView = new WebView(this);
        LinearLayout webLayout = new LinearLayout(this);
        GoButton go = new GoButton("GO", urlList, webView, urlText, this);
        BackButton B = new BackButton("B", urlList, webView, urlText, this);
        ForwardButton F = new ForwardButton("F", urlList, webView, urlText, this);


        //add the app layouts
        browserLayout.addView(B);
        browserLayout.addView(F);
        browserLayout.addView(urlText);
        browserLayout.addView(go);
        webLayout.addView(webView);
        mainlayout.addView(browserLayout);
        mainlayout.addView(webLayout);
        setContentView(mainlayout);
    }
}