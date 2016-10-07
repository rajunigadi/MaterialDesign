package com.vtechsofts.materialdesign;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rajashekhar.v on 10/07/2016.
 */
public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {

    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private ProgressBar progressBar;

    private List<String> mUsers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe);
        swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_dark, android.R.color.holo_blue_light,
                android.R.color.holo_green_light, android.R.color.holo_green_light);
        swipeRefreshLayout.setOnRefreshListener(this);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);

        linearLayoutManager = new LinearLayoutManager(getBaseContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        //recyclerView.addItemDecoration(new DividerItemDecoration(this)); // use this to add line divider to recycler view item.
        addUsers();
    }

    @Override
    public void onRefresh() {
        addUsers();
        swipeRefreshLayout.setRefreshing(false);
    }

    private void addUsers() {
        progressBar.setVisibility(View.VISIBLE);
        mUsers = new ArrayList<>();
        for(int i=1;i<101;i++) {
            mUsers.add("User " + i);
        }
        UserAdapter adapter = new UserAdapter(mUsers);
        recyclerView.setAdapter(adapter);
        progressBar.setVisibility(View.GONE);
    }
}
