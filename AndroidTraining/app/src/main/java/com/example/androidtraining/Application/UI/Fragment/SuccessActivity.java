package com.example.androidtraining.Application.UI.Fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;


import com.example.androidtraining.Application.UI.Activity.Aunthentication;
import com.example.androidtraining.R;

public class SuccessActivity extends Activity {
    public static final String TagSuccess="Success";
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                Intent mainIntent = new Intent(SuccessActivity.this, Aunthentication.class);
                SuccessActivity.this.startActivity(mainIntent);
                SuccessActivity.this.finish();
            }
        },5000);

    }
}
