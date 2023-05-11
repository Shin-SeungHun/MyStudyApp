package com.ssh.mystudyapp;


import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class Ex18ListViewActivity extends AppCompatActivity {
    private String TAG = "리스트뷰예제";
    private ListView listview = null;
    private ListViewAdapter adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex18_list_view);

        listview = (ListView) findViewById(R.id.listview);
        adapter = new ListViewAdapter();

        //Adapter 안에 아이템의 정보 담기
        adapter.addItem(new Ex18BearItem("1", "곰돌이", R.drawable.b1));
        adapter.addItem(new Ex18BearItem("2", "흰돌이", R.drawable.b2));
        adapter.addItem(new Ex18BearItem("3", "이쁜이", R.drawable.b3));
        adapter.addItem(new Ex18BearItem("4", "하양이", R.drawable.b4));
        adapter.addItem(new Ex18BearItem("5", "갈색이", R.drawable.b5));
        adapter.addItem(new Ex18BearItem("6", "어깨깡", R.drawable.b6));
        adapter.addItem(new Ex18BearItem("7", "어깡이", R.drawable.b7));
        adapter.addItem(new Ex18BearItem("8", "귀요미", R.drawable.b8));

        //리스트뷰에 Adapter 설정
        listview.setAdapter(adapter);
    }


    /* 리스트뷰 어댑터 */
    public class ListViewAdapter extends BaseAdapter {
        ArrayList<Ex18BearItem> items = new ArrayList<Ex18BearItem>();

        @Override
        public int getCount() {
            return items.size();
        }

        public void addItem(Ex18BearItem item) {
            items.add(item);
        }

        @Override
        public Object getItem(int position) {
            return items.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup viewGroup) {
            final Context context = viewGroup.getContext();
            final Ex18BearItem bearItem = items.get(position);

            if (convertView == null) {
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.activity_ex18_listview_list_item, viewGroup, false);

            } else {
                View view = new View(context);
                view = (View) convertView;
            }

            TextView tv_num = (TextView) convertView.findViewById(R.id.tv_num);
            TextView tv_name = (TextView) convertView.findViewById(R.id.tv_name);
            ImageView iv_icon = (ImageView) convertView.findViewById(R.id.iv_icon);

            tv_num.setText(bearItem.getNum());
            tv_name.setText(bearItem.getName());
            iv_icon.setImageResource(bearItem.getResId());
            Log.d(TAG, "getView() - [ " + position + " ] " + bearItem.getName());

            //각 아이템 선택 event
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, bearItem.getNum() + " 번 - " + bearItem.getName() + " 입니당! ", Toast.LENGTH_SHORT).show();
                }
            });

            return convertView;  //뷰 객체 반환
        }
    }

}