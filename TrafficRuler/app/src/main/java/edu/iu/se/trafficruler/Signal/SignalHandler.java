package edu.iu.se.trafficruler.Signal;

import android.content.Intent;

import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;

import org.andengine.entity.text.Text;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.region.TextureRegion;
import org.andengine.ui.activity.SimpleBaseGameActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import edu.iu.se.trafficruler.GameActivity;
import edu.iu.se.trafficruler.GameOver;
import edu.iu.se.trafficruler.UserOptions.GameConfig;
import edu.iu.se.trafficruler.GameActivity;


/**
 * Created by sagar on 10/30/2015.
 */
public class SignalHandler {

    private static Text instText;
    private BitmapTextureAtlas mSignalTexture;
    private TextureRegion mSignalTextureRegion;
    private boolean signalOn;
    private SimpleBaseGameActivity activity;
    private Signal currentSignal = Signal.Green;
    private int timeElapsed = 0;
    private List<Signal> allSignals = Arrays.asList(Signal.values());
    private List<String> signalList = new ArrayList<String>();
    private boolean gameWin = false;

    {
        signalList.add("signalA");
        signalList.add("signalB");
        signalList.add("signalC");
        signalList.add("signalD");
    }

    public void resetSignalList() {
        signalList.clear();
        signalList.add("signalA");
        signalList.add("signalB");
        signalList.add("signalC");
        signalList.add("signalD");
    }

    public boolean isSignalOn() {
        return signalOn;
    }

    public void setSignalOn(boolean signalOn) {
        this.signalOn = signalOn;
    }

    public void toggleSignal() {
        signalOn = !signalOn;
    }

    public SignalHandler(BitmapTextureAtlas mSignalTexture, TextureRegion mSignalTextureRegion, SimpleBaseGameActivity activity) {
        this.mSignalTexture = mSignalTexture;
        this.mSignalTextureRegion = mSignalTextureRegion;
        this.activity = activity;
    }

    public BitmapTextureAtlas getmSignalTexture() {
        return mSignalTexture;
    }

    public void setmSignalTexture(BitmapTextureAtlas mSignalTexture) {
        this.mSignalTexture = mSignalTexture;
    }

    public TextureRegion getmSignalTextureRegion() {
        return mSignalTextureRegion;
    }

    public void setmSignalTextureRegion(TextureRegion mSignalTextureRegion) {
        this.mSignalTextureRegion = mSignalTextureRegion;
    }

    private void updateSignalIcon() {

        this.mSignalTexture.clearTextureAtlasSources();
        this.mSignalTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(this.mSignalTexture, activity, currentSignal.getImageName(), 0, 128);
    }

    public void changeSignal() {


        if (GameConfig.getGameMode() == GameConfig.GameMode.Time) {
            if (signalList.isEmpty()) {
                //all signals crossed
                //increase level and reset round time
                int level = GameConfig.getCurrentLevel();

                if (level == 3) {
                    gameWin = true;
                    GameConfig.resetGameRoundTime();
                } else {
                    level++;
                    GameConfig.resetGameRoundTime(level);
                    timeElapsed = 0;
                    instText.setText("Cross All Signals in " + ((3-level) > 0 ? (3-level) + " minutes" : " 30 seconds") );
                    resetSignalList();
                }
            }
        }

        //check if time elapsed is more than round's total time
        timeElapsed += 5;
        if (timeElapsed >= GameConfig.getTotalRoundTime() || gameWin) {
            if (gameWin) {
                ScoreManager.gameWin();
            } else {
                ScoreManager.gameOver();
            }
            //replace with pause menu
            activity.getEngine().stop();
            Intent callGameOver = new Intent(activity.getApplicationContext(), GameOver.class);
            callGameOver.putExtra("Score", ScoreManager.getCurrentScore());
            callGameOver.putExtra("win", gameWin);
            ScoreManager.resetCurrentScore();
            activity.startActivity(callGameOver);
            activity.finish();

        }

        //check if signal is on, if it is just turn it off
        if (isSignalOn()) {
            //turn off
            currentSignal = Signal.Green;
        } else {
            //pick a random signal and apply
            Random random = new Random();
            this.currentSignal = allSignals.get(random.nextInt(allSignals.size()));
        }

        updateSignalIcon();
        toggleSignal();
        changeInstructions();
    }

    public static Text getInstText() {
        return instText;
    }

    public static void setInstText(Text instText) {
        SignalHandler.instText = instText;
    }

    private void changeInstructions() {
        if (GameConfig.getGameMode() == GameConfig.GameMode.Practise) {
            instText.setText(currentSignal.getActionType().getMessage());
        }
    }

    public ContactListener getContactListener() {
        ContactListener contactListener = new ContactListener() {
            @Override
            public void beginContact(Contact contact) {

            }

            @Override
            public void endContact(Contact contact) {
                final Fixture x1 = contact.getFixtureA();
                final Fixture x2 = contact.getFixtureB();

                if (x1.getBody().getUserData() != null && x2.getBody().getUserData() != null) {

                    String signal = x2.getBody().getUserData().toString();
                    String car = x1.getBody().getUserData().toString();

                    if (car.equals("car") && signal.contains("signal")) {
                        int score = 0;
                        //if signal is on while crossing, reduce points by 20. Else increase points by 20
                        if (isSignalOn() && currentSignal != Signal.Green) {
                            score = -5;
                        } else {
                            signalList.remove(signal);
                            score = 20;
                        }
                        ScoreManager.updateScore(score);
                    }
                }
            }

            @Override
            public void preSolve(Contact contact, Manifold oldManifold) {

            }

            @Override
            public void postSolve(Contact contact, ContactImpulse impulse) {

            }
        };
        return contactListener;
    }
}
