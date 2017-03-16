package whb.cn.com.customeview.bean;

/**
 * =============================================
 * 在此写用途
 *
 * @version V1.0 <描述当前版本功能>
 * @FileName: whb.cn.com.customeview.bean.PieData.java
 * @author: 魏红彬
 * @e-mail: weihongbin@t-tron.com
 * @date: 2017-03-14 12:42
 */


public class PieData {
    private static final String TAG = "PieData";
    private String name;
    private float value;
    private int color;//颜色

    public PieData(String name, float value, int color) {
        this.name = name;
        this.value = value;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "PieData{" +
                "name='" + name + '\'' +
                ", value=" + value +
                ", color=" + color +
                '}';
    }
}