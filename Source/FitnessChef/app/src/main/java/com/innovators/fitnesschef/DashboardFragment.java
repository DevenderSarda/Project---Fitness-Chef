package com.innovators.fitnesschef;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;


/**
 * A simple {@link Fragment} subclass.
 */
public class DashboardFragment extends Fragment {
    WebView webView;
String g;
    int num1;
    int num2;
    int num3;
    int num4;

    public DashboardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_dashboard, container, false);
        home h=(home)getActivity();
        g=h.get();
        SharedPreferences br = getActivity().getSharedPreferences(g+"breakfast",0);
num1=br.getInt("value",0);
        SharedPreferences lu = getActivity().getSharedPreferences(g+"lunch",0);
        num2=lu.getInt("value",0);
        SharedPreferences di = getActivity().getSharedPreferences(g+"dinner",0);
        num3=di.getInt("value",0);
        SharedPreferences sn = getActivity().getSharedPreferences(g+"snacks",0);
        num4=sn.getInt("value",0);
        webView = (WebView) v.findViewById(R.id.web);
        webView.addJavascriptInterface(new WebAppInterface(), "Android");
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("file:///android_asset/chart.html");
        return v;
    }
    public class WebAppInterface {

        @JavascriptInterface
        public int getNum1() {
            return num1;
        }

        @JavascriptInterface
        public int getNum2() {
            return num2;
        }

        @JavascriptInterface
        public int getNum3() {
            return num3;
        }

        @JavascriptInterface
        public int getNum4() {
            return num4;
        }

    }

}
