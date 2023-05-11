package com.ssh.mystudyapp;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class Ex29FragmentLayout extends AppCompatActivity {

    private FragmentManager fragmentManager;
    private Ex29AFragment fragmentA;
    private Ex29BFragment fragmentB;
    private FragmentTransaction transaction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex29_fragment);

        fragmentManager = getSupportFragmentManager();

        fragmentA = new Ex29AFragment();
        fragmentB = new Ex29BFragment();

        transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frameLayout, fragmentA).commitAllowingStateLoss();

        findViewById(R.id.btn_fragmentA).setOnClickListener(mClick);
        findViewById(R.id.btn_fragmentB).setOnClickListener(mClick);
    }
    View.OnClickListener mClick = new View.OnClickListener()
    {
        public void onClick(View v)
        {
            transaction = fragmentManager.beginTransaction();

            switch(v.getId())
            {
                case R.id.btn_fragmentA:
                    transaction.replace(R.id.frameLayout, fragmentA).commitAllowingStateLoss();
                    break;
                case R.id.btn_fragmentB:
                    transaction.replace(R.id.frameLayout, fragmentB).commitAllowingStateLoss();
                    break;
            }

        }
    };


}