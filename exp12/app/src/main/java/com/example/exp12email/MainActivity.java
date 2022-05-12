package com.example.exp12email;

import androidx.appcompat.app.AppCompatActivity;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.view.View;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void composeEmail(View v){
        Intent emailIntent= new Intent(Intent.ACTION_SENDTO,Uri.parse("mailto:"+"abc@abc.com"+"?cc=abcd@abcd.com"+"&subject=watch-anime"+"&body=https://youtu.be/SiWvC90fh4c"));
        startActivity(Intent.createChooser(emailIntent,"Select the app to use :"));
    }
}