package whb.cn.com.customeview.customerview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

/**
 * =============================================
 * 并排控件
 *
 * @version V1.0 <描述当前版本功能>
 * @FileName: whb.cn.com.customeview.customerview.Test1.java
 * @author: 魏红彬
 * @e-mail: weihongbin@t-tron.com
 * @date: 2017-03-15 15:31
 */


public class Test1 extends ViewGroup {
    private static final String TAG = "Test1";

    public Test1(Context context) {
        super(context);
    }

    public Test1(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Test1(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
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
        int layoutWidth=0;//已占据的
        int layoutHeight=0;
        int measureWidth=0;//控件测量
        int measureHeight=0;


        int maxLength=0;//最高的kongjian
        int count = getChildCount();
        View child;
        Log.e("ri", count + "");
        for (int i = 0; i < count; i++) {
            child = getChildAt(i);

            measureWidth=child.getMeasuredWidth();
            measureHeight=child.getMeasuredHeight();

            if (layoutWidth+measureWidth< getWidth()) {//当前行
                l=layoutWidth;
                r=l+measureWidth;
                t=layoutHeight;
                b=t+measureHeight;
            } else {
                layoutWidth=0;
                layoutHeight+=maxLength;
                maxLength=0;

                l=layoutWidth;
                r=l+measureWidth;
                t=layoutHeight;
                b=t+measureHeight;
            }
            if(measureHeight>maxLength){
                maxLength=measureHeight;
            }
            layoutWidth += measureWidth;
            child.layout(l, t, r, b);
        }
    }
}