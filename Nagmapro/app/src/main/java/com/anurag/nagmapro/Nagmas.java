package com.anurag.nagmapro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Nagmas extends AppCompatActivity {
    public Button button;
    MediaPlayer player;
    public Button button3;
    MediaPlayer player1;
    MediaPlayer player2;
    public Button button4;
    public ImageButton image;



    public void  player (View view){
        if (player==null){
            player=MediaPlayer.create(this,R.raw.madhya1);
        }
        player.start();
    }

    public void player1 (View view){
        if (player1==null){
            player1=MediaPlayer.create(this,R.raw.drut);
        }
        player1.start();
    }
    public void  player2 (View view){
        if (player2==null){
            player2=MediaPlayer.create(this,R.raw.vilm);
        }
        player2.start();
    }
    public void pause (View view){
        if (player !=null) {
            player.pause();

            if (player1 !=null)
            {

                player1.pause();
            }
        }
        else if (player2 !=null)
        {
            player2.pause();
        }
        }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nagmas);



        button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent CategoryIntent=new Intent(Nagmas.this,Harmonium.class);
                startActivity(CategoryIntent);
                finish();




            }
        });
    }

}