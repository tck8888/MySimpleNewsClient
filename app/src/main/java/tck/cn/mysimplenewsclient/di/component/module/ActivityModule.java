package tck.cn.mysimplenewsclient.di.component.module;

import android.app.Activity;

import dagger.Module;
import dagger.Provides;
import tck.cn.mysimplenewsclient.di.cope.ActivityScope;

/**
 * Description :
 * <p>
 * Created by tck on 2016/10/14.
 */
@Module
public class ActivityModule {

    private Activity mActivity;

    public ActivityModule(Activity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityScope
    public Activity provideActivity() {
        return mActivity;
    }
}
