package tck.cn.mysimplenewsclient.ui.contract;

import tck.cn.mysimplenewsclient.base.BasePresenter;
import tck.cn.mysimplenewsclient.base.BaseView;

/**
 * Description :
 * <p>
 * Created by tck on 2016/10/14.
 */

public interface MainContract {
    interface View extends BaseView {

    }

    interface  Presenter extends BasePresenter<View> {

    }
}
