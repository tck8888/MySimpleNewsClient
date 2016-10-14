package tck.cn.mysimplenewsclient.ui.present;

import javax.inject.Inject;

import tck.cn.mysimplenewsclient.base.RxPresenter;
import tck.cn.mysimplenewsclient.ui.contract.MainContract;

/**
 * Description :
 * <p>
 * Created by tck on 2016/10/14.
 */

public class MainPresenter extends RxPresenter<MainContract.View> implements MainContract.Presenter {

    @Inject
    public MainPresenter() {
        registerEvent();
    }

    public void registerEvent() {

    }

}
