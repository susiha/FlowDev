package com.susiha.flowdev;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Toolbar toolbar;
    LinearLayoutManager linearLayoutManager;
    GridLayoutManager gridLayoutManager;
    StaggeredGridLayoutManager staggeredGridLayoutManager;

    RecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        recyclerView = findViewById(R.id.recyclerview);

        linearLayoutManager =  new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,true);
        gridLayoutManager = new GridLayoutManager(this,3,LinearLayoutManager.VERTICAL,false);

        staggeredGridLayoutManager = new StaggeredGridLayoutManager(3,LinearLayoutManager.VERTICAL);

        adapter = new RecyclerViewAdapter(getData(),this);

        adapter.addOnItemClickLinstener(new OnRecycleViewItemClickListener() {
            @Override
            public void onItemClick(View view,String label, int position) {
                Toast.makeText(getApplicationContext(),label+"",Toast.LENGTH_LONG).show();
            }
        });
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(linearLayoutManager);


    }
    private ArrayList<String> getData(){
        ArrayList<String>  data = new ArrayList<>();
        data.add("App Basic");
        data.add("Best Pratices");
        data.add("Core Topic");
        data.add("Devices");
        return data;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {


        getMenuInflater().inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.linear_ver:
                recyclerView.setLayoutManager(linearLayoutManager);
                break;
            case R.id.linear_hor:
                linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                recyclerView.setLayoutManager(linearLayoutManager);
                break;
            case R.id.grid:
                recyclerView.setLayoutManager(gridLayoutManager);
                break;
            case R.id.staggeredgrid:
                recyclerView.setLayoutManager(staggeredGridLayoutManager);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
