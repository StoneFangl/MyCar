package cn.mycar.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;

import java.util.List;

import mvp.view.MvpActivity;
import mvp.view.MvpPresenter;
import mvp.view.MvpView;
import statusbar.StatusBarUtil;


/**
 * @author Jenly <a href="mailto:jenly1314@gmail.com">Jenly</a>
 * @since 2017/2/20
 */

public abstract class BaseActivity<V extends MvpView, P extends MvpPresenter<V>> extends MvpActivity<V, P> {
    //状态栏颜色变量
    protected int mStatusBarColor;
    //状态栏透明度
    protected int mAlpha = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getRootViewId());
        initUI();
        setStatusBar();

    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        //        ButterKnife.bind(this);
    }

    /**
     * 设置状态栏
     */
    protected void setStatusBar() {
        StatusBarUtil.setColor(this,mStatusBarColor,mAlpha);
        StatusBarUtil.setStatusBarDarkMode(this);
    }

    public <T> void toSetList(List<T> list, List<T> newList, boolean isMore) {

        if (list != null && newList != null) {
            synchronized (BaseFragment.class) {
                if (!isMore) {
                    list.clear();
                }
                list.addAll(newList);
            }
        }
    }

    /*
    public App getApp(){
        return (App)getApplication();
    }
*/


    public abstract int getRootViewId();

    public abstract void initUI();

    public abstract void initData();

}
