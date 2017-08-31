package imageloader.base;

import android.widget.ImageView;

/**
 * @author Stone
 * @time 2017/8/31  16:09
 * @desc 这里是图片加载配置信息的基类, 可以定义一些所有图片加载框架都可以用的通用参数
 */

public class BaseImageViewConfig {

    protected String url;
    protected int errorPic;
    protected int placeholder;
    protected ImageView imageView;

    public String getUrl() {
        return url;
    }

    public int getErrPic() {
        return errorPic;
    }

    public int getPlaceHolder() {
        return placeholder;
    }

    public ImageView getImageView() {
        return imageView;
    }
}
