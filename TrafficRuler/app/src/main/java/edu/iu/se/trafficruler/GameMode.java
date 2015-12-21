package edu.iu.se.trafficruler;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import edu.iu.se.trafficruler.UserOptions.GameConfig;

public class GameMode extends AppCompatActivity {

    Button btn_Practise;
    Button btn_Classic;
    Button btn_Timed;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_type);

        Button btn_Practise = (Button) findViewById(R.id.btn_Practise);
        btn_Practise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), GameActivity.class);
                GameConfig.setGameMode(GameConfig.GameMode.Practise);
                startActivity(intent);
                finish();
            }
        });

        Button btn_Classic = (Button) findViewById(R.id.btn_Classic);
        btn_Classic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),GameActivity.class);
                GameConfig.setGameMode(GameConfig.GameMode.Classic);
                startActivity(intent);
                finish();
            }
        });

        Button btn_Timed = (Button) findViewById(R.id.btn_Timed);
        btn_Timed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),GameActivity.class);
                GameConfig.setGameMode(GameConfig.GameMode.Time);
                startActivity(intent);
                finish();
            }
        });
    }
}
