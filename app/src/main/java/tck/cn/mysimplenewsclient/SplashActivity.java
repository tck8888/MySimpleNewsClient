package tck.cn.mysimplenewsclient;

import android.os.Bundle;

import tck.cn.mysimplenewsclient.base.BaseActivity;

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_splash;
    }
}
