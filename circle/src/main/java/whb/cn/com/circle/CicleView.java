package whb.cn.com.circle;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.List;

/**
 * =============================================
 * 在此写用途
 *
 * @version V1.0 <描述当前版本功能>
 * @FileName: whb.cn.com.circle.CicleView.java
 * @author: 魏红彬
 * @e-mail: weihongbin@t-tron.com
 * @date: 2017-03-16 10:30
 */


public class CicleView extends View  {
    private static final String TAG = "CicleView";

    private Paint mPaint;
    private int mWidth = 0;
    private int mHeight = 0;

    private List<Bean> data;



    public CicleView(Context context) {
        super(context);
        init();
    }

    public CicleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public CicleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setColor(Color.GRAY);
        mPaint.setStrokeWidth(4);
        mPaint.setAntiAlias(true);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
        Log.e("333333333", mWidth + "\n" + mHeight);
        if (mWidth > mHeight) {
            mWidth = mHeight;
        } else {
            mHeight = mWidth;
        }
        Log.e("333333333", mWidth + "\n" + mHeight);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF rectF = new RectF();
        rectF.set(0, 0, mWidth, mHeight);
        mPaint.setColor(Color.BLUE);
        canvas.drawRoundRect(rectF, mWidth / 2, mHeight / 2, mPaint);
        //花内院
        RectF rectF2 = new RectF();
        rectF2.set(mWidth / 4, mHeight / 4, mWidth * 3 / 4, mHeight * 3 / 4);
        mPaint.setColor(Color.RED);
        canvas.drawRoundRect(rectF2, mWidth / 4, mHeight / 4, mPaint);
        //画线
        mPaint.setColor(Color.WHITE);
        for(int i=0;i<6;i++){
            canvas.drawLine(mWidth / 2, 0, mWidth / 2, mHeight / 4, mPaint);
            canvas.rotate(60,mWidth/2,mHeight/2);

        }
        for(int i=0;i<12;i++){
            int j=0;
            canvas.rotate(30,mWidth/2,mHeight/2);
            if(i%2==0){
                canvas.drawText(data.get(j).getName(), mWidth/ 2-25, mHeight /8, mPaint);
                j++;
            }

        }
    }

    public void setData(List<Bean> data) {
        this.data = data;
    }



    public interface OnClick{
        void send(int id);
    }
    private OnClick onClick;

    public void setOnClick(OnClick onClick) {
        this.onClick = onClick;
    }
}