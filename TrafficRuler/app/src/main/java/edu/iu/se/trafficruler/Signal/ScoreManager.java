package edu.iu.se.trafficruler.Signal;

import org.andengine.entity.text.Text;

import edu.iu.se.trafficruler.Global;

/**
 * Created by sagar on 11/4/2015.
 */
public class ScoreManager {

    private static int currentScore = 0;
    private static Text scoreText;

    public static int getCurrentScore() {
        return currentScore;
    }

    public static void resetCurrentScore() {
        currentScore = 0;
    }

    public static Text getScoreText() {
        return scoreText;
    }

    public static void setScoreText(Text scoreText) {
        ScoreManager.scoreText = scoreText;
    }

    public static void updateScore(int score) {
        currentScore += score;
        currentScore = currentScore > 0 ? currentScore : 0;
        scoreText.setText("Score " + currentScore);

        if (currentScore >= 100) {
            Global.isEnabled = true;
        }
    }

    public static void gameOver() {
        scoreText.setText("Game Over");
    }

    public static void gameWin() {
        scoreText.setText("Game Over: You Won!");
    }
}
