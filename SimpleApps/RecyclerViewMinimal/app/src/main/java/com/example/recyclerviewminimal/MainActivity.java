package com.example.recyclerviewminimal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<ListEntity>  entitiesList = new ArrayList<>();
    private RecyclerView recyclerView;
    private ListEntityAdapter listAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);

        listAdapter = new ListEntityAdapter(entitiesList);

        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager listLayoutManager = new LinearLayoutManager(getApplicationContext());


        recyclerView.setLayoutManager(listLayoutManager);


        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        recyclerView.setItemAnimator(new DefaultItemAnimator());

        recyclerView.setAdapter(listAdapter);


        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {

            @Override
            public void onClick(View view, int position) {
                ListEntity entity = entitiesList.get(position);
                Toast.makeText(getApplicationContext(), entity.getTitle() + " is selected!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        prepareEntitiesData();

    }

    private void prepareEntitiesData() {
        ListEntity movie = new ListEntity("A", "1");
        entitiesList.add(movie);

        movie = new ListEntity("B", "2");
        entitiesList.add(movie);

        movie = new ListEntity("C", "3");
        entitiesList.add(movie);

        movie = new ListEntity("D", "4");
        entitiesList.add(movie);

        movie = new ListEntity("E", "5");
        entitiesList.add(movie);
        listAdapter.notifyDataSetChanged();
    }
}
