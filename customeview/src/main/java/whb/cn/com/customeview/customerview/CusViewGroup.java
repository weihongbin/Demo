package whb.cn.com.customeview.customerview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ScrollView;
import android.widget.Scroller;

/**
 * =============================================
 * 在此写用途
 *
 * @version V1.0 <描述当前版本功能>
 * @FileName: whb.cn.com.customeview.customerview.CusViewGroup.java
 * @author: 魏红彬
 * @e-mail: weihongbin@t-tron.com
 * @date: 2017-03-15 11:04
 */


public class CusViewGroup extends ScrollView {
    private static final String TAG = "CusViewGroup";
    int h;
    Scroller mScroller;
    private int mLastY=0;
    private int mStart=0;
    private int mEnd=0;

    public CusViewGroup(Context context) {
        super(context);
        init(context);
    }

    public CusViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public CusViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    void init(Context context) {
        WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(displayMetrics);
        h = displayMetrics.heightPixels;
        mScroller = new Scroller(context);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int number = getChildCount();
        for (int i = 0; i < number; i++) {
            View view = getChildAt(i);
            measureChild(view, widthMeasureSpec, heightMeasureSpec);

        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        int count = getChildCount();
        MarginLayoutParams params = (MarginLayoutParams) getLayoutParams();
        params.height = h * count;
        setLayoutParams(params);
        for (int i = 0; i < count; i++) {
            View view = getChildAt(i);
            if (view.getVisibility() == VISIBLE) {
                view.layout(l, i * h, r, (i + 1) * h);
            }
        }
    }




    /**
     * 触摸事件
     *
     * @param ev
     * @return
     */
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        int y = (int) ev.getY();
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mLastY = y;
                mStart = getScrollY();
                Log.e("weia",getScaleX()+"\n"+getScrollY());
                Log.e("wei",getX()+"\n"+getY());
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e("weia",getScaleX()+"\n"+getScrollY());
                Log.e("wei",getX()+"\n"+getY());
                if (!mScroller.isFinished()) {
                    mScroller.abortAnimation();
                }
                int dy = y - mLastY;
                if (getScrollY()< 0) {
                    dy = 0;
                } else if (getScrollY()> getHeight() - h) {
                    dy = 0;
                }
                scrollBy(0, dy);
                mLastY = y;
                break;
            case MotionEvent.ACTION_UP:
                Log.e("weia",getScaleX()+"\n"+getScrollY());
                Log.e("wei",getX()+"\n"+getY());
                mEnd = getScrollY();
                int delta = mEnd - mStart;
                if (delta > 0) {
                    if (delta < h / 3) {

                        mScroller.startScroll(0,getScrollY(),0, -delta);
                    } else {
                        mScroller.startScroll(0, getScrollY(), 0,h
                                - delta);
                    }
                } else {
                    if (Math.abs(delta) < h / 3) {
                        mScroller.startScroll(0, getScrollY(),0, -delta);
                    } else {
                        mScroller.startScroll(0,getScrollY(),0,-h
                                - delta);
                    }
                }
                break;
            default:
                break;
        }
           postInvalidate();
        return true;
        }

    @Override
    public void computeScroll() {
        super.computeScroll();
        if(mScroller.computeScrollOffset()){
            scrollTo(0,mScroller.getCurrY());
        }
        postInvalidate();
    }
}