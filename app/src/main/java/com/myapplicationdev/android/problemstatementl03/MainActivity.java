package com.myapplicationdev.android.problemstatementl03;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listViewModules;
    ArrayAdapter<String> aaModules;
    ArrayList<String> alModules = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        setTitle("P03 Class Journal");

        listViewModules = findViewById(R.id.moduleList);

        alModules.add("C347");
        alModules.add("C302");

        aaModules = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, alModules);
        listViewModules.setAdapter(aaModules);

        listViewModules.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getBaseContext(),activity_second.class);
                intent.putExtra("position",position);
                startActivity(intent);
            }
        });

    }
}
