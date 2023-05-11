package com.ssh.mystudyapp;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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


public class Ex19ListViewActivity extends AppCompatActivity {
    private String TAG = "리스트뷰예제";
    private ListView listView = null;
    private ListViewAdapter adapter = null;

    TextView tvName, tvHp;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex19_list_view);

        listView = (ListView) findViewById(R.id.listView);
        adapter = new ListViewAdapter();


        //Adapter 안에 아이템의 정보 담기
        adapter.addItem(new Ex19ListViewListItem("홍길동1", "010-1234-1234", R.drawable.tel));
        adapter.addItem(new Ex19ListViewListItem("홍길동2", "010-1234-1234", R.drawable.tel));
        adapter.addItem(new Ex19ListViewListItem("홍길동3", "010-1234-1234", R.drawable.tel));
        adapter.addItem(new Ex19ListViewListItem("홍길동4", "010-1234-1234", R.drawable.tel));
        adapter.addItem(new Ex19ListViewListItem("홍길동5", "010-1234-1234", R.drawable.tel));
        adapter.addItem(new Ex19ListViewListItem("홍길동6", "010-1234-1234", R.drawable.tel));
        adapter.addItem(new Ex19ListViewListItem("홍길동7", "010-1234-1234", R.drawable.tel));
        adapter.addItem(new Ex19ListViewListItem("홍길동8", "010-1234-1234", R.drawable.tel));

        //리스트뷰에 Adapter 설정
        listView.setAdapter(adapter);
    }


    /* 리스트뷰 어댑터 */
    public class ListViewAdapter extends BaseAdapter {
        ArrayList<Ex19ListViewListItem> items = new ArrayList<Ex19ListViewListItem>();

        @Override
        public int getCount() {
            return items.size();
        }

        public void addItem(Ex19ListViewListItem item) {
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
            final Ex19ListViewListItem phoneBook = items.get(position);

            if (convertView == null) {
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.activity_ex18_list_view_list_item, viewGroup, false);

            } else {
                View view = new View(context);
                view = (View) convertView;
            }

            TextView tvName = (TextView) convertView.findViewById(R.id.tvName);
            TextView tvHp = (TextView) convertView.findViewById(R.id.tvHp);
            ImageView iv_icon = (ImageView) convertView.findViewById(R.id.ivTel);


            tvName.setText(phoneBook.getName());
            tvHp.setText(phoneBook.getHp());
            iv_icon.setImageResource(phoneBook.getResId()); // 저장되어있는 숫자값으로 뿌려준다
            Log.d(TAG, "getView() - [ " + position + " ] " + phoneBook.getName());

            Log.d(TAG, "getView() - [ " + position + " ] " + phoneBook.getName());

            //각 아이템 선택 event
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getApplicationContext(), phoneBook.getName() + "에게 전화를 겁니다!", Toast.LENGTH_SHORT).show();
                    Intent intentTel = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:" + phoneBook.getHp()));
                    startActivity(intentTel);
                }
            });

            return convertView;  //뷰 객체 반환
        }
    }

}