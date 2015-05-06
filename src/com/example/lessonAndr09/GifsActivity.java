package com.example.lessonAndr09;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class GifsActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.gif_urls);

        Intent intent = getIntent();

        ArrayList<String> gifsUrls = intent.getStringArrayListExtra("gifs");


        ListView gifsList = (ListView) findViewById(R.id.gifs_list);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, gifsUrls);

        gifsList.setAdapter(adapter);
    }
}