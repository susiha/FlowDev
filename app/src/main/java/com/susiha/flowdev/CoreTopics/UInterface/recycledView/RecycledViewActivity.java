package com.susiha.flowdev.CoreTopics.UInterface.recycledView;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.susiha.flowdev.R;

/**
 * author:  sunshihai
 * createTime:  2018/11/21
 * desc:
 */

public class RecycledViewActivity extends AppCompatActivity {


    RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_core_recycledview_main);

        recyclerView = findViewById(R.id.recyclerview);




    }
}
