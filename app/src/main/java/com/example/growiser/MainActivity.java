package com.example.growiser;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    //Hooks
    TextView slogantxt;
    ImageView logo_img;

    //Animations
    Animation logo_animation, text_animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConstraintLayout constraintLayout = findViewById(R.id.mainid);
        AnimationDrawable animationDrawable = (AnimationDrawable) constraintLayout.getBackground();

        animationDrawable.start();

        logo_animation = AnimationUtils.loadAnimation(this, R.anim.logo_animation);
        text_animation = AnimationUtils.loadAnimation(this,R.anim.text_animation);


        slogantxt = findViewById(R.id.slogantxt);
        logo_img = findViewById(R.id.logo_image);

        slogantxt.setAnimation(text_animation);
        logo_img.setAnimation(logo_animation);


        getSupportActionBar().hide();
        Thread td= new Thread(){
            public void run()
            {
                try {
                    sleep(3000);

                }
                catch (Exception ex)
                {
                    ex.printStackTrace();
                }

                finally {
                    Intent splash= new Intent(MainActivity.this,logIn.class);
                    startActivity(splash);
                    finish();
                }
            }
        };
        td.start();

    }
}
