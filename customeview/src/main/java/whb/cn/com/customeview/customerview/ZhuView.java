package whb.cn.com.customeview.customerview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.List;

import whb.cn.com.customeview.bean.PieData;

/**
 * =============================================
 * 在此写用途
 *
 * @version V1.0 <描述当前版本功能>
 * @FileName: whb.cn.com.customeview.customerview.ZhuView.java
 * @author: 魏红彬
 * @e-mail: weihongbin@t-tron.com
 * @date: 2017-03-17 14:26
 */


public class ZhuView extends View {
    private static final String TAG = "ZhuView";

    private Paint mPaint, mPaintText, mPaintLine, mPaintRect;
    //
    private RectF mRectF;
    //参考值
    private int mRadius;
    //整个视图到的大小
    private int mWidth, mHeight;


    //y
    int vTotal = 1000;
    int vEach = 200;

    int lastX=0;
    int lastY=0;
    //first
    int firstLen=0 ;
    //间距
    int length=0;

    int position ;
    //数据源
    private List<PieData> data;


    private float[] angles;

    public ZhuView(Context context) {
        super(context);
        init();
    }

    public ZhuView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public ZhuView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        //big
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.WHITE);
        mPaint.setStyle(Paint.Style.FILL);
        //文字
        mPaintText = new Paint();
        mPaintText.setAntiAlias(true);
        mPaintText.setTextSize(20);
        mPaintText.setColor(Color.BLACK);
        //线
        mPaintLine = new Paint();
        mPaintLine.setAntiAlias(true);
        mPaintLine.setColor(Color.BLACK);
        mPaintLine.setStyle(Paint.Style.FILL);

        //小
        mPaintRect = new Paint();
        mPaintRect.setAntiAlias(true);
        mPaintRect.setColor(Color.BLUE);
        mPaintRect.setStyle(Paint.Style.FILL);

        mRectF = new RectF();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x= (int) event.getX();
        int y= (int) event.getY();

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                lastX=x;
                lastY=y;
                firstLen = x - mRadius /12;
                length=mRadius/4;
                position=firstLen/length;
                if(position>0){
                    if (mOnItemPieClickListener != null) {
                        mOnItemPieClickListener.onClick(position);
                    }
                }

                break;
            case MotionEvent.ACTION_MOVE:
                int lenX=x-lastX;
                int lenY=y-lastY;


                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return super.onTouchEvent(event);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w - getPaddingLeft() - getPaddingRight();
        mHeight = h - getPaddingTop() - getPaddingBottom();
        mRadius = (int) (Math.min(mWidth, mHeight) / 2 * 0.7);
        mRectF.left = -mRadius;
        mRectF.top = -mRadius;
        mRectF.right = mRadius;
        mRectF.bottom = mRadius;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (data == null) {
            return;
        }
        int size = data.size();

         //y
        for (int i = 0; i < 5; i++) {
            canvas.drawLine(mWidth / 2 - mRadius, mHeight / 2 + mRadius - i * mRadius * 2 / 5, mWidth / 2 + mRadius, mHeight / 2 + mRadius - i * mRadius * 2 / 5, mPaintLine);
            canvas.drawText(String.valueOf(vEach * i), mWidth / 2 - mRadius - mPaintText.measureText(String.valueOf(vEach * i)), mHeight / 2 + mRadius - i * mRadius * 2 / 5, mPaintText);
        }
        canvas.drawLine(mWidth / 2 - mRadius, mHeight / 2 - mRadius, mWidth / 2 - mRadius, mHeight / 2 + mRadius, mPaintLine);
        //x
        canvas.drawLine(mWidth / 2 - mRadius, mHeight / 2 + mRadius, mWidth / 2 + mRadius, mHeight / 2 + mRadius, mPaintLine);
        for (int i = 0; i < size; i++) {
            canvas.drawLine(mWidth / 2 - mRadius + i * mRadius * 1 / 3, mHeight / 2 + mRadius, mWidth / 2 - mRadius + i * mRadius / 3, mHeight / 2 + mRadius + 5, mPaintLine);
            canvas.drawText(String.valueOf(i), mWidth / 2 - mRadius + i * mRadius / 3 - mPaintText.measureText(String.valueOf(i)) / 2, mHeight / 2 + mRadius + 20, mPaintText);
            //矩形
            mRectF.left = mWidth / 2 - mRadius + i * mRadius * 1 / 3 - mRadius / 8;
            mRectF.top = mHeight / 2 + mRadius - data.get(i).getValue() / vEach * mRadius * 2 / 5;
            mRectF.right = mWidth / 2 - mRadius + i * mRadius * 1 / 3 + mRadius / 8;
            mRectF.bottom = mHeight / 2 + mRadius;
            canvas.drawRect(new RectF(mRectF), mPaintRect);

        }

    }

    public void setvTotal(int vTotal) {
        this.vTotal = vTotal;
    }

    public void setvEach(int vEach) {
        this.vEach = vEach;
    }

    public void setData(List<PieData> data) {
        this.data = data;
        angles= new float[data.size()];
    }

    private OnItemPieClickListener mOnItemPieClickListener;

    public void setOnItemPieClickListener(OnItemPieClickListener onItemPieClickListener) {
        mOnItemPieClickListener = onItemPieClickListener;
    }

    public interface OnItemPieClickListener {
        void onClick(int position);
    }
}