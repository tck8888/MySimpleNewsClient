package tck.cn.mysimplenewsclient.app;

import android.app.Activity;
import android.app.Application;

import com.facebook.stetho.Stetho;
import com.squareup.leakcanary.LeakCanary;

import java.util.HashSet;
import java.util.Set;

import tck.cn.mysimplenewsclient.di.component.AppComponent;
import tck.cn.mysimplenewsclient.di.component.DaggerAppComponent;
import tck.cn.mysimplenewsclient.di.component.module.AppModule;

/**
 * Description :
 * <p>
 * Created by tck on 2016/10/14.
 */

public class App extends Application {

    private static App INSTANCE;
    private Set<Activity> allActivities;

    public static synchronized App getInstance() {
        return INSTANCE;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        INSTANCE = this;

        /**
         * 内存泄漏检测
         */
        LeakCanary.install(this);

        /**
         *  调试工具
         */
        Stetho.initializeWithDefaults(this);

    }

    public void addActivity(Activity act) {
        if (allActivities == null) {
            allActivities = new HashSet<Activity>();
        }
        allActivities.add(act);
    }

    public void removeActivity(Activity act) {
        if (allActivities != null) {
            allActivities.remove(act);
        }
    }

    public void exitApp() {
        if (allActivities != null) {
            synchronized (allActivities) {
                for (Activity act : allActivities) {
                    act.finish();
                }
            }
        }
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0);
    }

    public static AppComponent getAppComponent() {
        return DaggerAppComponent.builder()
                .appModule(new AppModule(INSTANCE))
                .build();
    }
}
