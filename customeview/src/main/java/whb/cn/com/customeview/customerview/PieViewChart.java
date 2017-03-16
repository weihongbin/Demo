package whb.cn.com.customeview.customerview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.Arrays;
import java.util.List;

import whb.cn.com.customeview.bean.PieData;

/**
 * =============================================
 * 在此写用途
 *
 * @version V1.0 <描述当前版本功能>
 * @FileName: whb.cn.com.customeview.customerview.PieViewChart.java
 * @author: 魏红彬
 * @e-mail: weihongbin@t-tron.com
 * @date: 2017-03-16 18:04
 */


public class PieViewChart extends View {
    private static final String TAG = "PieViewChart";
    //画笔
    private Paint mPaint;

    //化扇形
    private RectF mRectF;

    //整个视图到的大小
    private int mWidth, mHeight;

    //半径
    private  float mRadius;
    //开始的角度
    private int startAngle=0;
    //扫过的角度
    private float sweepAngle=0;

    //数据源
    private List <PieData> data;
    private float mTotal=0;
    private float[] angles;
    private int position=0;

    public PieViewChart(Context context) {
        super(context);
        init();
    }

    public PieViewChart(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PieViewChart(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    /**
     * 初始化
     */
    private void init(){
        mPaint=new Paint();
        mPaint.setAntiAlias(true);//消除锯齿
        mPaint.setStyle(Paint.Style.FILL);
        mRectF=new RectF();
    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth=w-getPaddingLeft()-getPaddingRight();
        mHeight=h-getPaddingTop()-getPaddingBottom();

        mRadius = (float) (Math.min(mWidth,mHeight)/2*0.7);

        mRectF.left = -mRadius;
        mRectF.top = -mRadius;
        mRectF.right = mRadius;
        mRectF.bottom = mRadius;

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(data==null){
            return;
        }
        canvas.translate(mWidth/2,mHeight/2);
        int size=data.size();
        for(int i=0;i<size;i++){
            mPaint.setColor(data.get(i).getColor());
            sweepAngle=data.get(i).getValue()/mTotal*360;
            canvas.drawArc(mRectF,startAngle,sweepAngle,true,mPaint);
            startAngle+=sweepAngle;
        }

    }



    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                float x = event.getX()-(mWidth/2);
                float y = event.getY()-(mHeight/2);
                float touchAngle = 0;
                if (x<0&&y<0){  //2 象限
                    touchAngle += 180;
                }else if (y<0&&x>0){  //1象限
                    touchAngle += 360;
                }else if (y>0&&x<0){  //3象限
                    touchAngle += 180;
                }
                //Math.atan(y/x) 返回正数值表示相对于 x 轴的逆时针转角，返回负数值则表示顺时针转角。
                //返回值乘以 180/π，将弧度转换为角度。
                touchAngle +=Math.toDegrees(Math.atan(y/x));
                if (touchAngle<0){
                    touchAngle = touchAngle+360;
                }
                float touchRadius = (float) Math.sqrt(y*y+x*x);
                if (touchRadius< mRadius){
                    position = -Arrays.binarySearch(angles,(touchAngle))-1;
                    if(mOnItemPieClickListener!=null){
                        mOnItemPieClickListener.onClick(position-1);
                    }
                }

                break;
        }
        return super.onTouchEvent(event);
    }

    /**
     * 设置数据
     * @param startAngle
     */
    public void setStartAngle(int startAngle) {
        this.startAngle = startAngle;
    }

    public void setData(List<PieData> data) {
        this.data = data;
        for(PieData pieData:data){
            mTotal+=pieData.getValue();
        }
        angles=new float[data.size()];
        invalidate();
    }
    private OnItemPieClickListener mOnItemPieClickListener;

    public void setOnItemPieClickListener(OnItemPieClickListener onItemPieClickListener) {
        mOnItemPieClickListener = onItemPieClickListener;
    }

    public interface OnItemPieClickListener {
        void onClick(int position);
    }
}