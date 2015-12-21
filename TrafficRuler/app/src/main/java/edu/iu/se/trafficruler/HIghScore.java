package edu.iu.se.trafficruler;

import android.app.Activity;
import android.app.Dialog;
import android.app.ListActivity;
import android.content.ClipData;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sruthi on 11/6/2015.
 */
public class HIghScore extends AppCompatActivity{
    Cursor dbCursor;
    ArrayList<ClipData.Item> mArrayList;
    TextView count_txt;
    ListView list;
    Dialog preview_dialog;
    ArrayList<Integer> scoreArray = new ArrayList<Integer>();
    List<Leaderboard> score;
    ArrayAdapter<String> displayHighscores;





    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        ScrollView scroll = new ScrollView(getApplicationContext());



        LinearLayout main = new LinearLayout(this);
        setContentView(main);
        main.setOrientation(LinearLayout.VERTICAL);


        LinearLayout header = new LinearLayout(this);
        header.setOrientation(LinearLayout.HORIZONTAL);
        //Intent getFromMainActivity=getIntent();
        //DataBaseHelper db = new DataBaseHelper(this);

        LoginDataBaseAdapter db=new LoginDataBaseAdapter(this);
        score = new ArrayList<Leaderboard>();
        score=db.getAllScore();

        TextView usr_nm_lbl = new TextView(this);
        usr_nm_lbl.setText("Username");
        usr_nm_lbl.setTextColor(Color.RED);
        usr_nm_lbl.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        usr_nm_lbl.setPadding(50, 20, 70, 20);
        header.addView(usr_nm_lbl);

        TextView scr_lbl = new TextView(this);
        scr_lbl.setText("Score");
        scr_lbl.setTextColor(Color.RED);
        scr_lbl.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        //scr_lbl.setPadding(50, 20, 50, 20);
        header.addView(scr_lbl);
        header.setGravity(Gravity.CENTER);
        main.addView(header);

        for (int i =0 ; i < score.size() ; i++){
            LinearLayout child = new LinearLayout(this);
            child.setOrientation(LinearLayout.HORIZONTAL);
            TextView textView1 = new TextView(this);
            textView1.setText(score.get(i).getUsername());
            textView1.setPadding(50, 20, 170, 20);
            child.addView(textView1);
            TextView textView2 = new TextView(this);
            textView2.setText(String.valueOf(score.get(i).getScore()));
            //textView2.setPadding(50, 20, 50, 20);
            child.addView(textView2);
            child.setGravity(Gravity.CENTER);

            main.addView(child);
        }

        Button btn_Back = new Button(getApplicationContext());

        btn_Back.setText("Back");
        btn_Back.setBackgroundColor(Color.rgb(219, 219, 219));
        btn_Back.setTextColor(Color.BLACK);
        btn_Back.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        main.addView(btn_Back);


        btn_Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainMenu.class);
                startActivity(intent);
                finish();
            }
        });
        //Toast.makeText(HIghScore.this, "Congrats: Login Successfull" + score, Toast.LENGTH_LONG).show();
        //ListView list1 = (ListView) findViewById(R.id.list);
//        ListView lstvw_HighScores = (ListView)findViewById(R.id.lstv_shwFileList);
//        displayHighscores= new ArrayAdapter<Leaderboard>(this, android.R.layout.simple_list_item_2, score);
//        lstvw_HighScores.setAdapter(displayHighscores);




    }




}
