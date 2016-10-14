package tck.cn.mysimplenewsclient.ui;


import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;

import com.miguelcatalan.materialsearchview.MaterialSearchView;

import butterknife.BindView;
import tck.cn.mysimplenewsclient.R;
import tck.cn.mysimplenewsclient.base.BaseActivity;
import tck.cn.mysimplenewsclient.ui.contract.MainContract;
import tck.cn.mysimplenewsclient.ui.present.MainPresenter;

public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.View {


    @BindView(R.id.toolbar)
    Toolbar mToolBar;
    @BindView(R.id.view_search)
    MaterialSearchView mViewSearch;
    @BindView(R.id.toolbar_container)
    FrameLayout mToolbarContainer;
    @BindView(R.id.fl_main_content)
    FrameLayout mFlMainContent;
    @BindView(R.id.navigation)
    NavigationView mNavigation;
    @BindView(R.id.drawer)
    DrawerLayout mDrawer;

    @Override
    protected void initEventAndData() {
        setToolBar(mToolBar, "知乎日报");
    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void showError(String msg) {

    }
}
