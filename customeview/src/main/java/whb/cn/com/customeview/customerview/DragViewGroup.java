package whb.cn.com.customeview.customerview;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

/**
 * =============================================
 * 在此写用途
 *
 * @version V1.0 <描述当前版本功能>
 * @FileName: whb.cn.com.customeview.customerview.DragViewGroup.java
 * @author: 魏红彬
 * @e-mail: weihongbin@t-tron.com
 * @date: 2017-03-13 17:18
 */


public class DragViewGroup extends FrameLayout {
    private static final String TAG = "DragViewGroup";
    private ViewDragHelper viewDragHelper;

    private View mMenuView,nMainView;

    public DragViewGroup(Context context) {
        super(context);
        initView();
    }



    public DragViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();

    }

    public DragViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {

        viewDragHelper=viewDragHelper.create(this,callback);
    }

    private ViewDragHelper.Callback callback=new ViewDragHelper.Callback() {
        @Override
        public boolean tryCaptureView(View child, int pointerId) {
            return  nMainView==child;
        }

        @Override
        public int clampViewPositionHorizontal(View child, int left, int dx) {
            return left;
        }

        @Override
        public int clampViewPositionVertical(View child, int top, int dy) {
            return 0;
        }

        //拖动后调用
        @Override
        public void onViewReleased(View releasedChild, float xvel, float yvel) {
            super.onViewReleased(releasedChild, xvel, yvel);
            if(nMainView.getLeft()<500){
                viewDragHelper.smoothSlideViewTo(nMainView,0,0);
                ViewCompat.postInvalidateOnAnimation(DragViewGroup.this);
            }else{
                viewDragHelper.smoothSlideViewTo(nMainView,300,0);
                ViewCompat.postInvalidateOnAnimation(DragViewGroup.this);
            }



        }

    };

    @Override
    public void computeScroll() {
        super.computeScroll();

        if(viewDragHelper.continueSettling(true)){
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return viewDragHelper.shouldInterceptTouchEvent(ev);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        viewDragHelper.processTouchEvent(event);
        return true;
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        mMenuView=getChildAt(0);
        nMainView=getChildAt(1);
    }
}