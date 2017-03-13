package whb.cn.com.animotion;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.PointF;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;

public class ThirdActivity extends AppCompatActivity {

    ImageView image;
    int mScreenHeight;
    ObjectAnimator mTimeAnim;
    Button button;
    TimerBtnWrapper bw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mScreenHeight=getResources().getDisplayMetrics().heightPixels;
        image= (ImageView) findViewById(R.id.image);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Animator anim = AnimatorInflater.loadAnimator(getApplicationContext(), R.anim.property_anim);
//
//                anim.setTarget(image);
//
//                anim.start();
                startActivity(new Intent(ThirdActivity.this,LaoutActivity.class));
                overridePendingTransition(android.R.anim.slide_in_left  ,android.R.anim.slide_out_right  );
            }
        });
        button= (Button) findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                play(view);
            }
        });
        bw=new TimerBtnWrapper(button);
    }

    private void play(final View view) {
//        ObjectAnimator//
//                .ofFloat(view, "rotationY", 0.0F, 360.0F)//
//                .setDuration(500)//
//                .start();

//        PropertyValuesHolder pvhX = PropertyValuesHolder.ofFloat("alpha", 1f,
//                0f, 1f);
//        PropertyValuesHolder pvhY = PropertyValuesHolder.ofFloat("scaleX", 1f,
//                0, 1f);
//        PropertyValuesHolder pvhZ = PropertyValuesHolder.ofFloat("scaleY", 1f,
//                0, 1f);
//        ObjectAnimator.ofPropertyValuesHolder(view, pvhX, pvhY,pvhZ).setDuration(1000).start();
//        ObjectAnimator anim = ObjectAnimator//
//                .ofFloat(view, "zhy22222222222222222", 1.0F,  0.0F)//
//                .setDuration(1000);//
//        anim.setRepeatMode(ValueAnimator.INFINITE);
//        anim.start();
//        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
//        {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation)
//            {
//                float cVal = (Float) animation.getAnimatedValue();
//                view.setAlpha(cVal);
//                view.setScaleX(cVal);
//                view.setScaleY(cVal);
//            }
//        });
//
//        在动画执行初始时，值是0；在这里即旋转的度数0°。
//        在动画执行到1/2时，值是360。
//        在动画执行到1时，及结束，值是0.
//        Keyframe kf0 = Keyframe.ofFloat(0f, 0f);
//        Keyframe kf1 = Keyframe.ofFloat(0.5f, 360f);
//        Keyframe kf2 = Keyframe.ofFloat(1f, 0f);
//        PropertyValuesHolder pvhRotation = PropertyValuesHolder.ofKeyframe("rotation", kf0, kf1, kf2);
//        ObjectAnimator rotationAnim = ObjectAnimator.ofPropertyValuesHolder(image, pvhRotation);
//        rotationAnim.setDuration(5000);
//        rotationAnim.start();
////
//        mTimeAnim = ObjectAnimator.ofInt(bw,"timer",60,0).setDuration(60*1000);
//
//        //修改插值器，即数值改变速率平均
//        mTimeAnim.setInterpolator(new LinearInterpolator());
//
//        //设置动画监听
//        mTimeAnim.addListener(new Animator.AnimatorListener() {
//            @Override
//            public void onAnimationStart(Animator animator) {
//                bw.setIsClick(false);
//            }
//
//            @Override
//            public void onAnimationEnd(Animator animator) {
//                bw.setIsClick(true);
//                bw.setTimeEndText("重新获取");
//            }
//
//            @Override
//            public void onAnimationCancel(Animator animator) {
//
//            }
//
//            @Override
//            public void onAnimationRepeat(Animator animator) {
//
//            }
//        });
//        mTimeAnim.start();
    }
    /**
     * 自由落体
     * @param view
     */
    public void verticalRun( View view)
    {

        ValueAnimator animator = ValueAnimator.ofFloat(0, mScreenHeight
                - image.getHeight());
        animator.setTarget(image);
        animator.setDuration(1000).start();
        animator.setInterpolator(new AccelerateInterpolator());
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
        {
            @Override
            public void onAnimationUpdate(ValueAnimator animation)
            {
                image.setTranslationY((Float) animation.getAnimatedValue());
            }
        });
    }
    /**
     * 抛物线
     * @param view
     */
    public void paowuxian(View view)
    {

        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setDuration(3000);
        valueAnimator.setObjectValues(new PointF(0, 0));
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.setEvaluator(new TypeEvaluator<PointF>()
        {
            // fraction = t / duration
            @Override
            public PointF evaluate(float fraction, PointF startValue,
                                   PointF endValue)
            {
                Log.e("wwwwwwwwwwwwwwwwwwww", fraction * 3 + "");
                // x方向200px/s ，则y方向0.5 * 10 * t
                PointF point = new PointF();
                point.x = 200 * fraction * 3;
                point.y = 0.5f * 200 * (fraction * 3) * (fraction * 3);
                return point;
            }
        });

        valueAnimator.start();
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
        {
            @Override
            public void onAnimationUpdate(ValueAnimator animation)
            {
                PointF point = (PointF) animation.getAnimatedValue();
                image.setX(point.x);
                image.setY(point.y);

            }
        });
    }

    public void togetherRun(View view)
    {
        ObjectAnimator anim1 = ObjectAnimator.ofFloat(image, "scaleX",
                1.0f, 2f);
        ObjectAnimator anim2 = ObjectAnimator.ofFloat(image, "scaleY",
                1.0f, 2f);
        AnimatorSet animSet = new AnimatorSet();
        animSet.setDuration(2000);
        animSet.setInterpolator(new LinearInterpolator());
        //两个动画同时执行
        animSet.playTogether(anim1, anim2);
        animSet.start();
    }

    public void playWithAfter(View view)
    {
        float cx = image.getX();

        ObjectAnimator anim1 = ObjectAnimator.ofFloat(image, "scaleX",
                1.0f, 2f);
        ObjectAnimator anim2 = ObjectAnimator.ofFloat(image, "scaleY",
                1.0f, 2f);
        ObjectAnimator anim3 = ObjectAnimator.ofFloat(image,
                "x",  cx ,  0f);
        ObjectAnimator anim4 = ObjectAnimator.ofFloat(image,
                "x", cx);

        /**
         * anim1，anim2,anim3同时执行
         * anim4接着执行
         */
        AnimatorSet animSet = new AnimatorSet();
        animSet.play(anim1).with(anim2);
        animSet.play(anim2).with(anim3);
        animSet.play(anim4).after(anim3);
        animSet.setDuration(1000);
        animSet.start();
    }


}
