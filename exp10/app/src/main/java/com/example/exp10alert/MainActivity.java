package com.example.exp10alert;

import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AlertDialog.Builder j = new AlertDialog.Builder(this);
        j.setMessage("message received").setTitle("Title");
        AlertDialog k = j.create();
        k.show();
    }
}