package tck.cn.mysimplenewsclient.di.component;

import javax.inject.Singleton;

import dagger.Component;
import tck.cn.mysimplenewsclient.app.App;
import tck.cn.mysimplenewsclient.di.component.module.AppModule;
import tck.cn.mysimplenewsclient.model.db.RealmHelper;
import tck.cn.mysimplenewsclient.model.http.RetrofitHelper;

/**
 * Description :
 * <p>
 * Created by tck on 2016/10/14.
 */

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {


    @ContextLife("Application")
    App getContext();  // 提供App的Context

    RetrofitHelper retrofitHelper();  //提供http的帮助类

    RealmHelper realmHelper();    //提供数据库帮助类
}
