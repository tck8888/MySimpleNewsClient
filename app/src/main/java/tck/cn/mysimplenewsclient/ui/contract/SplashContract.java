package tck.cn.mysimplenewsclient.ui.contract;

import tck.cn.mysimplenewsclient.base.BasePresenter;
import tck.cn.mysimplenewsclient.base.BaseView;
import tck.cn.mysimplenewsclient.model.bean.SplashBean;

/**
 * Description :
 * <p>
 * Created by tck on 2016/10/14.
 */

public interface SplashContract {
    interface View extends BaseView {

        void showContent(SplashBean splashBean);

        void jumpToMain();

    }

    interface  Presenter extends BasePresenter<View> {

        void getSplashData();

    }

}
