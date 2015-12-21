package edu.iu.se.trafficruler;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.PaintDrawable;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;


public class DailyBonus extends AppCompatActivity {

    Button btn_first;
    Button btn_second;
    Button btn_third;
    Button btn_Toggle;
    Button btn_Back;

    Boolean didStart = false ;
    Boolean brkcon = false;

    int color1 = Color.YELLOW;
    int color2 = Color.LTGRAY;
    int color3 = Color.MAGENTA;

    TextView txt_Res1;
    TextView txt_Res2;


    Random rno = new Random();


    Handler handler;
    static int  count=0;

    //Array of colors
    int colors[] = {Color.BLACK , Color.CYAN, Color.BLUE , Color.GREEN , Color.GRAY , Color.MAGENTA , Color.YELLOW , Color.RED };





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_bonus);
        handler = new Handler();



        txt_Res1 = (TextView) findViewById(R.id.txt_Res1);
        txt_Res2 = (TextView) findViewById(R.id.txt_Res2);

        btn_first = (Button) findViewById(R.id.btn_first);
        btn_second = (Button) findViewById(R.id.btn_second);
        btn_third = (Button) findViewById(R.id.btn_third);

        btn_Toggle = (Button) findViewById(R.id.btn_Toggle);
        btn_Toggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                if (!didStart) {
                    didStart = true;
                    btn_Toggle.setText("Stop");
                    brkcon = true;

                    final Runnable r = new Runnable() {
                        public void run() {

                            if (brkcon) {
                                int one = rno.nextInt(8);
                                btn_first.setBackgroundColor(colors[one]);
                                //Log.e("one " , String.valueOf(one));

                                int two = rno.nextInt(8);
                                btn_second.setBackgroundColor(colors[two]);
                                //Log.e("Two ", String.valueOf(two));

                                int three = rno.nextInt(8);
                                btn_third.setBackgroundColor(colors[three]);

                                handler.postDelayed(this, 100); // Set time in milliseconds
                            }
                        }
                    };

                    handler.postDelayed(r, 100); // Set time in milliseconds
                } else {
                    brkcon = false;
                    btn_Toggle.setEnabled(false);

                    ColorDrawable d1 = (ColorDrawable) btn_first.getBackground();
                    ColorDrawable d2 = (ColorDrawable) btn_second.getBackground();
                    ColorDrawable d3 = (ColorDrawable) btn_third.getBackground();

                    int one = d1.getColor();
                    int two= d2.getColor();
                    int three = d3.getColor();



                    if ((one == two) && (one == three)) {
                        txt_Res1.setText("Bingo !! You hit jackpot");
                        txt_Res2.setText("You have won 500 points");
                        Global.Points += 500;

                    } else if (one == two || one == three || two == three) {
                        txt_Res1.setText("Congratulations, Two Tiles matched");
                        txt_Res2.setText("You have won 50 points");
                        Global.Points += 50;

                    } else {
                        txt_Res1.setText("Sorry,No tiles matched");
                        txt_Res2.setText("You didnt win anything");
                    }





                }
            }
        });


        btn_Back = (Button) findViewById(R.id.btn_Back);
        btn_Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainMenu.class);
                startActivity(intent);
                finish();
            }
        });



    }


}

