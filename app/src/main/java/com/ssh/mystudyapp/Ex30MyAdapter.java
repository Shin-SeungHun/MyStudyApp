package com.ssh.mystudyapp;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class Ex30MyAdapter extends FragmentStateAdapter {

    public int mCount;

    public Ex30MyAdapter(FragmentActivity fa, int count) {
        super(fa);
        mCount = count;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        int index = getRealPosition(position);

        if(index==0) return new Ex30Fragment_1();
        else if(index==1) return new Ex30Fragment_2();
        else if(index==2) return new Ex30Fragment_3();
        else return new Ex30Fragment_4();
    }

    @Override
    public int getItemCount() {
        return 2000;
    }

    public int getRealPosition(int position) { return position % mCount; }

}