1.MyCar:项目采用MVP设计模式来进行开发，使用的mosByMvp，拷贝基类的代码，由基类去管理生命周期以及定义一些常用的公共方法（也可以使用工具类）
        自己感觉使用工具类会好一点，不需要在打开每个页面的时候都需要去初始化这个对象。使用工具类的话生命周期比较长。
2.在基类当中使用的是EventBus，来实现订阅与响应。使用了ButterKnife来查找控件，减少findViewById.
3.在基类Actviity和fragment当中使用RxLifeRecycle来解决Rxjava的内存泄露的问题，这里采用的是实现接口的形式来实现,（单继承）。无需继承RxXXXXX来实现
    http://www.jianshu.com/p/a3ad9dd20655
    子类使用的方式：一、bindToLifecycle()方法
            在子类使用Observable中的compose操作符，调用，完成Observable发布的事件和当前的组件绑定，实现生命周期同步。从而实现当前组件生命周期结束时，自动取消对Observable订阅。
                    Observable.interval(1, TimeUnit.SECONDS)
                    .compose(this.bindToLifecycle())
                        .subscribe(new Action1<Long>() { 
                            @Override
                            public void call(Long num) {
                                Log.i(TAG, "  " +num);
                            }
                        });
            二、bindUntilEvent() 方法
            使用ActivityEvent类，其中的CREATE、START、 RESUME、PAUSE、STOP、 DESTROY分别对应生命周期内的方法。使用bindUntilEvent指定在哪个生命周期方法调用时取消订阅。
            
                Observable.interval(1, TimeUnit.SECONDS)
                     .compose(this.bindUntilEvent(ActivityEvent.PAUSE))  
                     .subscribe(mSub);
4.状态栏的工具类，可以更改状态栏的颜色，以及设计Drawerlayout的问题。解决部分机型上面的黑色图标。
5.