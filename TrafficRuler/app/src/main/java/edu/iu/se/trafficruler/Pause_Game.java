package edu.iu.se.trafficruler;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Pause_Game extends AppCompatActivity {

    Button btn_Resume;
    Button btn_JukeBoxSelection;
    Button btn_QuitGame;
    Button btn_QuitApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pause_menu);

        btn_Resume = (Button)findViewById(R.id.btn_Resume);
        btn_Resume.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                finish();
            }
        });

        btn_JukeBoxSelection = (Button) findViewById(R.id.btn_JukeBoxSelection);
        btn_JukeBoxSelection.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),PauseJukeboxSel.class);
                startActivity(intent);
                finish();
            }
        });

        btn_QuitGame = (Button) findViewById(R.id.btn_QuitGame);
        btn_QuitGame.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainMenu.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                //finish();
            }
        });
        btn_QuitApp = (Button) findViewById(R.id.btn_QuitApp);
        btn_QuitApp.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                moveTaskToBack(true);
                finish();
                android.os.Process.killProcess(android.os.Process.myPid());
            }
        });
    }
}
