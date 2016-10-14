package tck.cn.mysimplenewsclient.model.http;

import tck.cn.mysimplenewsclient.model.bean.SplashBean;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Description :
 * <p>
 * Created by tck on 2016/10/14.
 */

public interface ZhihuApis {

    String HOST = "http://news-at.zhihu.com/api/4/";

    /**
     * 启动界面图片
     */
    @GET("start-image/{res}")
    Observable<SplashBean> getSplashInfo(@Path("res") String res);
}
