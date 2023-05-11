package com.ssh.mystudyapp;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Ex28RecyclerViewFriendList extends AppCompatActivity {

    static SQLiteDatabase db;
    static MySQLiteOpenHelperFriends2 helper;

    static RecyclerView recyclerView = null;

    static ArrayList<Ex28FriendItems> list = new ArrayList<>();
    static final Ex28RecyclerViewFriendsAdapter adapter = new Ex28RecyclerViewFriendsAdapter(list);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex28_recyclerview_friend_list);

        helper = new MySQLiteOpenHelperFriends2(Ex28RecyclerViewFriendList.this, "friend.db", null, 1);

        //id연동
        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        //--- LayoutManager는 아래 3가지중 하나를 선택하여 사용 ---
        // 1) LinearLayoutManager()
        // 2) GridLayoutManager()
        // 3) StaggeredGridLayoutManager()
        //---------------------------------------------------------
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager((Context) this);
        recyclerView.setLayoutManager(linearLayoutManager);  // LayoutManager 설정



        //버튼 이벤트처리
        findViewById(R.id.btnAdd).setOnClickListener(mClick);
        findViewById(R.id.btnEdit).setOnClickListener(mClick);
        findViewById(R.id.btnDel).setOnClickListener(mClick);


        //초기화면처리 리스트뷰...
//        adapter = new Ex28RecyclerViewFriendsAdapter();

        recyclerView.setAdapter(adapter);


        selectFriendList();
    }

    View.OnClickListener mClick = new View.OnClickListener() {
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnAdd:
                    Intent intentAdd = new Intent(Ex28RecyclerViewFriendList.this, Ex28RecyclerViewFriendAdd.class);
                    startActivity(intentAdd);
                    finish();
                    break;
                case R.id.btnEdit:
                    Intent intentEdit = new Intent(Ex28RecyclerViewFriendList.this, Ex28RecyclerViewFriendEdit.class);
                    startActivity(intentEdit);
                    finish();
                    break;
                case R.id.btnDel:
                    Intent intentDel = new Intent(Ex28RecyclerViewFriendList.this, Ex28RecyclerViewFriendDel.class);
                    startActivity(intentDel);
                    finish();
                    break;


            }

        }
    };

    static void setData(String name, String hp, String addr, String sex, int age) {
        adapter.addItem(new Ex28FriendItems(name, hp, sex, addr, age));
        recyclerView.setAdapter(adapter);

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
            adapter.addItem(new Ex28FriendItems(name, hp, gender, addr, Integer.parseInt(age)));
        }
        c.close();
        db.close();

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




    public void onItemLongClicked(int position) {
        adapter.remove(position);
        Toast.makeText(getApplicationContext(),
                list.get(position).getName() + " is removed", Toast.LENGTH_SHORT).show();
    }

}