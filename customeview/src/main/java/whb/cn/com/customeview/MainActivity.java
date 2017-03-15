package whb.cn.com.customeview;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import com.squareup.otto.Subscribe;

import whb.cn.com.customeview.bean.BusProvider;
import whb.cn.com.customeview.bean.MessageEvent;
import whb.cn.com.customeview.customerview.CustomerButton;
import whb.cn.com.customeview.customerview.SlideView;

public class MainActivity extends AppCompatActivity {


    CustomerButton mTextView;

    ImageView imageView;
    private int width = 300;
    private int height = 300;
    private SlideView mRightScrollView;
    private ListView mMenuList;
    private ArrayAdapter<String> mAdapter;
    private Button mShowMenuBtn;
    private String[] data={"附近的人", "我的资料", "设置", "游戏"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BusProvider.getInstence().register(this);
        mRightScrollView = (SlideView) findViewById(R.id.rightscrollview_test);
        View menu = LayoutInflater.from(MainActivity.this).inflate(
                R.layout.rightscrollview_menu, null);
        final View primary = LayoutInflater.from(MainActivity.this).inflate(
                R.layout.rightscrollview_primary, null);
        mMenuList = (ListView) menu.findViewById(R.id.list_right_menu);
        mShowMenuBtn = (Button) primary.findViewById(R.id.btn_showmenu);
//        imageView = (ImageView) findViewById(R.id.imageView);
//        imageView.setImageBitmap(getBitmap());
        mAdapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data);
        mMenuList.setAdapter(mAdapter);

        mShowMenuBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
               if(mRightScrollView.isShow()){
                   mRightScrollView.hide();
               }else{
                   mRightScrollView.show();
               }
            }
        });
        mRightScrollView.setOnMenuChangedLister(new SlideView.OnMenuChangerLister() {
            @Override
            public void onChanged(boolean isShow) {
                if (isShow) {
                    mShowMenuBtn.setText("隐藏菜单");
                } else {
                    mShowMenuBtn.setText("显示菜单");
                }
            }
        });

        mRightScrollView.setmMenu(menu);
        mRightScrollView.setmMainView(primary);
        mMenuList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        primary.setBackgroundColor(Color.CYAN);
                        break;
                    case 1:
                        primary.setBackgroundColor(Color.BLUE);
                        break;
                    case 2:
                        primary.setBackgroundColor(Color.GRAY);
                        break;
                    case 3:
                        primary.setBackgroundColor(Color.MAGENTA);
                        break;

                }
            }
        });


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
