package com.anurag.nagmapro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
public Button button2;
ImageView imageView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView=(findViewById(R.id.imageView));

        Animation fadein=AnimationUtils.loadAnimation(this,R.anim.fadein);


        button2=findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent categoryIntent =new Intent(MainActivity.this,Nagmas.class);
                startActivity(categoryIntent);
                finish();



            }
        });

        };


