package whb.cn.com.customeview;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.squareup.otto.Subscribe;

import whb.cn.com.customeview.bean.BusProvider;
import whb.cn.com.customeview.bean.MessageEvent;
import whb.cn.com.customeview.customerview.CustomerButton;

public class MainActivity extends AppCompatActivity {


    CustomerButton mTextView;

    ImageView imageView;
    private int width = 300;
    private int height = 300;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BusProvider.getInstence().register(this);

        imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setImageBitmap(getBitmap());


    }

    private Bitmap getBitmap() {
        Bitmap bm = Bitmap.createBitmap(400, 400, Bitmap.Config.ARGB_8888);

        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.GREEN);
        paint.setStrokeWidth(4);

        Canvas canvas = new Canvas(bm);

/**
 * 花点
 */

        canvas.drawPoint(4, 4, paint);     //在坐标(200,200)位置绘制一个点
        canvas.drawPoints(new float[]{          //绘制一组点，坐标位置由float数组指定
                50 * 2, 50 * 2,
                80 * 2, 80 * 2,
                150 * 2, 150 * 2
        }, paint);
        /**
         * 画线
         */
        canvas.drawLine(300, 300, 600, 600, paint);    // 在坐标(300,300)(500,600)之间绘制一条直线
        canvas.drawLines(new float[]{               // 绘制一组线 每四数字(两个点的坐标)确定一条线
                100, 200, 200, 200,
                100, 300, 200, 300
        }, paint);

//        /**
//         * 矩形
//         * F浮点型
//         */
//        RectF rectF = new RectF(100,100,400,400);
//        canvas.drawRect(rectF,paint);
        //圆角矩形
        RectF rectF = new RectF(100,100,300,300);
////        canvas.drawRoundRect(rectF,100,100,paint);
//        canvas.drawRoundRect(rectF,80,150,paint);
        // 绘制圆弧
        paint.setColor(Color.BLUE);
        canvas.drawArc(rectF,0,90,true,paint);

        //画贝塞尔曲线
        canvas.drawText("画贝塞尔曲线:", 10, 310, paint);
        paint.reset();
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.GREEN);
        Path path2=new Path();
        path2.moveTo(100, 320);//设置Path的起点
        path2.quadTo(150, 310, 170, 400); //设置贝塞尔曲线的控制点坐标和终点坐标
        canvas.drawPath(path2, paint);//画出贝塞尔曲线
        return bm;
    }

    @Subscribe()
    public void showEvent(MessageEvent event) {
        mTextView.setText(event.getContent());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        BusProvider.getInstence().unregister(this);
    }

}
