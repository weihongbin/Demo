package whb.cn.com.customeview;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.squareup.otto.Produce;

import whb.cn.com.customeview.bean.BusProvider;
import whb.cn.com.customeview.bean.MessageEvent;

public class OttoActivity extends AppCompatActivity {
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otto);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        button = (Button) findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BusProvider.getInstence().post(produceMessageEvent());
                finish();
            }
        });
    }

    @Produce
    public MessageEvent produceMessageEvent() {

        return new MessageEvent("我是好人");
    }

    @Override
    protected void onPause() {
        super.onPause();
        BusProvider.getInstence().unregister(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        BusProvider.getInstence().register(this);
    }


}
