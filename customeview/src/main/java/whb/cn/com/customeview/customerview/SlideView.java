package whb.cn.com.customeview.customerview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Scroller;

/**
 * =============================================
 * 在此写用途
 *
 * @version V1.0 <描述当前版本功能>
 * @FileName: whb.cn.com.customeview.customerview.SlideView.java
 * @author: 魏红彬
 * @e-mail: weihongbin@t-tron.com
 * @date: 2017-03-15 17:26
 */


public class SlideView extends ViewGroup {
    private static final String TAG = "SlideView";

    private View mMainView,mMenu;
    private Scroller scroller;
    private int mWidth=0;
    private int mHeight=0;
    private float mMenuWeight=0.8f;
    private int lastX=0;
    private boolean mIsShowMenu=false;
    private OnMenuChangerLister listener;

    public SlideView(Context context) {
        super(context);
    }

    public SlideView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public SlideView(Context context, AttributeSet attrs) {
        super(context, attrs);
        scroller=new Scroller(context);
        Log.e("wwwwwww",">>>>>>>>>>>>>>>>>>>>>>>");
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mWidth=MeasureSpec.getSize(widthMeasureSpec);
        mHeight= MeasureSpec.getSize(heightMeasureSpec);//获取测量值
//        onMeasure传入的两个参数是由上一层控件传入的大小，有多种情况，重写该方法时需要对计算控件的实际大小，
//        * 然后调用setMeasuredDimension(int, int)设置实际大小。
         setMeasuredDimension(mWidth,mHeight);//获取实际大小

        int mainWidth = MeasureSpec.makeMeasureSpec(mWidth, MeasureSpec.EXACTLY);
        int menuWidth = MeasureSpec.makeMeasureSpec((int) (mWidth * mMenuWeight), MeasureSpec.EXACTLY);


        int height = MeasureSpec.makeMeasureSpec(mHeight, MeasureSpec.EXACTLY);

        mMainView.measure(mainWidth,height);
        mMenu.measure(menuWidth,height);

    }

    @Override
    protected void onLayout(boolean b, int i, int i1, int i2, int i3) {
        mMenu.layout(-(int) (mWidth * mMenuWeight), 0, 0, mHeight);
        mMainView.layout(0, 0, mWidth, mHeight);
    }


      //传入参数

    public void setmMainView(View mMainView) {
        this.mMainView = mMainView;
        addView(mMainView);
    }

    public void setmMenu(View mMenu) {
        this.mMenu = mMenu;
        addView(mMenu);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x= (int) event.getX();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                lastX=x;
                break;
            case MotionEvent.ACTION_MOVE:

                break;
            case MotionEvent.ACTION_UP:
                int len=x-lastX;
                if(Math.abs(len)> (mWidth * mMenuWeight / 2)){
                    if(len>0){
                        show();
                    }else{
                        hide();
                    }
                }
                break;
        }


        return true;
    }

    /**
     * 标志
     * @return
     */
    public boolean isShow(){

        return  mIsShowMenu;
    }

    public void hide() {
        if (!mIsShowMenu) {
            return;
        }
        mIsShowMenu = false;
        int dx = (int) (mWidth * mMenuWeight);
        scroller.startScroll(getScrollX(), 0, dx, 0, 500);
        if (listener != null) {
            listener.onChanged(mIsShowMenu);
        }
        invalidate();
    }

    public void show() {

        if (mIsShowMenu) {
            return;
        }
        mIsShowMenu = true;// 标记菜单已经显示
        int dx = (int) (mWidth * mMenuWeight);
        scroller.startScroll(getScrollX(), 0, -dx, 0, 500);
        if (listener != null) {
            listener.onChanged(mIsShowMenu);
        }

        invalidate();
    }

    // 在操作界面，当显示menu的时候要做什么事和隐藏menu要做什么事
    public interface OnMenuChangerLister {
         void onChanged(boolean isShow);
    }

    public void setOnMenuChangedLister(OnMenuChangerLister listener) {
        this.listener = listener;
    }

    @Override
    public void computeScroll() {
        super.computeScroll();
        if (scroller.computeScrollOffset()) {
            scrollTo(scroller.getCurrX(), scroller.getCurrY());
            postInvalidate();
        }
    }
}