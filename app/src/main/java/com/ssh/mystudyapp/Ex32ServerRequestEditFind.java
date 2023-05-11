package com.ssh.mystudyapp;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class Ex32ServerRequestEditFind extends StringRequest {
    // 서버 URL 설정 ( PHP 파일 연동 )


    final static private String URL = "http://tmdgns.dothome.co.kr/test/edit_find.php";
    private Map<String, String> map;


    public Ex32ServerRequestEditFind(String findId, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);
        map = new HashMap<>();
        map.put("findId",findId);

    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}
