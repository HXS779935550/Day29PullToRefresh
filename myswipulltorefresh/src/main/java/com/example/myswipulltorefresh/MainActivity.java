package com.example.myswipulltorefresh;

import android.graphics.Color;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private SwipeRefreshLayout srl;
    private List<String> data;
    private ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        srl= (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayout);;
        listView= (ListView) findViewById(R.id.listView );
        init();
        srl.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
               new MyAsync().execute();
            }
        });
        srl.setColorSchemeColors(Color.RED,Color.BLUE,Color.YELLOW,Color.RED,Color.BLUE,Color.YELLOW);
        srl.setSize(SwipeRefreshLayout.LARGE);
    }

    private void init() {
        data = new ArrayList<>();
        for(int i=0;i<30;i++){
            data.add("我来千峰学习的天数"+i);
        }
        adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,data);
        listView.setAdapter(adapter);
    }
    class MyAsync extends AsyncTask<Void,Void,Void>{
        @Override
        protected Void doInBackground(Void... params) {
            for(int i=0;i<5;i++){
                data.add(0,"学习的天数"+i);
            }
            SystemClock.sleep(3000);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            adapter.notifyDataSetChanged();
            srl.setRefreshing(false);
        }
    }
}
