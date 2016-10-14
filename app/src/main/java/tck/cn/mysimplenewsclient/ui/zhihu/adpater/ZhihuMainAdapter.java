package tck.cn.mysimplenewsclient.ui.zhihu.adpater;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Description :
 * <p>
 * Created by tck on 2016/10/14.
 */

public class ZhihuMainAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragments;
    private List<String> titles;

    public ZhihuMainAdapter(FragmentManager fm, List<Fragment> fragments, List<String> titles) {
        super(fm);
        this.fragments = fragments;
        this.titles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }


    public int getItemPosition(Object object) {
        return PagerAdapter.POSITION_NONE;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }
}
