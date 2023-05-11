package com.ssh.mystudyapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MySQLiteOpenHelperFriends extends SQLiteOpenHelper {

    public MySQLiteOpenHelperFriends(Context context, String name,
                                     SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        // SQLiteOpenHelper 가 최초 실행 되었을 때

        String sql = "create table friend (" +
                "idx integer primary key autoincrement, " +
                "name text, " +
                "hp text, " +
                "gender text, " +
                "addr text," +
                "age text)";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String sql = "drop table if exists friend";
        db.execSQL(sql);

        onCreate(db); // 테이블을 지웠으므로 다시 테이블을 만들어주는 과정
    }
}
