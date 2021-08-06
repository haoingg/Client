package com.example.practice3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView exampleList;
    ArrayList<String> dataSample;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataSample = new ArrayList<String>();

        dataSample.add("Test1");
        dataSample.add("Test2");
        dataSample.add("Test3");
        dataSample.add("Test1");
        dataSample.add("Test2");
        dataSample.add("Test3");
        dataSample.add("Test1");
        dataSample.add("Test2");
        dataSample.add("Test3");
        dataSample.add("Test1");
        dataSample.add("Test2");
        dataSample.add("Test3");
        dataSample.add("Test1");
        dataSample.add("Test2");
        dataSample.add("Test3");
        dataSample.add("Test1");
        dataSample.add("Test2");
        dataSample.add("Test3");
        dataSample.add("Test1");
        dataSample.add("Test2");
        dataSample.add("Test3");

        exampleList = findViewById(R.id.listView);
        ButtonListAdapter buttonListAdapter = new ButtonListAdapter(this, dataSample);

        exampleList.setAdapter(buttonListAdapter);


    }


}