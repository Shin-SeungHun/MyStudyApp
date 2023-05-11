package com.ssh.mystudyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class Ex20FriendListActivity extends AppCompatActivity {
    static ListView listView = null;
    static Ex20ListViewFriendsAdapter adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex20_friend_list);
        //id연동
        listView = (ListView) findViewById(R.id.listView);

        //버튼 이벤트처리
        findViewById(R.id.btnAdd).setOnClickListener(mClick);
        findViewById(R.id.btnEdit).setOnClickListener(mClick);
        findViewById(R.id.btnDel).setOnClickListener(mClick);



        //초기화면처리 리스트뷰...
        adapter = new Ex20ListViewFriendsAdapter();

        listView.setAdapter(adapter);
    }

    View.OnClickListener mClick = new View.OnClickListener() {
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnAdd:
                    Intent intentAdd = new Intent(Ex20FriendListActivity.this, Ex20FriendAddActivity.class);
                    startActivity(intentAdd);
                    break;
                case R.id.btnEdit:
                    Intent intentEdit = new Intent(Ex20FriendListActivity.this, Ex20FriendEditActivity.class);
                    startActivity(intentEdit);
                    break;
                case R.id.btnDel:
                    Intent intentDel = new Intent(Ex20FriendListActivity.this, Ex20FriendDelActivity.class);
                    startActivity(intentDel);
                    break;


            }

        }
    };

    static void setData(String name, String hp, String addr, String sex, int age) {
        adapter.addItem(new Ex20FriendItems(name, hp, sex, addr, age));
        listView.setAdapter(adapter);

    }

    static void editData(String name, String hp, String addr, String sex, int age) {
        adapter.addItem(new Ex20FriendItems(name, hp, sex, addr, age));
        listView.setAdapter(adapter);

    }


    static void getData(String name, String hp, String addr, String sex, int age){
        adapter.addItem(new Ex20FriendItems(name, hp, sex, addr, age));
        listView.getAdapter();
    }

}