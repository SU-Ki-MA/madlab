package com.example.exp9sdcard;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Environment;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b = (Button)findViewById(R.id.saveb);
        final EditText text = (EditText)findViewById(R.id.ftext);
        final EditText fname2 = (EditText)findViewById(R.id.fname);
        b.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Save("" + fname2.getText().toString(),"" + text.getText().toString());
            }
        });
    }private void Save(String sFileName, String sBody) {
        try {
            File root = new File(Environment.getExternalStorageDirectory(), "cse");
            if (!root.exists()) {
                root.mkdirs();
            }
            File textFile = new File(root, sFileName);
            FileWriter writer = new FileWriter(textFile);
            writer.append(sBody);
            writer.flush();
            writer.close();
            Toast.makeText(this.getApplicationContext(), "Saved", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }

        }
}