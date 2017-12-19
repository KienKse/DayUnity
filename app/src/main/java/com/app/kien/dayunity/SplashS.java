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
        private TextView textView;
        private ImageView imageView;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_splash);
            textView = (TextView) findViewById(R.id.textViewSplash);
            imageView = (ImageView) findViewById(R.id.imageViewSplash);
            Animation anima = AnimationUtils.loadAnimation(this,R.anim.transicao);
            textView.startAnimation(anima);
            imageView.startAnimation(anima);
            final Intent i = new Intent(this,DayActivity.class);
            Thread timer = new Thread(){
                public void run(){
                    try{
                        sleep(2000);
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
