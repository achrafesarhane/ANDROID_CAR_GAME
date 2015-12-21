package edu.iu.se.trafficruler;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainMenu extends AppCompatActivity {

    Button btn_GFRMain;
    Button btn_QuitAppMain;
    Button btn_SignIADiffUser;
    Button btn_disHiScr;
    Button  btn_daily;
    TextView userText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

//        Intent intent = getIntent();
//        String username = intent.getStringExtra("User_Name" );
        userText = (TextView) findViewById(R.id.txt_UserName);
        userText.setText(Global.UserName);

        btn_GFRMain = (Button) findViewById(R.id.btn_GFRMain);
        btn_GFRMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AfterLogin.class);
                startActivity(intent);
                finish();
            }
        });


        btn_QuitAppMain = (Button) findViewById(R.id.btn_QuitAppMain);
        btn_QuitAppMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),AfterLogin.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                finish();
                android.os.Process.killProcess(android.os.Process.myPid());
            }
        });

        btn_SignIADiffUser = (Button) findViewById(R.id.btn_SignIADiffUser);
        btn_SignIADiffUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                //intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();
            }
        });

        btn_disHiScr = (Button) findViewById(R.id.btn_disHiScr);
        btn_disHiScr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),HIghScore.class);
                //intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();
            }
        });

        btn_daily = (Button)findViewById(R.id.btn_daily);
        btn_daily.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),DailyBonus.class);
                startActivity(intent);
                finish();
            }
        });
    }


}
