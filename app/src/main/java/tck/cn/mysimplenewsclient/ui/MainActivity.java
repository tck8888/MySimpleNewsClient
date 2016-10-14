package tck.cn.mysimplenewsclient.ui;


import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.miguelcatalan.materialsearchview.MaterialSearchView;

import butterknife.BindView;
import me.yokeyword.fragmentation.SupportFragment;
import tck.cn.mysimplenewsclient.R;
import tck.cn.mysimplenewsclient.app.Constants;
import tck.cn.mysimplenewsclient.base.BaseActivity;
import tck.cn.mysimplenewsclient.ui.contract.MainContract;
import tck.cn.mysimplenewsclient.ui.present.MainPresenter;
import tck.cn.mysimplenewsclient.ui.zhihu.fragment.ZhihuMainFragment;
import tck.cn.mysimplenewsclient.util.SharedPreferenceUtil;

public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.View {


    @BindView(R.id.toolbar)
    Toolbar mToolBar;

    @BindView(R.id.view_search)
    MaterialSearchView mViewSearch;

    @BindView(R.id.navigation)
    NavigationView mNavigation;

    @BindView(R.id.drawer)
    DrawerLayout mDrawer;


    ActionBarDrawerToggle mDrawerToggle;
    MenuItem mLastMenuItem;
    MenuItem mSearchMenuItem;

    ZhihuMainFragment mZhihuFragment;

    private int showFragment = Constants.TYPE_ZHIHU;
    private int hideFragment = Constants.TYPE_ZHIHU;
    private AboutFragment mAboutFragment;

    @Override
    protected void initEventAndData() {
        mToolBar.setTitle("知乎日报");
        setSupportActionBar(mToolBar);

        mZhihuFragment = new ZhihuMainFragment();
        mAboutFragment = new AboutFragment();

        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawer,
                R.string.drawer_open, R.string.drawer_close);
        mDrawerToggle.syncState(); //这一步很重要，同步侧滑菜单，侧滑菜单才能正常使用
        mDrawer.addDrawerListener(mDrawerToggle);//向DrawerLayout中加入侧滑状态监听器

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        mLastMenuItem = mNavigation.getMenu().findItem(R.id.drawer_zhihu);

        loadMultipleRootFragment(R.id.fl_main_content, 0, mZhihuFragment, mAboutFragment);

        mNavigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.drawer_zhihu:
                        showFragment = Constants.TYPE_ZHIHU;
                        mSearchMenuItem.setVisible(false);
                        break;
                    case R.id.drawer_gank:
                        showFragment = Constants.TYPE_GANK;
                        mSearchMenuItem.setVisible(true);
                        break;
                    case R.id.drawer_wechat:
                        showFragment = Constants.TYPE_WECHAT;
                        mSearchMenuItem.setVisible(true);
                        break;
                    case R.id.drawer_setting:
                        showFragment = Constants.TYPE_SETTING;
                        mSearchMenuItem.setVisible(false);
                        break;
                    case R.id.drawer_like:
                        showFragment = Constants.TYPE_LIKE;
                        mSearchMenuItem.setVisible(false);
                        break;
                    case R.id.drawer_about:
                        showFragment = Constants.TYPE_ABOUT;
                        mSearchMenuItem.setVisible(false);
                        break;
                }
                if (mLastMenuItem != null) {
                    mLastMenuItem.setChecked(false);
                }
                mLastMenuItem = item;
                SharedPreferenceUtil.setCurrentItem(showFragment);
                item.setChecked(true);
                mToolBar.setTitle(item.getTitle());
                mDrawer.closeDrawers();
                showHideFragment(getTargetFragment(showFragment), getTargetFragment(hideFragment));
                hideFragment = showFragment;
                return true;
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        MenuItem item = menu.findItem(R.id.action_search);
        item.setVisible(false);
        mViewSearch.setMenuItem(item);
        mSearchMenuItem = item;
        return true;
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

    private SupportFragment getTargetFragment(int item) {
        switch (item) {
            case Constants.TYPE_ZHIHU:
                return mZhihuFragment;
           /* case Constants.TYPE_GANK:
                return mGankFragment;
            case Constants.TYPE_WECHAT:
                return mWechatFragment;
            case Constants.TYPE_LIKE:
                return mLikeFragment;
            case Constants.TYPE_SETTING:
                return mSettingFragment;*/
            case Constants.TYPE_ABOUT:
                return mAboutFragment;
        }
        return mZhihuFragment;
    }
}
