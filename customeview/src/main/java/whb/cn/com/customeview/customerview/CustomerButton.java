package whb.cn.com.customeview.customerview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Scroller;

/**
 * =============================================
 * 在此写用途
 *
 * @version V1.0 <描述当前版本功能>
 * @FileName: whb.cn.com.customeview.customerview.CustomerButton.java
 * @author: 魏红彬
 * @e-mail: weihongbin@t-tron.com
 * @date: 2017-03-13 16:08
 */


public class CustomerButton extends Button {
    private static final String TAG = "CustomerButton";
    int lastx = 0;
    int lasty = 0;
    Scroller scroller;
    public CustomerButton(Context context) {
        super(context);
    }

    public CustomerButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        scroller=new Scroller(context);
    }

    public CustomerButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                lastx = x;
                lasty = y;
                break;
            case MotionEvent.ACTION_MOVE:
                //计算偏移量
                int offx=x-lastx;
                int offy=y-lasty;
                layout(getLeft()+offx,getTop()+offy,getRight()+offx,getBottom()+offy);
//                offsetLeftAndRight(offx);
//                offsetTopAndBottom(offy);

//                CustomerViewGroup.LayoutParams params = (CustomerViewGroup.LayoutParams) getLayoutParams();
//                 params.leftMargin=getLeft()+offx;
//                 params.topMargin=getTop()+offy;
//                setLayoutParams(params);
//                Log.e("whbw",offx+"\n"+offy);
//                ((View)getParent()).scrollBy(-offx,-offy);


                //重新设置坐标（为准确的获取偏移量）

                lastx=x;
                lasty=y;
                break;
            case MotionEvent.ACTION_UP:
                View view=((View)getParent());
                scroller.startScroll(view.getScrollX(),
                        view.getScrollY(),
                        -view.getScrollX(),
                        -view.getScrollY());
                invalidate();
                break;

        }


        return true;
    }

    @Override
    public void computeScroll() {
        super.computeScroll();
        if(scroller.computeScrollOffset()){
            ((View)getParent()).scrollTo(scroller.getCurrX(),scroller.getCurrY());
            Log.e("whbw",scroller.getCurrX()+"\n"+scroller.getCurrY());
            invalidate();
        }
    }
}