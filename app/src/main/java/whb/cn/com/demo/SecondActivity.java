package whb.cn.com.demo;
/**
 * 内存泄漏测试
 */

import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

Button mBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
         mBtn = (Button) findViewById(R.id.btn);
        ViewCompat.animate(mBtn)
                .setDuration(2000)
                .rotationYBy(1440)
                .x(300)
                .y(600)
                .start();

        testLeak();

    }

    private  static  Runnable MyRu=new Runnable() {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };

    /**
     * 测试内存泄漏的代码
     */
    private static void testLeak() {
        new Thread(MyRu).start();
    }

    /**
     * 回收
     */
    public void finalize() {

        Log.e("whb","123333333333333333");

    }
    }

