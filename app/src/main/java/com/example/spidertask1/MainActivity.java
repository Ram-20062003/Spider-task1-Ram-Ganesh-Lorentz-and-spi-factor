package com.example.spidertask1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.TimeZone;

public class MainActivity extends AppCompatActivity {
    double y,y1;
    EditText v;
    String a;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        TextView ans=findViewById(R.id.answer);
        Button b=(Button) findViewById(R.id.button);
        TextView t=(TextView) findViewById(R.id.textView3);
        t.setText("Need Practice Don't Worry\n \t\t\t\t\t\t\t\t\t CLICK HERE");
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v=(EditText) findViewById(R.id.input);
                    a= ((EditText) v).getText().toString();
                    y= Double.parseDouble(a);
                    ans.setText("");
                if(y>=300000000)
                    Toast.makeText(MainActivity.this,"Enter correct value",Toast.LENGTH_SHORT).show();
                else
                {
                    double d=Math.sqrt((1-y/300000000));
                    y1=1/d;
                    ans.setText(String.valueOf(y1));
                    ((EditText) v).setText("");
                }
            }
        });

        Button bp=(Button) findViewById(R.id.practice);
        bp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent i=new Intent(MainActivity.this, practicesession.class);
               startActivity(i);
            }
        });

    }
}