package org.jby.studyenglish;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class CalendarFragment2 extends Fragment {
    WebView webView, webView2, webView3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_calendar2, container, false);

        webView = rootView.findViewById(R.id.webView);
        webView2 = rootView.findViewById(R.id.webView2);
        webView3 = rootView.findViewById(R.id.webView3);

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        WebSettings webSettings2 = webView2.getSettings();
        webSettings2.setJavaScriptEnabled(true);
        WebSettings webSettings3 = webView3.getSettings();
        webSettings3.setJavaScriptEnabled(true);

        webView.setWebViewClient(new ViewClient());
        webView2.setWebViewClient(new ViewClient());
        webView3.setWebViewClient(new ViewClient());

        webView.loadUrl("https://appexam.ybmnet.co.kr/toeic/info/receipt_schedule.asp");
        webView2.loadUrl("https://appexam.ybmnet.co.kr/toeicswt/receipt/schedule.asp");
        webView3.loadUrl("https://m.opic.or.kr/opics/servlet/controller.opic.site.receipt.AnnualScheduleServlet?p_process=select-list-mobile&p_tab=opic");

        return rootView;
    }

    private class ViewClient extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(final WebView view, final String url) {
            view.loadUrl(url);

            return true;
        }
    }
}
