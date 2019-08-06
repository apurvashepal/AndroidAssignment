package com.example.application2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button mbuttonRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mbuttonRegister = findViewById(R.id.btn_Register);
        addListenerOnButton();

    }

    private void addListenerOnButton() {
        final Context context = this;
        mbuttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg) {
                Intent intent = new Intent(context, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}