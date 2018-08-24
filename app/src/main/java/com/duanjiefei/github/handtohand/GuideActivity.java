package com.duanjiefei.github.handtohand;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class GuideActivity extends Activity {
    private ViewPager viewPager;
    private Button start_button;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guide_layout);
        viewPager = findViewById(R.id.view_pager);
        start_button = findViewById(R.id.button_start);
        start_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GuideActivity.this,MainActivity.class));
                finish();
            }
        });
        initViewPager();
    }

    private void initViewPager() {
        List<View>  list = new ArrayList<>();
        ImageView imageView1 = new ImageView(this);
        imageView1.setImageResource(R.drawable.guide_1);
        ImageView imageView2 = new ImageView(this);
        imageView2.setImageResource(R.drawable.guide_2);
        ImageView imageView3 = new ImageView(this);
        imageView3.setImageResource(R.drawable.guide_3);
        list.add(imageView1);
        list.add(imageView2);
        list.add(imageView3);

        GuideAdapter guideAdapter = new GuideAdapter(list);
        viewPager.setAdapter(guideAdapter);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                if (position == 2){
                    start_button.setVisibility(View.VISIBLE);
                }else {
                    start_button.setVisibility(View.GONE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
     }
}
