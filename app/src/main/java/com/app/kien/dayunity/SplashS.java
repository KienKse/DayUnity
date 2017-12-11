package com.app.kien.dayunity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
/**
 * Created by Kien on 10/12/2017.
 */

public class SplashS extends AppCompatActivity {
        private TextView tv;
        private ImageView iv;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_splash);
            tv = (TextView) findViewById(R.id.tv);
            iv = (ImageView) findViewById(R.id.iv);
            Animation anima = AnimationUtils.loadAnimation(this,R.anim.transicao);
            tv.startAnimation(anima);
            iv.startAnimation(anima);
            final Intent i = new Intent(this,MainActivity.class);
            Thread timer = new Thread(){
                public void run(){
                    try{
                        sleep(5000);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                    finally{
                        startActivity(i);
                        finish();
                    }
                }
            };
            timer.start();
        }
}
