package com.live.quanmin.anim_new;

import android.support.animation.DynamicAnimation;
import android.support.animation.SpringAnimation;
import android.support.animation.SpringForce;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mIvAnim;
    private View mBtn1;
    private SpringAnimation mSpringAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mIvAnim = (ImageView) findViewById(R.id.iv_anim);
        mBtn1 = findViewById(R.id.btn_1);

        mIvAnim.setOnClickListener(this);
        mBtn1.setOnClickListener(this);

        mSpringAnimation = new SpringAnimation(mIvAnim, DynamicAnimation.X);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_1:

                mSpringAnimation.setStartVelocity(20000);

                SpringForce springForce = new SpringForce();
                springForce.setDampingRatio(SpringForce.DAMPING_RATIO_HIGH_BOUNCY);
                springForce.setStiffness(SpringForce.STIFFNESS_LOW);
                springForce.setFinalPosition(mIvAnim.getX());

                mSpringAnimation.setSpring(springForce);
                mSpringAnimation.start();
                break;

            case R.id.iv_anim:
                Toast.makeText(this, "click", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
