package whb.cn.com.customeview.customerview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
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


public class Customer extends TextView implements View.OnTouchListener,View.OnLongClickListener,View.OnClickListener{
    private static final String TAG = "Customer";

    public Customer(Context context) {
        super(context);
        Log.e("whbb","1");
    }

    public Customer(Context context, AttributeSet attrs) {
        super(context, attrs);
        Log.e("whbb","2");
        setOnClickListener(this);
        setOnTouchListener(this);
        setOnLongClickListener(this);
    }

    public Customer(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Log.e("whbb","3");
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        Log.e("whbb","onSizeChanged");
        setOnClickListener(this);
        setOnTouchListener(this);
        setOnLongClickListener(this);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e("whbb","onTouchEvent");
//        int x = (int) event.getX();
//        int y = (int) event.getY();
//        int rawX = (int) event.getRawX();
//        int rawY = (int) event.getRawY();
//        int left = getLeft();
//        int right = getRight();
//        int top = getTop();
//        int bottom = getBottom();
//        int pBottom = getPaddingBottom();
//        int pTop = getPaddingTop();
//        int pStart = getPaddingStart();
//        int pEnd =getPaddingEnd();
//        int pLeft =getPaddingLeft();
//        int pRight =getPaddingRight();
//        int getWidth =getWidth();
//        int getHeight =getHeight();


//        switch (event.getAction()) {
////            case MotionEvent.ACTION_DOWN:
////                Log.e("whb", "x=" + x + "\n" +
////                        "y=" + y + "\n" +
////                        "rawX=" + rawX + "\n" +
////                        "rawY=" + rawY + "\n" +
////                        "left=" + left + "\n" +
////                        "right=" + right + "\n" +
////                        "top=" + top + "\n" +
////                        "bottom=" + bottom + "\n" +
////                        "pBottom=" + pBottom + "\n" +
////                        "pTop=" + pTop + "\n" +
////                        "pStart=" + pStart + "\n" +
////                        "pEnd=" + pEnd + "\n" +
////                        "pLeft=" + pLeft + "\n" +
////                        "pRight=" + pRight + "\n" +
////                        "getWidth=" + getWidth + "\n" +
////                        "getHeight=" + getHeight + "\n"
////                );
////                break;
////            case MotionEvent.ACTION_UP:
////                break;
//        }
        return super.onTouchEvent(event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.e("whbb","View dispatchTouchEvent" + event.getAction());
        return super.dispatchTouchEvent(event);
    }

    @Override
    public void onClick(View view) {
        ( (TextView)view).setText("onClick");
        Log.e("whbb","viewonClick");
    }

    @Override
    public boolean onLongClick(View view) {
        Log.e("whbb","viewonLongClick");
        ( (TextView)view).setText("onLongClick");
        return true;
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        Log.e("whbb","viewonTouch222222222222222222222");
        return false;
    }
}