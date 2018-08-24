package com.duanjiefei.github.handtohand;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;

import tools.PreferenceUtils;

public class WeclomeActivity extends Activity {
    private static final String IS_FIRST = "is_first";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_layout);
        new Handler(new Handler.Callback(){
            @Override
            public boolean handleMessage(Message msg) {
                if(!PreferenceUtils.getBooleanValue(WeclomeActivity.this,IS_FIRST,false)){
                    startActivity(new Intent(WeclomeActivity.this,GuideActivity.class));
                    PreferenceUtils.putBooleanValue(WeclomeActivity.this,IS_FIRST,true);
                }else {
                    startActivity(new Intent(WeclomeActivity.this,MainActivity.class));
                }
                PreferenceUtils.putBooleanValue(WeclomeActivity.this,IS_FIRST,true);
                finish();
                return true;
            }
        }).sendEmptyMessageDelayed(0,5000);
    }
}
