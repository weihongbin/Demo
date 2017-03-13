package whb.cn.com.animotion;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.imageView);
        //透明度动画
//        AlphaAnimation alphaAnimation=new AlphaAnimation(0,1);
//        alphaAnimation.setDuration(2000);
//        //旋转动画
//        RotateAnimation alphaAnimation=new RotateAnimation(0,720,50,50);
//        alphaAnimation.setDuration(2000);
//        //位移动画
//        TranslateAnimation alphaAnimation=new TranslateAnimation(0,200,0,300);
//        alphaAnimation.setDuration(2000);
//        //缩放动画
//        ScaleAnimation alphaAnimation=new ScaleAnimation(0,2,0,2);
//        alphaAnimation.setDuration(2000);

        //动画集合
//        AnimationSet as=new AnimationSet(true);
//        as.setDuration(3000);
//        AlphaAnimation alphaAnimation=new AlphaAnimation(0,1);
//        alphaAnimation.setDuration(3000);
//        as.addAnimation(alphaAnimation);
//        RotateAnimation alphaAnimation1=new RotateAnimation(0,720,50,50);
//        alphaAnimation1.setDuration(3000);
//        as.addAnimation(alphaAnimation1);
//        TranslateAnimation alphaAnimation2=new TranslateAnimation(0,200,0,300);
//        alphaAnimation2.setDuration(3000);
//        as.addAnimation(alphaAnimation2);

        final Animation animation = AnimationUtils.loadAnimation(this, R.anim.alpha);
        final Animation animation2 = AnimationUtils.loadAnimation(this, R.anim.scale);
        final Animation animation3 = AnimationUtils.loadAnimation(this, R.anim.tranlate);
        final Animation animation4 = AnimationUtils.loadAnimation(this, R.anim.rotate);
        final AnimationSet animationSet = (AnimationSet) AnimationUtils.loadAnimation(this, R.anim.anim_set);
        imageView.setImageResource(R.drawable.anim_list);
        final AnimationDrawable animationDrawable = (AnimationDrawable) imageView.getDrawable();
        final AnimationDrawable anim = new AnimationDrawable();
        for (int i = 1; i <= 6; i++) {
            int id = getResources().getIdentifier("w" + i, "mipmap", getPackageName());
            Drawable drawable = getResources().getDrawable(id);
            anim.addFrame(drawable, 200);
        }
        anim.setOneShot(false);
        imageView.setImageDrawable(anim);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                anim.start();

                startActivity(new Intent(MainActivity.this,ThirdActivity.class));
                overridePendingTransition(android.R.anim.slide_in_left  ,android.R.anim.slide_out_right  );
            }
        });
    }
}
