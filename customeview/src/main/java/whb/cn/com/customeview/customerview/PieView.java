package whb.cn.com.customeview.customerview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;

import whb.cn.com.customeview.R;

/**
 * =============================================
 * 在此写用途
 *
 * @version V1.0 <描述当前版本功能>
 * @FileName: whb.cn.com.customeview.customerview.PieView.java
 * @author: 魏红彬
 * @e-mail: weihongbin@t-tron.com
 * @date: 2017-03-14 12:46
 */

/**
 * 步骤	关键字	作用
 * 1	构造函数	初始化(初始化画笔Paint)
 * 2	onMeasure	测量View的大小(暂时不用关心)
 * 3	onSizeChanged	确定View大小(记录当前View的宽高)
 * 4	onLayout	确定子View布局(无子View，不关心)
 * 5	onDraw	实际绘制内容(绘制饼状图)
 * 6	提供接口	提供接口(提供设置数据的接口)
 */

public class PieView extends Button {
    private static final String TAG = "PieView";

    /**
     * 画笔
     *
     * @param context
     */
    private Paint mPaint;
    private int width = 0;
    private int height = 0;
    private Rect mBound;
    private String text;

    private int mTitleTextColor;

    private int mTitleTextSize;

    public PieView(Context context) {
        super(context);
        init(context,null,0);
    }

    public PieView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context,attrs,defStyleAttr);
    }

    public PieView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs,0);
    }


    public void init(Context context,AttributeSet attrs,int defStyle){
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.CustomTitleView, defStyle, 0);
        int n = a.getIndexCount();
        for (int i = 0; i < n; i++)
        {
            int attr = a.getIndex(i);
            switch (attr)
            {
                case R.styleable.CustomTitleView_titleText:
                    text = a.getString(attr);
                    break;
                case R.styleable.CustomTitleView_titleTextColor:
                    // 默认颜色设置为黑色
                    mTitleTextColor = a.getColor(attr, Color.BLACK);
                    break;
                case R.styleable.CustomTitleView_titleTextSize:
                    // 默认设置为16sp，TypeValue也可以把sp转化为px
                    mTitleTextSize = a.getDimensionPixelSize(attr, (int) TypedValue.applyDimension(
                            TypedValue.COMPLEX_UNIT_SP, 16, getResources().getDisplayMetrics()));
                    break;

            }

        }
        a.recycle();

        mPaint = new Paint();
        mPaint.setColor(Color.BLUE);
        mPaint.setAntiAlias(true);
        mBound = new Rect();
        mPaint.setTextSize(mTitleTextSize);
        mPaint.getTextBounds(text, 0, text.length(), mBound);//

    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int mode = MeasureSpec.getMode(widthMeasureSpec);
        int size = MeasureSpec.getSize(widthMeasureSpec);
        int mode1 = MeasureSpec.getMode(heightMeasureSpec);
        int size1 = MeasureSpec.getSize(heightMeasureSpec);

        //确定值
        if (mode == MeasureSpec.EXACTLY) {
            width = size;
        } else {
            //假定一个合适的值
           int  width1 = mBound.width()+10;
            //wrap
            if (mode == MeasureSpec.AT_MOST) {
                //返回最小的值
                width = Math.min(width1, size);
            }
        }
        if (mode1 == MeasureSpec.EXACTLY) {
            height = size1;
        } else {
            //假定一个合适的值
            int height2 = mBound.height()+10;
            //wrap
            if (mode1 == MeasureSpec.AT_MOST) {
                //返回最小的值
                height = Math.min(height2, size1);
            }
        }
        setMeasuredDimension(width, height);

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width = w;
        height = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Bitmap bm = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        canvas.drawBitmap(bm, new Matrix(), mPaint);
        canvas.drawRect(0, 0, width, height, mPaint);
        mPaint.setColor(mTitleTextColor);
        canvas.drawText(text, width / 2-mBound.width()/2, height /2+mBound.height()/2, mPaint);
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setmTitleTextColor(int mTitleTextColor) {
        this.mTitleTextColor = mTitleTextColor;
    }

    public void setmTitleTextSize(int mTitleTextSize) {
        this.mTitleTextSize = mTitleTextSize;
    }
}