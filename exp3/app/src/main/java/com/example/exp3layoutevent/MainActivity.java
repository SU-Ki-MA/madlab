package com.example.exp3layoutevent;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button b1,b2,b3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.button2);
        b2=(Button)findViewById(R.id.button3);
        b3 = (Button) findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView txtView = (TextView) findViewById(R.id.textView);
                txtView.setTextSize(15);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView txtView = (TextView) findViewById(R.id.textView);
                txtView.setTextSize(55);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView hello = (TextView) findViewById(R.id.textView);
                hello.setTextSize(25);
            }
        });
    }
}