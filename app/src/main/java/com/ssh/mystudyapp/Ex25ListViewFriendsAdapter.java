package com.ssh.mystudyapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Ex25ListViewFriendsAdapter extends BaseAdapter {
    ArrayList<Ex25FriendItems> items = new ArrayList<Ex25FriendItems>();

    //Ex25FriendItems항목으로 생성해서 추가하기...

    @Override
    public int getCount() {
        return items.size();
    }

    public void addItem(Ex25FriendItems item) {
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
    public View getView(int position, View convertView, ViewGroup parent) {
        final Context context = parent.getContext();
        final Ex25FriendItems friendsItem = items.get(position);

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.activity_ex25_friend_items, parent, false);

        } else {
            View view = new View(context);
            view = (View) convertView;

        }

        TextView tvName = (TextView) convertView.findViewById(R.id.tvName);
        TextView tvHp = (TextView) convertView.findViewById(R.id.tvHp);
        TextView tvAddr = (TextView) convertView.findViewById(R.id.tvAddr);
        TextView tvGender = (TextView) convertView.findViewById(R.id.tvGender);
        TextView tvAge = (TextView) convertView.findViewById(R.id.tvAge);

        tvName.setText(friendsItem.getName());
        tvHp.setText(friendsItem.getHp());
        tvAddr.setText(friendsItem.getAddress());
        tvGender.setText(friendsItem.getGender());
        tvAge.setText(friendsItem.getAge() + "");

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


        return convertView;
    }
}
