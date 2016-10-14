package tck.cn.mysimplenewsclient.di.cope;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Description :
 * <p>
 * Created by tck on 2016/10/14.
 */

@Scope
@Retention(RUNTIME)
public @interface ActivityScope {
}
