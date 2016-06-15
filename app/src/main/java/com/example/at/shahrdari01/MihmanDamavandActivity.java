package com.example.at.shahrdari01;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MihmanDamavandActivity extends AppCompatActivity {

   // String[] strList = getIntent().getStringArrayExtra("strList");
    String strTitle = null;
    String strTitlecolor = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_mihman_damavand);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        Intent intent = getIntent();

        String[] strList = intent.getStringArrayExtra("strList");

        strTitle = intent.getStringExtra("strTitle");
        strTitlecolor = intent.getStringExtra("strActionbar_color");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.activity_listview, strList);

        ListView listView = (ListView) findViewById(R.id.list_view);

        listView.setAdapter(adapter);

        toolbar.setBackgroundColor(Color.parseColor(strTitlecolor));

        setTitle(strTitle);

    }

}
