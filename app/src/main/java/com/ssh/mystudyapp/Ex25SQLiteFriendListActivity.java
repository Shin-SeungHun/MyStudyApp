package com.ssh.mystudyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

public class Ex25SQLiteFriendListActivity extends AppCompatActivity {

    static SQLiteDatabase db;
    static MySQLiteOpenHelperFriends helper;

    static ListView listView = null;
    static Ex25ListViewFriendsAdapter adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex25_sqlite_friend_list);

        helper = new MySQLiteOpenHelperFriends(Ex25SQLiteFriendListActivity.this, "friend.db", null, 1);

        //id연동
        listView = (ListView) findViewById(R.id.listView);

        //버튼 이벤트처리
        findViewById(R.id.btnAdd).setOnClickListener(mClick);
        findViewById(R.id.btnEdit).setOnClickListener(mClick);
        findViewById(R.id.btnDel).setOnClickListener(mClick);


        //초기화면처리 리스트뷰...
        adapter = new Ex25ListViewFriendsAdapter();

        listView.setAdapter(adapter);

        selectFriendList();
    }

    View.OnClickListener mClick = new View.OnClickListener() {
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnAdd:
                    Intent intentAdd = new Intent(Ex25SQLiteFriendListActivity.this, Ex25SQLiteFriendAdd.class);
                    startActivity(intentAdd);
                    finish();
                    break;
                case R.id.btnEdit:
                    Intent intentEdit = new Intent(Ex25SQLiteFriendListActivity.this, Ex25SQLiteEdit.class);
                    startActivity(intentEdit);
                    finish();
                    break;
                case R.id.btnDel:
                    Intent intentDel = new Intent(Ex25SQLiteFriendListActivity.this, Ex25SQLiteDel.class);
                    startActivity(intentDel);
                    finish();
                    break;


            }

        }
    };

    static void setData(String name, String hp, String addr, String sex, int age) {
        adapter.addItem(new Ex25FriendItems(name, hp, sex, addr, age));
        listView.setAdapter(adapter);

    }

    public static void selectFriendList() {
        //초기화 후 다시
        adapter.items.clear();

        db = helper.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM friend", null);


        while (c.moveToNext()) {
            int idx = c.getInt(0);
            String name = c.getString(1);
            String hp = c.getString(2);
            String gender = c.getString(3);
            String addr = c.getString(4);
            String age = c.getString(5);
            adapter.addItem(new Ex25FriendItems(name, hp, gender, addr, Integer.parseInt(age)));
        }
        c.close();
        db.close();
        listView.setAdapter(adapter);
    }

//    static void editData(String name, String hp, String addr, String sex, int age) {
//        adapter.addItem(new Ex25FriendItems(name, hp, sex, addr, age));
//        listView.setAdapter(adapter);
//
//    }
//
//
//    static void getData(String name, String hp, String addr, String sex, int age) {
//        adapter.addItem(new Ex25FriendItems(name, hp, sex, addr, age));
//        listView.getAdapter();
//    }

}