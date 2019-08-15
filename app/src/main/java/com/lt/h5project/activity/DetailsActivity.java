package com.lt.h5project.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.lt.h5project.R;
import com.lt.h5project.bean.NetUrlBean;
import com.tencent.smtt.export.external.interfaces.WebResourceError;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

/**
 * @author yeyang
 * @name H5project
 * @class name：com.lt.h5project
 * @class describe
 * @time 2019-06-18 11:23
 * @change
 * @chang time
 * @class describe
 */
public class DetailsActivity extends AppCompatActivity {

    private WebView mWebView;


    public static void launch(Context context, NetUrlBean.DataEntity dataEntity) {
        Intent intent = new Intent(context, DetailsActivity.class);
        intent.putExtra("data", dataEntity);
        context.startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        final TextView tvTitle = findViewById(R.id.tv_title);
        mWebView = findViewById(R.id.webview);
        findViewById(R.id.tv_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Intent intent = getIntent();
        final NetUrlBean.DataEntity dataEntity = (NetUrlBean.DataEntity) intent.getSerializableExtra("data");
        initWebView();
        loadUrl(tvTitle, dataEntity);
//        final SwipeRefreshLayout refreshLayout = findViewById(R.id.refresh);
//        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//            @Override
//            public void onRefresh() {
//                refreshLayout.setRefreshing(true);
//                loadUrl(tvTitle, addressBean);
//                refreshLayout.setRefreshing(false);
//            }
//        });
        findViewById(R.id.tv_refresh).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadUrl(tvTitle, dataEntity);
            }
        });

        findViewById(R.id.tv_clean_cache).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mWebView.clearCache(true);
                Toast.makeText(MyApplication.getContext(),"缓存清理完毕",Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void loadUrl(TextView tvTitle, NetUrlBean.DataEntity dataEntity) {
        tvTitle.setText(dataEntity.name);
        mWebView.loadUrl(loadUrl(dataEntity.url));

        mWebView.setWebViewClient(new WebViewClient() {

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (url != null) {
                    if (!url.startsWith("http:") && !url.startsWith("https:")) {
                        return true;
                    }
                }
                return super.shouldOverrideUrlLoading(view, url);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
            }

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
            }
        });
    }

    /**
     * 初始化webview
     */
    @SuppressLint("JavascriptInterface")
    private void initWebView() {
        WebSettings webSettings = mWebView.getSettings();

        //如果访问的页面中要与Javascript交互，则webview必须设置支持Javascript
        webSettings.setJavaScriptEnabled(true);

        //设置自适应屏幕，两者合用
        webSettings.setUseWideViewPort(true); //将图片调整到适合webview的大小
        webSettings.setLoadWithOverviewMode(true); // 缩放至屏幕的大小
        webSettings.setTextZoom(100);
        ; // 缩放至屏幕的大小

        webSettings.setBuiltInZoomControls(false);
        webSettings.setSupportZoom(false);
        webSettings.setPluginState(WebSettings.PluginState.ON);
        webSettings.setDomStorageEnabled(true);
        webSettings.setLoadsImagesAutomatically(true);

        //其他细节操作
        webSettings.setCacheMode(WebSettings.LOAD_NORMAL);
//        webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE); //关闭webview中缓存
        webSettings.setAllowFileAccess(true); //设置可以访问文件
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true); //支持通过JS打开新窗口
        webSettings.setLoadsImagesAutomatically(true); //支持自动加载图片
        webSettings.setDefaultTextEncodingName("utf-8");//设置编码格式

    }

    private String loadUrl(String url) {
        if (!url.startsWith("http")) {
            url = "http://" + url;
            return url;
        }
        return url;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        mWebView.clearCache(true);
    }
}
