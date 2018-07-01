package com.example.user.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    int player=0;
    boolean isActive=true;
    int tag[] ={2,2,2,2,2,2,2,2,2};
    int [][] winners={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    public void dropin(View view){
        ImageView imageView=(ImageView)view;
        int checkTag=Integer.parseInt(imageView.getTag().toString());
        if(tag[checkTag]==2 && isActive) {
            tag[checkTag]=player;
            imageView.setTranslationY(-1000f);
            if (player == 0) {
                imageView.setImageResource(R.drawable.x);

                player = 1;
            } else {
                imageView.setImageResource(R.drawable.o);
                player = 0;
            }
            imageView.animate().translationYBy(1000f).rotation(360f).setDuration(300);
        }
       for(int []winner : winners){
           if(tag[winner[0]]==tag[winner[1]] && tag[winner[1]]==tag[winner[2]] && tag[winner[0]]!=2){
                String win="O";
                if(tag[winner[0]]==0){
                    win="X";
                }
                TextView msg=(TextView)findViewById(R.id.winnerMsg);
                LinearLayout play=(LinearLayout)findViewById(R.id.playagain);
                isActive=false;
                msg.setText(win + " has won!");
                play.setVisibility(View.VISIBLE);
            }else{
            boolean gameDraw=true;
                for(int Tagcheck : tag){
                    if(Tagcheck==2)gameDraw=false;
                }
            if(gameDraw)
            {
                TextView msg=(TextView)findViewById(R.id.winnerMsg);
                LinearLayout play=(LinearLayout)findViewById(R.id.playagain);
                isActive=false;
                msg.setText("Its a Draw!");
                play.setVisibility(View.VISIBLE);
            }
            }
        }
        }
        public void playagain(View view){
        isActive=true;
            LinearLayout play=(LinearLayout)findViewById(R.id.playagain);
        play.setVisibility(View.INVISIBLE);
        player=0;
        for(int i=0;i<tag.length;i++)
            tag[i]=2;
            GridLayout gridLayout=(GridLayout)findViewById(R.id.grid);
            for(int i=0;i<gridLayout.getChildCount();i++){
                ((ImageView) gridLayout.getChildAt(i)).setImageResource(0);
            }
        }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
