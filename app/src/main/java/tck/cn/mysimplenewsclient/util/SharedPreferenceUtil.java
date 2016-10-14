package tck.cn.mysimplenewsclient.util;

import android.content.Context;
import android.content.SharedPreferences;

import tck.cn.mysimplenewsclient.app.App;
import tck.cn.mysimplenewsclient.app.Constants;

/**
 * Description :
 * <p>
 * Created by tck on 2016/10/14.
 */

public class SharedPreferenceUtil {

    private static final String SHAREDPREFERENCES_NAME = "tck";
    private static final boolean DEFAULT_NO_IMAGE = false;
    private static final int DEFAULT_CURRENT_ITEM = Constants.TYPE_ZHIHU;

    public static SharedPreferences getAppSp() {
        return App.getInstance().getSharedPreferences(SHAREDPREFERENCES_NAME, Context.MODE_PRIVATE);
    }

    public static boolean getNoImageState() {
        return getAppSp().getBoolean(Constants.SP_NO_IMAGE, DEFAULT_NO_IMAGE);
    }

    public static int getCurrentItem() {
        return getAppSp().getInt(Constants.SP_CURRENT_ITEM, DEFAULT_CURRENT_ITEM);
    }

    public static void setCurrentItem(int item) {
        getAppSp().edit().putInt(Constants.SP_CURRENT_ITEM, item).commit();
    }

}
