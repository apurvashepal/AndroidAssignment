package com.example.androidtraining.Application.UI.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidtraining.Application.UI.Activity.Item;
import com.example.androidtraining.Application.UI.Activity.Utils;

import com.example.androidtraining.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity implements IValueEntered {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyler);

        RecyclerView itemsList = findViewById(R.id.recyclerView);
        ItemsAdapter itemsAdapter = new ItemsAdapter(this, getItemsList());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        itemsAdapter.setValueEnteredListner(this);
        itemsList.setLayoutManager(layoutManager);
        itemsList.setAdapter(itemsAdapter);

        itemsAdapter.notifyDataSetChanged();

    }

    private List<Item> getItemsList() {
        List<Item> itemList = new ArrayList<>();
        Item item;

        item = new Item();
        item.setName("Apurva Shepal");
        item.setInformation("Android Dev");
        item.setImage(R.drawable.star);
        itemList.add(item);

        item = new Item();
        item.setName("Surbhi T");
        item.setInformation("java Dev");
        item.setImage(R.drawable.star);
        itemList.add(item);


        item = new Item();
        item.setName("Prajakta K");
        item.setInformation("Fullstack Dev");
        item.setImage(R.drawable.star);
        itemList.add(item);

        item = new Item();
        item.setName("Sarvesh R");
        item.setInformation("Android Dev");
        item.setImage(R.drawable.star);
        itemList.add(item);



        item = new Item();
        item.setName("Samruddhi G");
        item.setInformation("React Dev");
        item.setImage(R.drawable.star);
        itemList.add(item);

        item = new Item();
        item.setName("Harshita P");
        item.setInformation("QA");
        item.setImage(R.drawable.star);
        itemList.add(item);



        return itemList;

    }

    @Override
    public void onTitleClicked(String text) {
        Toast.makeText(this, "You have entered :" + text, Toast.LENGTH_SHORT).show();
        Utils.AlertBox(this,"You entered" , text);
    }
}
