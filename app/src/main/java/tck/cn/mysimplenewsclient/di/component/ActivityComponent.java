package tck.cn.mysimplenewsclient.di.component;

import android.app.Activity;

import com.squareup.haha.perflib.Main;

import dagger.Component;

import tck.cn.mysimplenewsclient.di.component.module.ActivityModule;
import tck.cn.mysimplenewsclient.di.cope.ActivityScope;
import tck.cn.mysimplenewsclient.ui.MainActivity;
import tck.cn.mysimplenewsclient.ui.SplashActivity;

/**
 * Description :
 * <p>
 * Created by tck on 2016/10/14.
 */

@ActivityScope
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    Activity getActivity();

    void inject(SplashActivity SplashActivity);

    void inject(MainActivity mainActivity);
}
