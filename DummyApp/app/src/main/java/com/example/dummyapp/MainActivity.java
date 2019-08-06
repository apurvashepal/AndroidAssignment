package com.example.dummyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageButton star;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        star=findViewById(R.id.Click);
        star.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent= new Intent(this,RecyclerViewActivity.class);
        startActivity(intent);
    }
}
