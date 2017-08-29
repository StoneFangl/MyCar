package cn.mycar.launch;

import android.support.annotation.NonNull;
import android.support.v4.widget.DrawerLayout;

import cn.mycar.R;
import cn.mycar.base.BaseActivity;
import cn.mycar.base.BasePresenter;
import cn.mycar.base.BaseView;
import statusbar.StatusBarUtil;

/**
 * @author Stone
 * @time 2017/8/29  10:04
 * @desc 启动页的Activity
 * 1、启动动态的权限的申请。
 * 2、获取广告图进行展示。
 * 3.确定跳转的页面。
 */

public class SplashActivity extends BaseActivity<BaseView, BasePresenter<BaseView>> implements BaseView {
    private int mStatusBarColor;
    private int mAlpha = 0;

    @Override
    public int getRootViewId() {
        return R.layout.activity_main;
    }

    @Override
    public void initUI() {
        mStatusBarColor = getResources().getColor(R.color.colorWhite);
        StatusBarUtil.setColorForDrawerLayout(this, (DrawerLayout) findViewById(R.id.drawer_layout), mStatusBarColor, mAlpha);
        StatusBarUtil.setStatusBarDarkMode(this);
    }

    @Override
    public void initData() {
    }

    @Override
    @NonNull
    public BasePresenter<BaseView> createPresenter() {
        return new BasePresenter<>();
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    protected void setStatusBar() {
        //        super.setStatusBar();
        StatusBarUtil.setStatusBarDarkMode(this);
        StatusBarUtil.setColorForDrawerLayout(this, (DrawerLayout) findViewById(R.id.drawer_layout), mStatusBarColor, mAlpha);
    }
}
