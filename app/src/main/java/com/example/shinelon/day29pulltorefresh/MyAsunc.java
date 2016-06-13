package com.example.shinelon.day29pulltorefresh;

import android.os.AsyncTask;
import android.os.SystemClock;
import android.widget.ArrayAdapter;

import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.List;

/**
 * Created by Shinelon on 2016/6/12.
 */
public class MyAsunc extends AsyncTask<Void,Void,Void> {
    private  PullToRefreshListView ptf;
    private  ArrayAdapter adapter;
    private  List<String> list;

    public MyAsunc(ArrayAdapter adapter, List<String> list, PullToRefreshListView ptf){
        this.list=list;
        this.adapter=adapter;
        this.ptf=ptf;
    }
    @Override
    protected Void doInBackground(Void... params) {
        SystemClock.sleep(2000);
        addData();
        return null;
    }

    private void addData() {
        for(int i=0;i<5;i++){
            list.add(0,"新的消息"+i);
        }
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        adapter.notifyDataSetChanged();
        ptf.onRefreshComplete();
    }
}
