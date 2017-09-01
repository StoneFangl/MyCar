package imageloader;

import android.content.Context;

import imageloader.base.BaseImageViewConfig;
import imageloader.base.BaseImageLoaderStrategy;

/**
 * @author Stone
 * @time 2017/9/1  10:55
 * @desc 加载图片的管理类
 */

public class ImageLoader {
    private BaseImageLoaderStrategy mStrategy;

    public ImageLoader(BaseImageLoaderStrategy strategy) {
        setLoadImgStrategy(strategy);
    }


    public <T extends BaseImageViewConfig> void loadImage(Context context, T config) {
        this.mStrategy.loadImage(context, config);
    }

    public <T extends BaseImageViewConfig> void clear(Context context, T config) {
        this.mStrategy.clear(context, config);
    }


    public void setLoadImgStrategy(BaseImageLoaderStrategy strategy) {
        this.mStrategy = strategy;
    }
}
