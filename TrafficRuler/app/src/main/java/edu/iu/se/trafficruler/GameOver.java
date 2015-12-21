package edu.iu.se.trafficruler;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.sql.SQLException;

public class GameOver extends AppCompatActivity {

    TextView txt_Score;
    Button btn_Restart;
    Button btn_MainMenu;
    Button btn_Ret;
    LoginDataBaseAdapter loginDataBaseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);

        final Intent getScore = getIntent();
        int game_score = getScore.getIntExtra("Score", -1);
        boolean isWin = getScore.getBooleanExtra("win", false);

        loginDataBaseAdapter=new LoginDataBaseAdapter(this);
        try {
            loginDataBaseAdapter=loginDataBaseAdapter.open();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        loginDataBaseAdapter.insertScore(Global.UserName, game_score);
        Global.Points += game_score;


        Log.e("Game Score", String.valueOf(getScore));
        txt_Score = (TextView) findViewById(R.id.txt_Score);
        String scoreText = isWin ? "You won, Score " + String.valueOf(game_score) : String.valueOf(game_score);
        txt_Score.setText(scoreText);

        btn_Restart = (Button) findViewById(R.id.btn_Restart);
        btn_Restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callGameMode = new Intent(getApplicationContext(), GameMode.class);
                startActivity(callGameMode);
                finish();
            }
        });

        btn_MainMenu = (Button) findViewById(R.id.btn_MainMenu);
        btn_MainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callMainMenu = new Intent(getApplicationContext(),MainMenu.class);
                startActivity(callMainMenu);
                finish();
            }
        });



    }

    protected void onDestroy() {
        super.onDestroy();
        // Close The Database
        loginDataBaseAdapter.close();
    }
}
