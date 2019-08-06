package com.example.myfirstapllication;
import java.lang.CharSequence;

import android.content.Intent;
import android.media.MediaPlayer;
import android.view.View;
import android.view.View.OnClickListener;
import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class CounterActivity extends Activity {
    Button madd,msubtract;
    TextView mcounter;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.counter);

        madd=findViewById(R.id.add);
        msubtract=findViewById(R.id.subtract);
        mcounter =findViewById(R.id.mycounter);
        mcounter.setText("0");
        madd.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                MediaPlayer ring= MediaPlayer.create(CounterActivity.this,R.raw.one_plus);
                ring.start();
                try{
                 int c= Integer.parseInt(mcounter.getText().toString())+1;

                mcounter.setText(Integer.toString(c));
                }catch (Exception e){
                   System.out.println(e);
               }

            }

        });
        msubtract.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                try{
                    int c= Integer.parseInt(mcounter.getText().toString())-1;
                    if(c>0)
                    mcounter.setText(Integer.toString(c));
                    else
                        mcounter.setText(Integer.toString(0));
                }catch (Exception e){
                    System.out.println(e);
                }

            }

        });
    }
}
