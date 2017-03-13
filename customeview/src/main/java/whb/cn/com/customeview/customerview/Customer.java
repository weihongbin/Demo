package whb.cn.com.customeview.customerview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.TextView;

/**
 * =============================================
 * 在此写用途
 *
 * @version V1.0 <描述当前版本功能>
 * @FileName: whb.cn.com.customeview.customerview.Customer.java
 * @author: 魏红彬
 * @e-mail: weihongbin@t-tron.com
 * @date: 2017-03-13 15:31
 */


public class Customer extends TextView {
    private static final String TAG = "Customer";

    public Customer(Context context) {
        super(context);
    }

    public Customer(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Customer(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        int rawX = (int) event.getRawX();
        int rawY = (int) event.getRawY();
        int left = getLeft();
        int right = getRight();
        int top = getTop();
        int bottom = getBottom();
        int pBottom = getPaddingBottom();
        int pTop = getPaddingTop();
        int pStart = getPaddingStart();
        int pEnd =getPaddingEnd();
        int pLeft =getPaddingLeft();
        int pRight =getPaddingRight();
        int getWidth =getWidth();
        int getHeight =getHeight();


        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.e("whb", "x=" + x + "\n" +
                        "y=" + y + "\n" +
                        "rawX=" + rawX + "\n" +
                        "rawY=" + rawY + "\n" +
                        "left=" + left + "\n" +
                        "right=" + right + "\n" +
                        "top=" + top + "\n" +
                        "bottom=" + bottom + "\n" +
                        "pBottom=" + pBottom + "\n" +
                        "pTop=" + pTop + "\n" +
                        "pStart=" + pStart + "\n" +
                        "pEnd=" + pEnd + "\n" +
                        "pLeft=" + pLeft + "\n" +
                        "pRight=" + pRight + "\n" +
                        "getWidth=" + getWidth + "\n" +
                        "getHeight=" + getHeight + "\n"
                );
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return true;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.e("whb","View dispatchTouchEvent" + event.getAction());
        return super.dispatchTouchEvent(event);
    }
}