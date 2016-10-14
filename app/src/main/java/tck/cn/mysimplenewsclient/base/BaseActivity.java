package tck.cn.mysimplenewsclient.base;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;


import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportActivity;
import tck.cn.mysimplenewsclient.app.App;
import tck.cn.mysimplenewsclient.di.component.ActivityComponent;
import tck.cn.mysimplenewsclient.di.component.DaggerActivityComponent;
import tck.cn.mysimplenewsclient.di.component.module.ActivityModule;

/**
 * Description :Activity基类
 * <p>
 * Created by tck on 2016/10/14.
 */

public abstract class BaseActivity<T extends BasePresenter> extends SupportActivity implements BaseView {

    @Inject
    protected T mPresenter;

    private Unbinder mUnbinder;
    protected Activity mContext;

    protected abstract void initEventAndData();

    protected abstract void initInject();

    protected abstract int getLayout();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        mUnbinder = ButterKnife.bind(this);
        mContext = this;

        initInject();

        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
        App.getInstance().addActivity(this);

        initEventAndData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        mUnbinder.unbind();
        App.getInstance().removeActivity(this);
    }

    protected ActivityComponent getActivityComponent(){
        return  DaggerActivityComponent.builder()
                .appComponent(App.getAppComponent())
                .activityModule(getActivityModule())
                .build();
    }

    protected ActivityModule getActivityModule(){
        return new ActivityModule(this);
    }

    protected void setToolBar(Toolbar toolbar, String title) {
        toolbar.setTitle(title);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressedSupport();
            }
        });
    }
}
