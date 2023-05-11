package com.ssh.mystudyapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn1).setOnClickListener(mClickListener);
        findViewById(R.id.btn2).setOnClickListener(mClickListener);
        findViewById(R.id.btn3).setOnClickListener(mClickListener);
        findViewById(R.id.btn4).setOnClickListener(mClickListener);
        findViewById(R.id.btn5).setOnClickListener(mClickListener);
        findViewById(R.id.btn6).setOnClickListener(mClickListener);
        findViewById(R.id.btn7).setOnClickListener(mClickListener);
        findViewById(R.id.btn8).setOnClickListener(mClickListener);
        findViewById(R.id.btn9).setOnClickListener(mClickListener);
        findViewById(R.id.btn10).setOnClickListener(mClickListener);
        findViewById(R.id.btn11).setOnClickListener(mClickListener);
        findViewById(R.id.btn12).setOnClickListener(mClickListener);
        findViewById(R.id.btn13).setOnClickListener(mClickListener);
        findViewById(R.id.btn14).setOnClickListener(mClickListener);
        findViewById(R.id.btn15).setOnClickListener(mClickListener);
        findViewById(R.id.btn16).setOnClickListener(mClickListener);
        findViewById(R.id.btn17).setOnClickListener(mClickListener);
        findViewById(R.id.btn18).setOnClickListener(mClickListener);
        findViewById(R.id.btn19).setOnClickListener(mClickListener);
        findViewById(R.id.btn20).setOnClickListener(mClickListener);
        findViewById(R.id.btn21).setOnClickListener(mClickListener);
        findViewById(R.id.btn22).setOnClickListener(mClickListener);
        findViewById(R.id.btn23).setOnClickListener(mClickListener);
        findViewById(R.id.btn24).setOnClickListener(mClickListener);
        findViewById(R.id.btn25).setOnClickListener(mClickListener);
        findViewById(R.id.btn26).setOnClickListener(mClickListener);
        findViewById(R.id.btn27).setOnClickListener(mClickListener);
        findViewById(R.id.btn28).setOnClickListener(mClickListener);
        findViewById(R.id.btn29).setOnClickListener(mClickListener);
        findViewById(R.id.btn30).setOnClickListener(mClickListener);
        findViewById(R.id.btn31).setOnClickListener(mClickListener);
        findViewById(R.id.btn32).setOnClickListener(mClickListener);
        findViewById(R.id.btn33).setOnClickListener(mClickListener);
        findViewById(R.id.btn34).setOnClickListener(mClickListener);

    }

    //버튼이벤트를 감지함...
    Button.OnClickListener mClickListener = new Button.OnClickListener() {
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn1:
                    Intent intent1 = new Intent(MainActivity.this, Ex1LoginActivity.class);
                    startActivity(intent1);
                    break;

                case R.id.btn2:
                    Intent intent2 = new Intent(MainActivity.this, Ex2CalcActivity.class);
                    startActivity(intent2);
                    break;

                case R.id.btn3:
                    Intent intent3 = new Intent(MainActivity.this, Ex3AniActivity.class);
                    startActivity(intent3);
                    break;

                case R.id.btn4:
                    Intent intent4 = new Intent(MainActivity.this, Ex4GifActivity.class);
                    startActivity(intent4);
                    break;

                case R.id.btn5:
                    Intent intent5 = new Intent(MainActivity.this, Ex5DataActivity.class);
                    startActivity(intent5);
                    break;

                case R.id.btn6:
                    Intent intent6 = new Intent(MainActivity.this, Ex6SpinnerActivity.class);
                    startActivity(intent6);
                    break;

                case R.id.btn7:
                    Intent intent7 = new Intent(MainActivity.this, Ex7SwitchActivity.class);
                    startActivity(intent7);
                    break;

                case R.id.btn8:
                    Intent intent8 = new Intent(MainActivity.this, Ex8WebViewActivity.class);
                    startActivity(intent8);
                    break;

                case R.id.btn9:
                    Intent intent9 = new Intent(MainActivity.this, Ex9VideoViewActivity.class);
                    startActivity(intent9);
                    break;

                case R.id.btn10:
                    Intent intent10 = new Intent(MainActivity.this, Ex10MediaPlayerActivity.class);
                    startActivity(intent10);
                    break;
                case R.id.btn11:
                    Intent intent11 = new Intent(MainActivity.this, Ex11GalleryViewActivity.class);
                    startActivity(intent11);
                    break;

                case R.id.btn12:
                    Intent intent12 = new Intent(MainActivity.this, Ex12SoccerGame.class);
                    startActivity(intent12);
                    break;
                case R.id.btn13:
                    Intent intent13 = new Intent(MainActivity.this, Ex13HandlerActivity.class);
                    startActivity(intent13);
                    break;
                case R.id.btn14:
                    Intent intent14 = new Intent(MainActivity.this, Ex14SharedPreferencesActivity.class);
                    startActivity(intent14);
                    break;
                case R.id.btn15:
                    Intent intent15 = new Intent(MainActivity.this, Ex15SharedPreferences2Activity.class);
                    startActivity(intent15);
                    break;
                case R.id.btn16:
                    Intent intent16 = new Intent(MainActivity.this, Ex16FrameLayoutActivity.class);
                    startActivity(intent16);
                    break;
                case R.id.btn17:
                    Intent intent17 = new Intent(MainActivity.this, Ex17PhoneCreateActivity.class);
                    startActivity(intent17);
                    break;
                case R.id.btn18:
                    Intent intent18 = new Intent(MainActivity.this, Ex18ListViewActivity.class);
                    startActivity(intent18);
                    break;
                case R.id.btn19:
                    Intent intent19 = new Intent(MainActivity.this, Ex19ListViewActivity.class);
                    startActivity(intent19);
                    break;
                case R.id.btn20:
                    Intent intent20 = new Intent(MainActivity.this, Ex20FriendListActivity.class);
                    startActivity(intent20);
                    break;
                case R.id.btn21:
                    Intent intent21 = new Intent(MainActivity.this, Ex21GpsMapEx.class);
                    startActivity(intent21);
                    break;
                case R.id.btn22:
                    Intent intent22 = new Intent(MainActivity.this, Ex22DDayActivity.class);
                    startActivity(intent22);
                    break;
                case R.id.btn23:
                    Intent intent23 = new Intent(MainActivity.this, Ex23TimerEx.class);
                    startActivity(intent23);
                    break;
                case R.id.btn24:
                    Intent intent24 = new Intent(MainActivity.this, Ex24SQLiteLoginActivity.class);
                    startActivity(intent24);
                    break;
                case R.id.btn25:
                    Intent intent25 = new Intent(MainActivity.this, Ex25SQLiteFriendListActivity.class);
                    startActivity(intent25);
                    break;
                case R.id.btn26:
                    Intent intent26 = new Intent(MainActivity.this, Ex26RecyclerViewEx.class);
                    startActivity(intent26);
                    break;
                case R.id.btn27:
                    Intent intent27 = new Intent(MainActivity.this, Ex27RecyclerViewEx2.class);
                    startActivity(intent27);
                    break;
                case R.id.btn28:
                    Intent intent28 = new Intent(MainActivity.this, Ex28RecyclerViewFriendList.class);
                    startActivity(intent28);
                    break;
                case R.id.btn29:
                    Intent intent29 = new Intent(MainActivity.this, Ex29FragmentLayout.class);
                    startActivity(intent29);
                    break;
                case R.id.btn30:
                    Intent intent30 = new Intent(MainActivity.this, Ex30Viewpager2Ex.class);
                    startActivity(intent30);
                    break;
                case R.id.btn31:
                    Intent intent31 = new Intent(MainActivity.this, Ex31ImageLayoutEx.class);
                    startActivity(intent31);
                    break;
                case R.id.btn32:
                    Intent intent32 = new Intent(MainActivity.this, Ex32webPhpLogin.class);
                    startActivity(intent32);
                    break;
                case R.id.btn33:
                    Intent intent33 = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(intent33);
                    break;
                case R.id.btn34:
                    Intent intent34 = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(intent34);
                    break;
            }
        }
    };
}