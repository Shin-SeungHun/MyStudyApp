package com.ssh.mystudyapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Ex8WebViewActivity extends AppCompatActivity {

    WebView webView;
    EditText etUrl;

    String[] urlItems = {"네이버", "다음", "유튜브", "구글"};
    //urlItems의 실제 url주소가 들어가는곳
    String urlGo[] = {
            "http://naver.com", "http://daum.net",
            "http://youtube.co.kr", "http://google.co.kr"
    };
    int urlIdx = 0; //스피너 선택 포지션
    TextView tvSite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex8_web_view);
        //id연동
        etUrl = (EditText) findViewById(R.id.etUrl);
        tvSite = (TextView) findViewById(R.id.tvSite);
        webView = (WebView) findViewById(R.id.webView);


        //웹뷰 옵션 설정하기. ==========================================
        webView.setWebViewClient(new WebViewClient());  // 새 창 띄우기 않기
        webView.setWebChromeClient(new WebChromeClient());

        webView.getSettings().setJavaScriptEnabled(true); // 자바스크립트 사용여부
        webView.loadUrl("https://naver.com");

        //웹뷰 ==========================================
        //스피너 처리...............////////////////////////
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, urlItems
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // 스피너에 어댑터 설정
        spinner.setAdapter(adapter);
        // 스피너에서 선택 했을 경우 이벤트 처리
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tvSite.setText(urlItems[position]);
                urlIdx = position;//선택한 url의 idx값 넣기...
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                tvSite.setText("미선택..");
            }
        });
        //스피너 처리...............////////////////////////

        //버튼이벤트
        findViewById(R.id.btnGo).setOnClickListener(mClickListener);
        findViewById(R.id.btnGo2).setOnClickListener(mClickListener);
    }

    Button.OnClickListener mClickListener = new Button.OnClickListener() {
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnGo:
                    String url = etUrl.getText().toString();
                    webView.loadUrl("https://" + url);
                    break;
                case R.id.btnGo2:
                    webView.loadUrl(urlGo[urlIdx]);
                    break;
            }
        }
    };
}