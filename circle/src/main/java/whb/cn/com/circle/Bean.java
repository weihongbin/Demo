package whb.cn.com.circle;

/**
 * =============================================
 * 在此写用途
 *
 * @version V1.0 <描述当前版本功能>
 * @FileName: whb.cn.com.circle.Bean.java
 * @author: 魏红彬
 * @e-mail: weihongbin@t-tron.com
 * @date: 2017-03-16 10:32
 */


public class Bean {
    private static final String TAG = "Bean";

    private int imageId;

    private String name;

    public int getImageId() {
        return imageId;
    }

    public Bean(String name, int imageId) {
        this.name = name;
        this.imageId = imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Bean{" +
                "imageId=" + imageId +
                ", name='" + name + '\'' +
                '}';
    }
}