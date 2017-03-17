package whb.cn.com.customeview;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import whb.cn.com.circle.Bean;
import whb.cn.com.circle.CicleView;
import whb.cn.com.customeview.bean.PieData;
import whb.cn.com.customeview.customerview.CommonChartView;
import whb.cn.com.customeview.customerview.Pie;
import whb.cn.com.customeview.customerview.PieViewChart;

public class CricleActivity extends AppCompatActivity {

    //颜色表
    private int[] mColors = {0xFFCCFF00, 0xFF6495ED, 0xFFE32636, 0xFF800000, 0xFF808000, 0xFFFF8C69, 0xFF808080,
            0xFFE6B800, 0xFF7CFC00};

    PieViewChart cicleView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cricle);
        List<PieData> data=new ArrayList<>();
        for(int i=0;i<10;i++){
            data.add(new PieData(i+"",10+20*i,mColors[i%9]));
        }
        cicleView= (PieViewChart) findViewById(R.id.pieViewChart);
        cicleView.setData(data);
        cicleView.setStartAngle(0);
        cicleView.setOnItemPieClickListener(new PieViewChart.OnItemPieClickListener() {
            @Override
            public void onClick(int position) {
                Toast.makeText(CricleActivity.this,"点击了"+position,Toast.LENGTH_SHORT).show();
            }
        });
    }

}
