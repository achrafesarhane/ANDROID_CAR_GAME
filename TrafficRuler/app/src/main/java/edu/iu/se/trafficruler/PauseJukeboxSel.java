package edu.iu.se.trafficruler;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.ToggleButton;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;


public class PauseJukeboxSel extends AppCompatActivity implements android.widget.CompoundButton.OnCheckedChangeListener {
    ListView lstv_shwFileList;
    ArrayList<SongList> songLists;
    SongListAdaptor slAdapter;
    Button btn_Back;
    Button btn_Add;
    Button btn_Stop;
    ToggleButton tbtn_ShuffleSel;

    //Index of music player
    public static int mu_pos=0;

    //Check if shuffle on
    public static int is_shuffle=0;

    //Intitalize Random class
    Random rno=new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pause_jukebox_sel);

        lstv_shwFileList = (ListView) findViewById(R.id.lstv_shwFileList);
        btn_Back = (Button) findViewById(R.id.btn_Back);
        btn_Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Pause_Game.class);
                Global.storedSongsList.clear();
                for (int i=0; i< Global.getFiles.size() ; i++) {
                    Log.e("Path " , String.valueOf(songLists.get(i).path));
                    Log.e("Boolean value ", String.valueOf(songLists.get(i).selected));
                    Global.storedSongsList.add(new SongList(songLists.get(i).path,songLists.get(i).selected));
                }
                startActivity(intent);
                finish();
            }
        });

        if (Global.selectFiles.size() > 0){
            songLists = new ArrayList<SongList>();
            for (int i=0; i< Global.getFiles.size() ; i++){
                Log.e("getFiles "+i+" : ", String.valueOf(Global.getFiles.get(i)));
                songLists.add(new SongList(Global.storedSongsList.get(i).path, Global.storedSongsList.get(i).selected));

            }
            slAdapter = new SongListAdaptor(songLists, this);
            lstv_shwFileList.setAdapter(slAdapter);
        }
        else
            displaySongList();

        tbtn_ShuffleSel = (ToggleButton) findViewById(R.id.tbtn_ShuffleSel);
        tbtn_ShuffleSel.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    is_shuffle = 1;
                } else {
                    is_shuffle = 0;
                }
            }
        });
        btn_Stop = (Button) findViewById(R.id.btn_Stop);
        btn_Stop.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    Global.mediaPlayer.stop();
                }
            }
        );

        btn_Add = (Button) findViewById(R.id.btn_Add);
        btn_Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Global.selectFiles.clear();
                for (int i = 0; i < songLists.size(); i++) {
                    if (songLists.get(i).selected == true)
                        Global.selectFiles.add(songLists.get(i).path);
                }

                if (Global.selectFiles.size() == 0)
                    return;

                if (is_shuffle == 1) {
                    int temp = rno.nextInt(Global.selectFiles.size() - 1);
                    if (temp == mu_pos)
                        if (temp < Global.selectFiles.size()-1)
                            mu_pos = ++temp;
                        else mu_pos = 0;
                    else mu_pos = temp;
                    Log.e("Play ran: ", String.valueOf(mu_pos));
                }
                //MusicPlayer.mediaPlayer.stop();

                Global.mediaPlayer = MediaPlayer.create(getApplicationContext(), Uri.fromFile(new File(Global.selectFiles.get(mu_pos).toString())));
                Global.mediaPlayer.start();


                Global.mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        Log.e("IS it waiting ", String.valueOf(mu_pos));

                        if (is_shuffle == 1) {
                            int temp = rno.nextInt(Global.selectFiles.size() - 1);
                            if (temp == mu_pos)
                                if (temp < Global.selectFiles.size() - 1)
                                    mu_pos = ++temp;
                                else mu_pos = 0;
                            else mu_pos = temp;
                            Log.e("Play ran: ", String.valueOf(mu_pos));
                            Log.e("Play Next ran: ", String.valueOf(mu_pos));
                        } else if (mu_pos < Global.selectFiles.size() - 1) mu_pos++;
                        else mu_pos = 0;
                        //mediaPlayer = MediaPlayer.create(getApplicationContext(), Uri.fromFile(new File(getFiles.get(mu_pos).toString())));
                        try {
                            Log.e("URI", Global.selectFiles.get(mu_pos).toString());
                            Global.mediaPlayer.reset();
                            Global.mediaPlayer.setDataSource(getApplicationContext(), Uri.fromFile(new File(Global.selectFiles.get(mu_pos).toString())));
                            Global.mediaPlayer.prepare();
                            Global.mediaPlayer.start();

                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }


                });


            }
        });




    }

    private void displaySongList() {

        songLists = new ArrayList<SongList>();

        Log.e("getFiles size", String.valueOf(Global.getFiles.size()));
        for (int i=0; i< Global.getFiles.size() ; i++){
            Log.e("getFiles size", String.valueOf(Global.getFiles.get(i)));
            songLists.add(new SongList(Global.getFiles.get(i)));
        }

//        songLists.add(new SongList("Song1"));
//        songLists.add(new SongList("Song2"));
//        songLists.add(new SongList("Song3"));
//        songLists.add(new SongList("Song4"));



//        planetList.add(new Planet("Mercury", 57000000));
//        planetList.add(new Planet("Venus", 23700000));
//        planetList.add(new Planet("Mars", 35000000));
//        planetList.add(new Planet("Jupiter", 5000000));
//        planetList.add(new Planet("Saturn", 746000000));

        slAdapter = new SongListAdaptor(songLists, this);
        lstv_shwFileList.setAdapter(slAdapter);
    }




    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        int pos = lstv_shwFileList.getPositionForView(buttonView);
        if (pos != ListView.INVALID_POSITION) {

            SongList s = songLists.get(pos);
            s.setSelected(isChecked);
//            if (isChecked == false){
//                MusicPlayer.storedSongsList.add(s);
//            }
//            else {
//                    MusicPlayer.storedSongsList.remove(pos);
//            }


//            Toast.makeText(
//                    this,
//                    "Clicked on Planet: " + s.getPath() + ". State: is "
//                            + isChecked, Toast.LENGTH_SHORT).show();
        }
    }
}
