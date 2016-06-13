package com.example.myslidingpane;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class leftFragment extends Fragment {

    private List<String> list;
    private String[] urls;
    private ArrayAdapter adapter;
    private ListView listView;
    private CallPane callPane;

    public leftFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof CallPane){
            this.callPane= (CallPane) context;
        }else {
            throw new RuntimeException(context.getClass()+"CallPane没有实现该方法");
        }

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        list=new ArrayList<>();
        list.add("百度");
        list.add("谷歌");
        list.add("腾讯");

        urls = new String[]{"http://www.baidu.com","http://www.google.com","http://www.qq.com"};
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_left, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        listView = (ListView) view;
        adapter = new ArrayAdapter(getContext(),android.R.layout.simple_list_item_1,list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                callPane.call(urls[position]);
            }
        });
    }
    public interface CallPane{
        void call(String url);
    }
}
