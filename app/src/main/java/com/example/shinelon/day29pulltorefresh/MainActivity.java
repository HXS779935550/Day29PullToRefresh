package com.example.shinelon.day29pulltorefresh;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.handmark.pulltorefresh.library.ILoadingLayout;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private PullToRefreshListView ptf;
    private List<String> list;
    private ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //22222
        initListData();
        initData();
        ptf.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<ListView>() {
            @Override
            public void onRefresh(PullToRefreshBase<ListView> refreshView) {
                new MyAsunc(adapter,list,ptf).execute();
            }
        });
        ILoadingLayout proxy = ptf.getLoadingLayoutProxy();

        proxy.setPullLabel("。。。。");
        proxy.setRefreshingLabel("更新时候显示");
        proxy.setReleaseLabel("66666");
        String s= DateUtils.formatDateTime(this,System.currentTimeMillis(),DateUtils.FORMAT_SHOW_TIME | DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_SHOW_YEAR);
        proxy.setLastUpdatedLabel(s);
    }

    private void initListData() {
        list=new ArrayList<>();
        for(int i=0;i<30;i++){
            list.add("计步器"+i);
        }
    }
    //66666666666
    private void initData() {
        ptf= (PullToRefreshListView) findViewById(R.id.pulltorefresh_lsitview);
        adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,list);
        ptf.setAdapter(adapter);
    }
}
