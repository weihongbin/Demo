package whb.cn.com.demo;

/**
 * =============================================
 * 在此写用途
 *
 * @version V1.0 <描述当前版本功能>
 * @FileName: whb.cn.com.demo.Modle.java
 * @author: 魏红彬
 * @date: 2017-03-07 10:15
 */
public class Modle {
    private static final String TAG = "Modle";

    private String name;

    private int ids;

    public int getIds() {
        return ids;
    }

    public void setIds(int ids) {
        this.ids = ids;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Modle(String name, int ids) {
        this.name = name;
        this.ids = ids;
    }

    public Modle() {
    }

    @Override
    public String toString() {
        return "Modle{" +
                "name='" + name + '\'' +
                ", ids=" + ids +
                '}';
    }
}