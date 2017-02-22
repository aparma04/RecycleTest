package com.anirudhparmar.recycletest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //recycler view objects
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<Buisness> listItems;
    private LinearLayoutManager mLinearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mLinearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLinearLayoutManager);

        listItems = new ArrayList<>();

        for (int i=0;i<10;i++){
            Buisness listItem = new Buisness ("Buisness"+ i+1,"Address");

            listItems.add(listItem);
        }


        adapter = new MyAdapter(listItems, this);
        recyclerView.setAdapter(adapter);


    }
}
