package tck.cn.mysimplenewsclient.app;

import android.app.Application;

import com.facebook.stetho.Stetho;
import com.squareup.leakcanary.LeakCanary;

/**
 * Description :
 * <p>
 * Created by tck on 2016/10/14.
 */

public class MyApplication extends Application {

    private static MyApplication INSTANCE;

    public static MyApplication getInstance() {
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
}
