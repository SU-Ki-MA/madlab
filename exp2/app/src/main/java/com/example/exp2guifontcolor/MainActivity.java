package com.example.exp2guifontcolor;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private TextView t;
    private Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b = (Button)findViewById(R.id.button);
        t = (TextView) findViewById(R.id.textView);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t.setTextColor(Color.RED);
            } });
    }
}