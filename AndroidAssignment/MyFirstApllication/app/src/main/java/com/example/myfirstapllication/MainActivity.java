package com.example.myfirstapllication;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.content.Context;

public class MainActivity extends AppCompatActivity {
    EditText musername,mpassword;
    Button mlogIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        musername = findViewById(R.id.username);
        mpassword = findViewById(R.id.password);
        mlogIn = findViewById(R.id.btn_login);
        addListenerOnButton();
    }
    public void addListenerOnButton(){
        final Context context = this;
        mlogIn.setOnClickListener(new OnClickListener()
         {
            @Override
            public void onClick(View arg) {
                if(musername.toString()=="Apurva" && mpassword.toString()=="apurva")
                { Intent intent = new Intent(context,CounterActivity.class);
                    startActivity(intent);
                }
                else
                {
                    Intent intent = new Intent(context,CounterActivity.class);
                    startActivity(intent);
                }


            }

    });
   }

}