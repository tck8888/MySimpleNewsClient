package tck.cn.mysimplenewsclient.ui;


import android.content.Intent;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import tck.cn.mysimplenewsclient.R;
import tck.cn.mysimplenewsclient.base.BaseActivity;
import tck.cn.mysimplenewsclient.model.bean.SplashBean;
import tck.cn.mysimplenewsclient.ui.contract.SplashContract;
import tck.cn.mysimplenewsclient.ui.present.SplashPresenter;
import tck.cn.mysimplenewsclient.util.ImageLoader;

public class SplashActivity extends BaseActivity<SplashPresenter> implements SplashContract.View {
    private static final String TAG = "SplashActivity";
    @BindView(R.id.iv_welcome_bg)
    ImageView mIvWelcomeBg;
    @BindView(R.id.tv_welcome_author)
    TextView mTvWelcomeAuthor;

    @Override
    protected int getLayout() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected void initEventAndData() {
        mPresenter.getSplashData();
    }


    @Override
    public void showContent(SplashBean splashBean) {
        ImageLoader.load(this, splashBean.getImg(), mIvWelcomeBg);
        mIvWelcomeBg.animate().scaleX(1.12f).scaleY(1.12f).setDuration(2000).setStartDelay(100).start();
        mTvWelcomeAuthor.setText(splashBean.getText());
    }

    @Override
    public void showError(String msg) {

    }

    @Override
    public void jumpToMain() {
        startActivity(new Intent(this,MainActivity.class));
        finish();
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    @Override
    protected void onDestroy() {
        Glide.clear(mIvWelcomeBg);
        super.onDestroy();
    }
}
