package edu.iu.se.trafficruler;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;

/**
 * Created by Sruthi on 10/26/2015.
 */
public class Choose_Player_Activity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Button bCustomize;
    Button bMale;
    Button bFemale;
    Button back;
    Button btn_StartGame;
    int pressed;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chooseplayeractivity);
        Intent intent = getIntent();
        Intent getintentfromcustom ;

        getintentfromcustom = getIntent();
        bMale =(Button)findViewById(R.id.button);
        bMale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("This is what I DID");
               pressed=1;
            }
        });

        bFemale =(Button)findViewById(R.id.button3);
        bFemale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pressed=0;
            }
        });

        btn_StartGame = (Button)findViewById(R.id.btn_StartGame);
        btn_StartGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent start_gameplay = new Intent(getApplicationContext(),GameMode.class);
                start_gameplay.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(start_gameplay);
                finish();
            }
        });

        bCustomize = (Button)findViewById(R.id.customizeplayer);
        bCustomize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnCustomPlayerClick(v);
            }
        });


            /********************************************/
            back = (Button)findViewById(R.id.backbuttonchoose);
            back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    OnBackChooseClick(v);
                }
            });

            /*****************************/



    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    public void OnCustomPlayerClick(View view) {
/*pass the value of pressed in the INTENT*/
        System.out.println(pressed);
        Intent goToChoosePlayer;
        goToChoosePlayer = new Intent(this,CustomizePlayerActivity.class);
        goToChoosePlayer.putExtra("Pressed",pressed);

        //sendBob.putExtra("humanBob",bob);
        startActivity(goToChoosePlayer);
    }

    public void OnBackChooseClick(View view) {

        Intent goToCustomizePlayer;
        goToCustomizePlayer = new Intent(this,Vehicle_Adapter_Activity.class);
        startActivity(goToCustomizePlayer);
    }
}
