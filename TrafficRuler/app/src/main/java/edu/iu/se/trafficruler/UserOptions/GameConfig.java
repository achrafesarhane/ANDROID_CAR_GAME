package edu.iu.se.trafficruler.UserOptions;

/**
 * Created by Sagar on 11/7/2015.
 */
public class GameConfig {
    private static int currentLevel = 1;
    private static GameMode gameMode = GameMode.Classic;
    private static int totalRoundTime = 180;//seconds


    public static void resetGameRoundTime() {
        currentLevel = 1;
        totalRoundTime = gameMode.getGameRoundTime();
    }

    public static void resetGameRoundTime(int currentLevel) {
        GameConfig.currentLevel = currentLevel;
        switch (currentLevel) {
            case 1:
                totalRoundTime = 120;
                break;
            case 2:
                totalRoundTime = 60;
                break;
            case 3:
                totalRoundTime = 120;
                break;
        }
    }

    public static int getTotalRoundTime() {
        return totalRoundTime;
    }

    public static void setTotalRoundTime(int totalRoundTime) {
        GameConfig.totalRoundTime = totalRoundTime;
    }

    public static int getCurrentLevel() {
        return currentLevel;
    }

    public static GameMode getGameMode() {
        return gameMode;
    }

    public static void setGameMode(GameMode gameMode) {
        GameConfig.gameMode = gameMode;
        resetGameRoundTime();
    }

    public static void setCurrentLevel(int currentLevel) {
        GameConfig.currentLevel = currentLevel;
    }

    public enum GameMode {
        Practise, Classic, Time;

        public String gameModeString() {
            String mode = "";
            switch (this) {
                case Practise:
                    mode = "Practice Mode";
                    break;
                case Classic:
                    mode = "Classic Mode";
                    break;
                case Time:
                    mode = "Time Mode";
                    break;
            }
            return mode;
        }

        public int getGameRoundTime() {
            int time = 180;//default
            switch (this) {
                case Practise:
                    time = Integer.MAX_VALUE;
                    break;
                case Classic:
                    time = 300;
                    break;
                case Time:
                    time = 120;
                    break;
            }
            return time;
        }
    }

}
