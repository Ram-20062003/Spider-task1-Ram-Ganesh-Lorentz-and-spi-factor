package com.example.spidertask1;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import java.text.SimpleDateFormat;
import java.util.Date;
public class calcspi extends AppCompatActivity implements View.OnClickListener {
    int k=0;
    int e=0;
    Button bhp,be,mbh,es,rb;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spi);
            be=(Button)findViewById(R.id.exitapp) ;
            mbh=(Button)findViewById(R.id.golorentz);
            rb=(Button)findViewById(R.id.resume);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        spifactor();
        mbh.setOnClickListener(this);
        rb.setOnClickListener(this);
            be.setOnClickListener(this);

    }
    public void spifactor(){

        Thread thread=new Thread(){
            @Override
            public void run() {
                while (!(interrupted())&&e==0){
                    try {

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                getspi();
                            }
                        });
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        };
        thread.start();
    }
    private int factorial(int th) {
        int i,p=1;
        for(i=1;i<=th;i++)
          p=p*i;
        return p;
    }
    public void getspi()
    {  Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss z");
        TextView td = (TextView) findViewById(R.id.textspi);
        String ad = String.valueOf(df.format(date));
        int th, tm, ts;
        th = Integer.parseInt(ad.substring(11, 13));
        tm = Integer.parseInt(ad.substring(14, 16));
        ts = Integer.parseInt(ad.substring(17, 19));
        if (th > 12)
            th = th - 12;
        if (th == 0)
            th = 12;
        int f = factorial(th);
        double s;
        s = (double) f / ((tm * tm * tm) + ts);
        td.setText(String.valueOf(s));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.golorentz:
                e=1;
                rb.setVisibility(v.VISIBLE);
                break;
            case R.id.resume:
                 e=0;
                 rb.setVisibility(v.INVISIBLE);
                 spifactor();
                 break;
            case R.id.exitapp:
                Intent intent=new Intent(calcspi.this,homejava.class);
                startActivity(intent);
        }
    }
}
