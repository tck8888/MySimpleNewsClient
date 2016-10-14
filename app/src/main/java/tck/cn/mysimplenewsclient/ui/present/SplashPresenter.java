package tck.cn.mysimplenewsclient.ui.present;

import android.util.Log;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;
import tck.cn.mysimplenewsclient.base.RxPresenter;
import tck.cn.mysimplenewsclient.model.bean.SplashBean;
import tck.cn.mysimplenewsclient.model.http.RetrofitHelper;
import tck.cn.mysimplenewsclient.ui.contract.SplashContract;
import tck.cn.mysimplenewsclient.util.RxUtil;

/**
 * Description :
 * <p>
 * Created by tck on 2016/10/14.
 */

public class SplashPresenter extends RxPresenter<SplashContract.View> implements SplashContract.Presenter {

    private static final String KEY_SplashPresenter = "SplashPresenter";
    private static final String RES = "1080*1776";

    private static final int COUNT_DOWN_TIME = 2200;

    private RetrofitHelper mRetrofitHelper;

    @Inject
    public SplashPresenter(RetrofitHelper mRetrofitHelper) {
        this.mRetrofitHelper = mRetrofitHelper;
    }

    @Override
    public void getSplashData() {
        Subscription subscribe = mRetrofitHelper.fetchSplashInfo(RES)
                .compose(RxUtil.<SplashBean>rxSchedulerHelper())
                .subscribe(new Action1<SplashBean>() {
                    @Override
                    public void call(SplashBean splashBean) {
                        mView.showContent(splashBean);
                        Log.d(KEY_SplashPresenter, "----------call: ---------");
                        startCountDown();
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        mView.showError("");
                        mView.jumpToMain();
                    }
                });

        addSubscrebe(subscribe);
    }

    public void startCountDown() {
        Subscription subscribe = Observable.timer(COUNT_DOWN_TIME, TimeUnit.MILLISECONDS)
                .compose(RxUtil.<Long>rxSchedulerHelper())
                .subscribe(new Action1<Long>() {
                    @Override
                    public void call(Long aLong) {
                        Log.d(KEY_SplashPresenter, "----------call: ---------");
                        mView.jumpToMain();
                    }
                });
        addSubscrebe(subscribe);
    }
}
