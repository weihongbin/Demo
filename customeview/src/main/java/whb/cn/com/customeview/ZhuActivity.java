package whb.cn.com.customeview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import whb.cn.com.customeview.bean.PieData;
import whb.cn.com.customeview.customerview.PieViewChart;
import whb.cn.com.customeview.customerview.ZhuView;

public class ZhuActivity extends AppCompatActivity {
    ZhuView cicleView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhu);
        List<PieData> data=new ArrayList<>();
        for(int i=0;i<6;i++){
            data.add(new PieData(i+"",120*i,0));
        }
        cicleView= (ZhuView) findViewById(R.id.pieViewChart);
        cicleView.setData(data);
        cicleView.setvEach(200);
        cicleView.setvTotal(1000);
        cicleView.setOnItemPieClickListener(new ZhuView.OnItemPieClickListener() {
            @Override
            public void onClick(int position) {
                Toast.makeText(ZhuActivity.this,"点击了"+position,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
