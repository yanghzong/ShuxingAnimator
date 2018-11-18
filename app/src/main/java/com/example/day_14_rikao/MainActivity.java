package com.example.day_14_rikao;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import javax.xml.datatype.Duration;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnJian;
    private Button btnPing;
    private Button btnSuo;
    private Button btnXuan;
    private Button btnZong;
    private ImageView imgTu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        initData();


    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_jian:
                ObjectAnimator objectAnimator1=ObjectAnimator.ofFloat(imgTu,"alpha",0f,0.3f,0.6f,1f);
                objectAnimator1.setDuration(4000);
                objectAnimator1.start();

                break;
            case R.id.btn_ping:
                ObjectAnimator objectAnimator=ObjectAnimator.ofFloat(imgTu,"translationX",0f,300f);
                objectAnimator.setDuration(4000);
                objectAnimator.start();


                break;
            case R.id.btn_suo:
                ObjectAnimator objectAnimator4=ObjectAnimator.ofFloat(imgTu,"scaleX",1f,0.5f,1f);
                objectAnimator4.setDuration(4000);
                objectAnimator4.start();


                break;
            case R.id.btn_xuan:

                final ObjectAnimator objectAnimator3=ObjectAnimator.ofFloat(imgTu,"rotationY",0f,360f);
                objectAnimator3.setDuration(4000);

                objectAnimator3.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {
                        Toast.makeText(MainActivity.this, "动画开始执行", Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        Toast.makeText(MainActivity.this, "动画结束执行", Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });
                objectAnimator3.start();


                break;
            case R.id.btn_zong:
                ObjectAnimator scaleX=ObjectAnimator.ofFloat(imgTu,"scaleX",0f,0.5f,1f);
                ObjectAnimator alpha=ObjectAnimator.ofFloat(imgTu,"alpha",0f,1f);
                ObjectAnimator rotationY=ObjectAnimator.ofFloat(imgTu,"rotationY",0f,360f);
                AnimatorSet animatorSet=new AnimatorSet();
                animatorSet.play(scaleX).with(alpha).before(rotationY);
                animatorSet.setDuration(4000);
                animatorSet.start();

                break;

        }

    }
    private void initData() {
        btnJian.setOnClickListener(this);
        btnPing.setOnClickListener(this);
        btnSuo.setOnClickListener(this);
        btnXuan.setOnClickListener(this);
        btnZong.setOnClickListener(this);
    }

    private void initView() {
        btnJian = findViewById(R.id.btn_jian);
        btnPing = findViewById(R.id.btn_ping);
        btnSuo = findViewById(R.id.btn_suo);
        btnXuan = findViewById(R.id.btn_xuan);
        btnZong = findViewById(R.id.btn_zong);
        imgTu = findViewById(R.id.img_tu);
    }
}
