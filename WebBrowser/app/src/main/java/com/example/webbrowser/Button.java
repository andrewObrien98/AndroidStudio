package com.example.webbrowser;

import android.content.Context;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;

public class Button extends AppCompatButton {

    public Button(@NonNull Context context) {
        super(context);
    }
    public void params(){
        LinearLayout.LayoutParams buttonParams = new LinearLayout.LayoutParams(150, LinearLayout.LayoutParams.WRAP_CONTENT);
        setLayoutParams(buttonParams);
    }


}

class GoButton extends Button {
    GoButton(String name, URLLinkedlList list, WebView webView, AppCompatEditText urlText, @NonNull Context context){
        super(context);
        setText(name);
        params();
        setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String url = checkhttps(urlText.getText().toString());
                list.insert(url);
                webView.loadUrl(url);
                webView.setWebViewClient(new WebViewClient());
            }
        });
    }
    public String checkhttps(String url){
        if (url.contains("https://")){
            return url;
        }
        return "https://" + url;
    }
}
class BackButton extends Button{
    public BackButton(String name, URLLinkedlList list, WebView webView, AppCompatEditText urlText, @NonNull Context context) {
        super(context);
        setText(name);
        params();
        setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (list.checkTail()){
                    String url = list.back();
                    webView.loadUrl(url);
                    webView.setWebViewClient(new WebViewClient());
                    urlText.setText(url);
                }
            }
        });
    }
}
class ForwardButton extends Button{

    public ForwardButton(String name, URLLinkedlList list, WebView webView, AppCompatEditText urlText, @NonNull Context context) {
        super(context);
        setText(name);
        params();
        setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (list.checkHead()){
                    String url = list.forward();
                    webView.loadUrl(url);
                    webView.setWebViewClient(new WebViewClient());
                    urlText.setText(url);
                }
            }
        });
    }
}