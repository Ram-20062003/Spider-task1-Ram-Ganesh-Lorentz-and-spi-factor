package com.example.spidertask1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class homejava extends AppCompatActivity implements AdapterView.OnItemClickListener {
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        ListView listView=(ListView) findViewById(R.id.lists);
        ArrayList<String> arrayList=new ArrayList<String>(3);
        arrayList.add("\t \t \t 1)Lorentz-factor");
        arrayList.add("\t \t \t 2)Spi-factor");
        arrayList.add("\t \t \t 3)Exit");
        ArrayAdapter adapter=new ArrayAdapter(this, R.layout.listitemsshow,arrayList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if(position==0)
        {
            Intent intent=new Intent(homejava.this,MainActivity.class);
            startActivity(intent);
        }
        if(position==1)
        {
            Intent intent1=new Intent(homejava.this,calcspi.class);
            startActivity(intent1);
        }
        if(position==2)
            System.exit(0);
    }
}
