package whb.cn.com.customeview.RxJava;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import whb.cn.com.customeview.R;

/**
 * =============================================
 * 在此写用途
 *
 * @version V1.0 <描述当前版本功能>
 * @FileName: whb.cn.com.customeview.RxJava.RxJava1.java
 * @author: 魏红彬
 * @date: 2017-03-10 16:22
 */
public class RxJava1 extends AppCompatActivity {
    private static final String TAG = "RxJava1";

    TextView tvContent;
    StringBuilder sb;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java1);
        tvContent = (TextView) findViewById(R.id.tv_Content);
    }

    public void createClick(View v) {
        sb = new StringBuilder();
        Flowable.create(new FlowableOnSubscribe<Integer>() {
            @Override
            public void subscribe(FlowableEmitter<Integer> subscriber) throws Exception {
                for (int i = 0; i < 5; i++) {
                    int temp = new Random().nextInt(10);
                    if (temp > 8) {
                        //if value>8, we make an error
                        subscriber.onError(new Throwable("value >8"));
                        break;
                    } else {
                        subscriber.onNext(temp);
                    }
                    // on error,complete the job
                    if (i == 4) {
                        subscriber.onComplete();
                    }
                }
            }
        }, BackpressureStrategy.BUFFER).subscribe(new Subscriber<Integer>() {
            @Override
            public void onSubscribe(Subscription s) {
                System.out.println("onSubscribe");
                s.request(Long.MAX_VALUE);
            }

            @Override
            public void onComplete() {
                sb.append("onCompleted()");
                tvContent.setText(sb.toString());
            }

            @Override
            public void onError(Throwable e) {
                sb.append("onError(): " + e.getMessage());
                tvContent.setText(sb.toString());
            }

            @Override
            public void onNext(Integer integer) {
                sb.append("onNext(): " + integer + "\n");
            }
        });
    }

    //    defer操作符是直到有订阅者订阅时，才通过Observable的工厂方法创建Observable并执行，defer操作符能够保证Observable的状态是最新的
    public void deferClick(View v) {
        sb = new StringBuilder();
        Flowable.defer(new Callable<Publisher<String>>() {
            @Override
            public Publisher<String> call() throws Exception {
                return Flowable.just("hello RxJava 2");
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(@NonNull String s) throws Exception {
                sb.append("onError(): " + s);
                tvContent.setText(sb.toString());
            }
        });
    }
//    上面一大串代码仅仅就达到了打印两个字符串的效果，你可能会想:”RxJava只不过是把事情变复杂了”。
//    或许是这样的，但RxJava也提供了很多便利的方法来做这种简单的事情。
//
//    Flowable<String> flowable = Flowable.just("hello RxJava 2")；
//    我们可以直接调用Flowable.just创建一个发射字符串的”发射器”。
//
//    而对于 Subscriber 来说，我们目前仅仅关心onNext方法。所以可以简写成下面这样。
//
//    Consumer consumer = new Consumer<String>() {
//        @Override
//        public void accept(String s) throws Exception {
//            System.out.println(s);
//        }
//    };

    //just最多只能有10个参数
    public void justClick(View v) {
        sb = new StringBuilder();
        Flowable.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(@NonNull Integer integer) throws Exception {
                        sb.append(integer);
                        tvContent.setText(sb.toString());
                    }
                });
    }

    //FROM任意个参数
    public void fromClick(View v) {
        sb = new StringBuilder();
        Flowable.fromArray(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 22, 12, 12, 12, 12, 12, 12, 45)
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(@NonNull Integer integer) throws Exception {
                        sb.append(integer);
                        tvContent.setText(sb.toString());
                    }
                });
    }

    //    timer
//
//    timer操作符是创建一串连续的数字，产生这些数字的时间间隔是一定的；这里有两种情况：
//
//    一种是隔一段时间产生一个数字，然后就结束，可以理解为延迟产生数字
//
//    一种是每隔一段时间就产生一个数字，没有结束符，也就是是可以产生无限个连续的数字
//    timer操作符默认情况下是运行在一个新线程上的，当然你可以通过传入参数来修改其运行的线程。
    public void timerClick(View view) {
        sb = new StringBuilder();
        Flowable.timer(1, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(@NonNull Long aLong) throws Exception {
                        sb.append(aLong);
                        tvContent.setText(sb.toString());
                    }
                });
    }
    //    interval
//
//    interval操作符是每隔一段时间就产生一个数字，这些数字从0开始，一次递增1直至无穷大；interval操作符的实现效果跟上面的timer操作符的第二种情形一样。

    //    RxJava的特色就是可以改变他的任务线程，可以很优雅的在子线程和主线程中切换，而切换用到的两个主要方法是subscribeOn()和observeOn().
//subscribeOn()主要改变的是订阅的线程。即call()执行的线程
//    ObserveOn()主要改变的是发送的线程。即onNext()执行的线程。
    public void intervalClick(View view) {
        sb = new StringBuilder();
        Flowable.interval(1, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(@NonNull Long aLong) throws Exception {
                        sb.append(aLong);
                        tvContent.setText(sb.toString());
                    }
                });
    }

    public void repeatClick(View v) {
        sb = new StringBuilder();
        Flowable.just(1).repeat(5)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Integer>() {
                    @Override
                    public void onSubscribe(Subscription s) {
                        s.request(Long.MAX_VALUE);
                    }

                    @Override
                    public void onComplete() {
                        sb.append("onCompleted(): \n");
                        tvContent.setText(sb.toString());
                    }

                    @Override
                    public void onError(Throwable e) {
                        sb.append("onError(): " + e.getMessage() + "\n");
                        tvContent.setText(sb.toString());
                    }

                    @Override
                    public void onNext(Integer i) {
                        sb.append("repeat(): " + i + "\n");
                        tvContent.setText(sb.toString());
                    }
                });
    }

//    range
//
//    range操作符是创建一组在从n开始，个数为m的连续数字，比如range(3,10)，就是创建3、4、5…12的一组数字
//
//    调用例子如下：


    public void rangeClick(View v) {
        sb = new StringBuilder();
        Flowable.range(1, 12)
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(@NonNull Integer integer) throws Exception {
                        sb.append("rangeClick(): " + integer + "\n");
                        tvContent.setText(sb.toString());
                    }
                });
    }



    public void mapClick(View v) {
        sb = new StringBuilder();
        Flowable.just(1, 2, 3, 4, 5, 6, 7, 8, 9)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Function<Integer, String>() {
            @Override
            public String apply(@NonNull Integer integer) throws Exception {
                return "map(): " + integer;
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(@NonNull String s) throws Exception {
                sb.append("onNext(): " + s + "\n");
                tvContent.setText(sb.toString());
            }
        });
    }

    public void flatMapClick(View v) {
        sb = new StringBuilder();
        sb = new StringBuilder();
        Flowable.just(1, 2, 3, 4, 5, 6, 7, 8, 9)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap(new Function<Integer, Publisher<String>>() {
            @Override
            public Publisher<String> apply(@NonNull Integer integer) throws Exception {
                return Flowable.just("flatmap(): " + integer);
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(@NonNull String s) throws Exception {
                sb.append("onNext(): " + s + "\n");
                tvContent.setText(sb.toString());
            }
        });
    }


}
//}