package com.example.android_e_learning.ui.tools;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.android_e_learning.R;

public class ToolsFragment extends Fragment {


    @SuppressLint("SetJavaScriptEnabled")
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_tools, container, false);
        WebView webView = (WebView) root.findViewById(R.id.webview);
        //加载服务器上的页面
        webView.loadUrl("http://tang5618.com/e-learning.html");
        //内嵌App，不以浏览器的方式打开
        webView.setWebViewClient(new WebViewClient());
        //获取浏览器设置
        WebSettings webSettings = webView.getSettings();
        //允许javascript
        webSettings.setJavaScriptEnabled(true);

        return root;
    }
}