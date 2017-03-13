package whb.cn.com.customeview.customerview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * =============================================
 * 在此写用途
 *
 * @version V1.0 <描述当前版本功能>
 * @FileName: whb.cn.com.customeview.customerview.CustomerView.java
 * @author: 魏红彬
 * @e-mail: weihongbin@t-tron.com
 * @date: 2017-03-13 15:06
 */


public class CustomerViewGroup extends LinearLayout {
    private static final String TAG = "CustomerView";

    public CustomerViewGroup(Context context) {
        super(context);
    }

    public CustomerViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomerViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    /**
     * 用来进行事件分发。如果事件能够传递给当前View，那么此方法一定被调用，
     * 返回结果受当前View的onTouchEvent和下级View的dispatchTouchEvent方法影响，
     * 表示是否消耗当前事件
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e("whb","ViewGroupA dispatchTouchEvent"+ev.getAction());
        return super.dispatchTouchEvent(ev);
    }
    /**
     * 在上述方法内部调用，用力啊判断是否拦截某个事件，返回结果表示是否消耗当前事件，
     * 如果不消耗，则在同一个事件序列中，此方法不会再次被调用，返回结果表示是否拦截当前事件
     */
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.e("whb","ViewGroupA onInterceptTouchEvent"+ev.getAction());
        return false;
    }
    /**
     * 在dispatchTouchEvent方法中被调用，用来处理点击事件，返回结果表示是否消耗当前事件，
     * 如果不消耗，在同一事件序列当中，当前View无法再次接收到事件
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e("whb","ViewGroupA onTouchEvent"+event.getAction());
        return super.onTouchEvent(event);
    }

}