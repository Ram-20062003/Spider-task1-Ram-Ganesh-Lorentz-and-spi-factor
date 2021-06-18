package com.example.spidertask1;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.icu.number.Precision;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
    public class practicesession extends AppCompatActivity {
        EditText val,ans;
        String a,b;
        double y,x,y1,ry1;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.practice_screen);
            execute();
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
           }
        public void execute(){
            RelativeLayout l= (RelativeLayout) findViewById(R.id.second);
            Button bc=(Button)findViewById(R.id.button);
            bc.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Vibrator w=(Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    TextView t=(TextView) findViewById(R.id.correctans);
                    val=(EditText) findViewById(R.id.input);
                    ans=(EditText) findViewById(R.id.lorentz);
                    a= ((EditText) val).getText().toString();
                    b= ((EditText) ans).getText().toString();
                    l.setBackgroundColor(Color.WHITE);
                    y=Double.parseDouble(a);
                    x=Double.parseDouble(b);
                    if(y>=300000000)
                        Toast.makeText(practicesession.this,"Enter correct value",Toast.LENGTH_SHORT).show();
                    else
                    {
                        double d=Math.sqrt((1-y/300000000));
                        y1=1/d;
                    }
                    double j=Math.round((y1*10000));
                    j=j/10000;
                    if(j==x)
                    {
                        t.setText("Result:\n\t\t\t\t\tYour Answer is correct!!!");
                        Toast.makeText(practicesession.this,"Correct",Toast.LENGTH_SHORT).show();
                        l.setBackgroundColor(Color.rgb(10, 245, 139));
                    }
                    else{
                        Toast.makeText(practicesession.this,"Sorry!! You went wrong",Toast.LENGTH_LONG).show();
                        l.setBackgroundColor(Color.RED);
                        w.vibrate(400);
                        t.setText("Correct Answer:" +String.valueOf(y1));
                    }
                    Handler file=new Handler();
                    file.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            l.setBackgroundColor(Color.WHITE);
                            val.setText("");
                            ans.setText("");
                        }
                    },1000);
                }
            });
        }
}
