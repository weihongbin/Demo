package whb.cn.com.annotation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.lang.reflect.Method;

import whb.cn.com.annotation.utils.Test;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Class cls = Person.class;
        for (Method method : cls.getMethods()) {
            Test methodInfo = method.getAnnotation(Test.class);

            if(method.getName().equals("toString")){

                Log.e("whb",methodInfo.toString());
            }
            if (methodInfo != null) {
                Log.e("whb","method name:" + method.getName()+"\n"+
                        "method id:" + methodInfo.id()+"\n"+
                        "method age:" + methodInfo.age()+"\n"+
                        "method desc:" + methodInfo.desc());

            }
        }
    }
}
