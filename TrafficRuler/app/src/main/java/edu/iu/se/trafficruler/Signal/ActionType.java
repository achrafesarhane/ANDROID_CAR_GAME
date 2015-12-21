package edu.iu.se.trafficruler.Signal;

/**
 * Created by sagar on 10/30/2015.
 */
public enum ActionType {

    Stop, LeftTurn, RightTurn,Slow, LeftWay, RightWay, Go;


    public String getMessage(){

        String message = "";

        switch (this) {
            case Stop :
                message = "Stop at the Signal";
                break;
            case LeftTurn:
                message = "Take a Left Turn ";
                break;
            case RightTurn:
                message = "Take a Right Turn ";
                break;
            case Slow:
                message = "Decrease your Speed ";
                break;
            case LeftWay:
                message = "Keep only Left Lane";
                break;
            case RightWay:
                message = "Keep only Right Lane ";
                break;
            case Go:
                message = "Go Go Go ...!!!  ";
                break;
            default:
                message = "";
        }

        return message;
    }
}
