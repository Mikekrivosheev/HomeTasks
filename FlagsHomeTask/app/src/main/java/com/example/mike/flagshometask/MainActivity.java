package com.example.mike.flagshometask;

import android.app.ActionBar;
import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;


public class MainActivity extends Activity {

    private android.os.Handler handler;

    private int change = 0;

    private LinearLayout mainL;
    private LinearLayout ll1;
    private LinearLayout ll2;
    private LinearLayout ll3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        handler = new android.os.Handler();

        mainL = (LinearLayout)findViewById(R.id.mainL);
        ll1 = (LinearLayout)findViewById(R.id.first);
        ll2 = (LinearLayout)findViewById(R.id.second);
        ll3 = (LinearLayout)findViewById(R.id.third);

    }

    @Override
    protected void onResume() {
        super.onResume();

        handler.postDelayed(timerRunnable, 5000);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("Message", "OnStop");

        handler.removeCallbacks(timerRunnable);
    }

    private Runnable timerRunnable = new Runnable() {
        @Override
        public void run() {
            if (change == 0) {
                ll1.setVisibility(View.GONE);
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0, 60);
                ll2.setLayoutParams(lp);
                ll3.setLayoutParams(lp);
                change++;
            }else if(change == 1){
                mainL.setOrientation(LinearLayout.HORIZONTAL);
                ll1.setVisibility(View.VISIBLE);
                ll1.setBackgroundColor(0xFF1BAB4C);
                ll1.setOrientation(LinearLayout.HORIZONTAL);
                ll2.setOrientation(LinearLayout.HORIZONTAL);
                ll3.setOrientation(LinearLayout.HORIZONTAL);
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 40);
                ll1.setLayoutParams(lp);
                ll2.setLayoutParams(lp);
                ll3.setLayoutParams(lp);
                change++;
            }else if (change == 2){
                mainL.setOrientation(LinearLayout.VERTICAL);
                ll1.setOrientation(LinearLayout.VERTICAL);
                ll2.setOrientation(LinearLayout.VERTICAL);
                ll3.setOrientation(LinearLayout.VERTICAL);
                ll1.setBackgroundColor(0xFFECE916);
                ll2.setBackgroundColor(0xFF1811CB);
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0, 60);
                LinearLayout.LayoutParams lp2 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0, 30);
                ll1.setLayoutParams(lp);
                ll2.setLayoutParams(lp2);
                ll3.setLayoutParams(lp2);

            }
            handler.postDelayed(timerRunnable, 5000);

        }
    };
}
