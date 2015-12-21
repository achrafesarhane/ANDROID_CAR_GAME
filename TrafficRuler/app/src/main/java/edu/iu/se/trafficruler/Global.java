package edu.iu.se.trafficruler;

import android.media.MediaPlayer;

import org.andengine.audio.music.Music;
import org.andengine.audio.music.MusicFactory;
import org.andengine.ui.activity.SimpleBaseGameActivity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Global {



    public static MediaPlayer mediaPlayer;
    public static List<String> getFiles = new ArrayList<String>();
    public static List<String> selectFiles = new ArrayList<String>();
    public static ArrayList<SongList> storedSongsList = new ArrayList<SongList>();
    public static String UserName;
    public static boolean isEnabled = false ;
    public static int Points = 0;


//    private Music music;
//    private MediaPlayer mediaPlayerGame = new MediaPlayer();
//    private SimpleBaseGameActivity activity;
//
//    public MusicPlayer(SimpleBaseGameActivity activity) {
//        this.activity = activity;
//    }
//
//    public void playMusic() {
//        try {
//
//            music = MusicFactory.createMusicFromAsset(activity.getMusicManager(), activity, "mfx/song.mp3");
//            music.play();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//
//
//
//    public void stop() {
//        music.stop();
//    }
}
