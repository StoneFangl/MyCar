package cn.mycar.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;

import java.util.List;

import mvp.view.MvpActivity;
import mvp.view.MvpPresenter;
import mvp.view.MvpView;


/**
 * @author Jenly <a href="mailto:jenly1314@gmail.com">Jenly</a>
 * @since 2017/2/20
 */

public abstract class BaseActivity<V extends MvpView, P extends MvpPresenter<V>> extends MvpActivity<V,P> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getRootViewId());
        initUI();

    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
//        ButterKnife.bind(this);
    }


    public <T> void  toSetList(List<T> list, List<T> newList, boolean isMore){

        if(list!=null && newList!=null){
            synchronized (BaseFragment.class){
                if(!isMore){
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
