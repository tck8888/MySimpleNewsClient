package tck.cn.mysimplenewsclient.base;


/**
 * Description :
 * <p>
 * Created by tck on 2016/10/14.
 */
public interface BasePresenter<T extends BaseView>{

    void attachView(T view);

    void detachView();
}
