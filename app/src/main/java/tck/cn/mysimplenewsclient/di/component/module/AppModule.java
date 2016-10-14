package tck.cn.mysimplenewsclient.di.component.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import tck.cn.mysimplenewsclient.app.App;
import tck.cn.mysimplenewsclient.di.component.ContextLife;
import tck.cn.mysimplenewsclient.model.http.RetrofitHelper;

/**
 * Description :
 * <p>
 * Created by tck on 2016/10/14.
 */
@Module
public class AppModule {

    private final App application;

    public AppModule(App application) {
        this.application = application;
    }

    @Provides
    @Singleton
    @ContextLife("Application")
    App provideApplicationContext() {
        return application;
    }

    @Provides
    @Singleton
    RetrofitHelper provideRetrofitHelper() {
        return new RetrofitHelper();
    }
}
