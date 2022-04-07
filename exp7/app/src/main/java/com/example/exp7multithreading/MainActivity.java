package com.example.exp7multithreading;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.sql.Time;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    int count = 10;
    Handler hand;
    thr obj;
    private Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.tv);
        hand = new Handler();

        b = (Button)findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                obj = new thr();
                create_thread(tv);
                obj.run();
            } });
    }
    public void create_thread(View view) {
        hand.postDelayed(obj,1000);
        count=10;
    }


    public class thr implements Runnable {
        @Override
        public void run() {
            if(count==0) {
                return;
            }
            else
            {
                hand.postDelayed(obj,1000);
                count--;
                tv.setText(count+"");
                }
        }
        }
}
