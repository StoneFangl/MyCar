package imageloader.base;

import android.content.Context;

/**
 * @author Stone
 * @time 2017/8/31  16:30
 * @desc 也就是一个基本的任务一样，由不同的策略分别创建子类来实现，定义接口，不同的实现方式是不同的
 */

public interface BaseImagerLoaderStrategy<T extends BaseImageViewConfig> {
    //加载图片
    void loadImage(Context ctx, T config);

    //退出时不再加载
    void clear(Context ctx, T config);
}
