package tck.cn.mysimplenewsclient.model.http;


import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import tck.cn.mysimplenewsclient.model.bean.SplashBean;

/**
 * Description :
 * <p>
 * Created by tck on 2016/10/14.
 */

public class RetrofitHelper {

    private static OkHttpClient okHttpClient = null;
    private static ZhihuApis zhihuApiService = null;

    public RetrofitHelper() {
        init();
    }

    private void init() {
        initOkHttp();
        zhihuApiService = getZhihuApiService();
        //gankApiService = getGankApiService();
        //wechatApiService = getWechatApiService();
    }

    private void initOkHttp() {

    }

    public static ZhihuApis getZhihuApiService() {

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(ZhihuApis.HOST)
                .build();
        return retrofit.create(ZhihuApis.class);
    }


    public Observable<SplashBean> fetchSplashInfo(String res) {
        return zhihuApiService.getSplashInfo(res);
    }
}
