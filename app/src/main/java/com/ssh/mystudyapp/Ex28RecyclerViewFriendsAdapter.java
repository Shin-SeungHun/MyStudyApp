package com.ssh.mystudyapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.collection.CircularArray;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Ex28RecyclerViewFriendsAdapter extends RecyclerView.Adapter<Ex28RecyclerViewFriendsAdapter.ViewHolder> {


    public ArrayList<Ex28FriendItems> items;

    public Ex28RecyclerViewFriendsAdapter(ArrayList<Ex28FriendItems> frienditem) {
        this.items = frienditem;
    }


    //Ex28FriendItems항목으로 생성해서 추가하기...


    public void addItem(Ex28FriendItems item) {
        items.add(item);
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView hp;
        TextView gender;
        TextView addr;
        TextView age;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tvName);
            hp = itemView.findViewById(R.id.tvHp);
            gender = itemView.findViewById(R.id.tvGender);
            addr = itemView.findViewById(R.id.tvAddr);
            age = itemView.findViewById(R.id.tvAge);

        }
    }

    private Ex27RecyclerAdapter.MyRecyclerViewClickListener mListener;

    public void setOnClickListener(Ex27RecyclerAdapter.MyRecyclerViewClickListener listener) {
        this.mListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_ex25_friend_items, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        Ex28FriendItems item = items.get(position);
        holder.name.setText(item.getName());
        holder.hp.setText(item.getHp());
        holder.gender.setText(item.getGender());
        holder.addr.setText(item.getAddr());
        holder.age.setText(item.getAge()+"");
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    public void remove(int position) {
        try {
            items.remove(position);
            notifyDataSetChanged();
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }
}
