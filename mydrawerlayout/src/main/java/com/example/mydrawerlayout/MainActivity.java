package com.example.mydrawerlayout;

import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    private String[] urls=new String[]{"http://www.baidu.com","http://www.qq.com",
            "http://www.taobao.com","http://www.tudou.com"};
    private FragmentManager manager;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        manager = getSupportFragmentManager();
        manager.beginTransaction().add(R.id.right,new RightFragment(),"right").commit();
        init();
    }

    private void init() {
        ListView listView = (ListView) findViewById(R.id.listView);
        if (listView != null) {
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    RightFragment rightFragment= (RightFragment) manager.findFragmentByTag("right");
                    rightFragment.setWebView(urls[position]);
                    drawerLayout.closeDrawers();
                }
            });
        }
        //抽屉 的监听器
        drawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

            }

            @Override
            public void onDrawerOpened(View drawerView) {

            }

            @Override
            public void onDrawerClosed(View drawerView) {

            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });
    }
}
