package com.example.switchbutton;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class Fragments extends Fragment {
    ListView listView;
    ArrayList<ListToItem> items;

    public Fragments() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_contents, container, false);
        initItems();
        listView = v.findViewById(R.id.listview);
        customAdapter mAdapter = new customAdapter(items);
        listView.setAdapter(mAdapter);
        return v;
    }

    private void initItems() {
        items = new ArrayList<ListToItem>();
        TypedArray arrayText = getResources().obtainTypedArray(R.array.restext);
        for (int i = 0; i < arrayText.length(); i++) {
            String s = arrayText.getString(i);
            boolean b = false;
            ListToItem item = new ListToItem(b, s);
            items.add(item);
        }
        arrayText.recycle();
    }

}