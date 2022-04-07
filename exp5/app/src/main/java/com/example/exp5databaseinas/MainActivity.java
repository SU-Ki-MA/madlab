package com.example.exp5databaseinas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.RequiresApi;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> listData;
    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final DB db = new DB(getApplicationContext());
        ListView listView = findViewById(R.id.listview);
        final EditText name = findViewById(R.id.name);
        Button save = findViewById(R.id.button);
        listData = db.getData();
        final ArrayAdapter adapter = new
                ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,listData);
        listView.setAdapter(adapter);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value = name.getText().toString();
                if(db.setData(value)){
                    Toast.makeText(MainActivity.this,"Success !!!",Toast.LENGTH_LONG).show();
                    listData.clear();
                    listData.addAll(db.getData());
                    adapter.notifyDataSetChanged();
                    name.setText("");
                }
                else {
                    Toast.makeText(MainActivity.this,"Failure !!!",Toast.LENGTH_LONG).show();
                    name.setText("");
                }
            }
        });
    }
}