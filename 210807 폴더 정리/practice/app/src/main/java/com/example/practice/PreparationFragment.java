package com.example.practice;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;

public class PreparationFragment extends Fragment {
    ListView listView;
    ArrayList<Preparation_Item> items;

    public PreparationFragment() {
    }

    @Override
    public void onCreate(Bundle savedIntstanceState) {
        super.onCreate(savedIntstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_preparation, container, false);
        initItems();
        listView = v.findViewById(R.id.listView);
        Preparation_Adapter mAdatper = new Preparation_Adapter(items);
        listView.setAdapter(mAdatper);
        return v;
    }

    private void initItems() {
        items = new ArrayList<Preparation_Item>();
        TypedArray arrayText = getResources().obtainTypedArray(R.array.restext);
        for (int i = 0; i < arrayText.length(); i++) {

            boolean b = false;
            String s = arrayText.getString(i);

            Preparation_Item item = new Preparation_Item(b, s);
            items.add(item);
        }
        arrayText.recycle();
    }
}