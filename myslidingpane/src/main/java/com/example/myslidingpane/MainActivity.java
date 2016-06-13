package com.example.myslidingpane;


import android.support.v4.app.FragmentManager;
import android.support.v4.widget.SlidingPaneLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements leftFragment.CallPane{

    private rightFragment rfragment;
    private SlidingPaneLayout spl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spl= (SlidingPaneLayout) findViewById(R.id.spl);
        FragmentManager manager = getSupportFragmentManager();
        rfragment = (rightFragment) manager.findFragmentById(R.id.rightFragment);
        rfragment.setChangeWeb("http://www.baidu.com");

        spl.setPanelSlideListener(new SlidingPaneLayout.PanelSlideListener() {
            @Override
            public void onPanelSlide(View panel, float slideOffset) {

            }

            @Override
            public void onPanelOpened(View panel) {

            }

            @Override
            public void onPanelClosed(View panel) {

            }
        });
    }

    @Override
    public void call(String url) {
        rfragment.setChangeWeb(url);
        spl.closePane();
    }
}
