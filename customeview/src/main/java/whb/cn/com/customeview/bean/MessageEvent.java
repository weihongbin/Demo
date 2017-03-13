package whb.cn.com.customeview.bean;

/**
 * =============================================
 * 在此写用途
 *
 * @version V1.0 <描述当前版本功能>
 * @FileName: whb.cn.com.customeview.bean.MessageEvent.java
 * @author: 魏红彬
 * @date: 2017-03-13 11:17
 */
public class MessageEvent {
    private static final String TAG = "MessageEvent";


    public String content;

    public MessageEvent(String content) {

        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "MessageEvent{" +
                "content='" + content + '\'' +
                '}';
    }
}