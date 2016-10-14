package tck.cn.mysimplenewsclient.ui.zhihu.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.app.Fragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import tck.cn.mysimplenewsclient.R;
import tck.cn.mysimplenewsclient.base.SimpleFragment;
import tck.cn.mysimplenewsclient.ui.zhihu.adpater.ZhihuMainAdapter;

/**
 * Description :
 * <p>
 * Created by tck on 2016/10/14.
 */

public class ZhihuMainFragment extends SimpleFragment {

    @BindView(R.id.tab_zhihu_main)
    TabLayout mTabLayout;
    @BindView(R.id.vp_zhihu_main)
    ViewPager mVpZhihuMain;

    ZhihuMainAdapter mAdapter;



    private List<Fragment> mFragments;
    private List<String> mTitles;


    @Override
    protected void initEventAndData() {

        mTitles = new ArrayList<>();
        mTitles.add("日报");
        mTitles.add("主题");
        mTitles.add("专栏");
        mTitles.add("热门");

        mFragments = new ArrayList<Fragment>();

        mFragments.add(new DailyFragment());

        mAdapter = new ZhihuMainAdapter(getChildFragmentManager(), mFragments,mTitles);

        mVpZhihuMain.setAdapter(mAdapter);

        mTabLayout.setupWithViewPager(mVpZhihuMain);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_zhihu_main;
    }
}
