package edu.iu.se.trafficruler.Signal;

/**
 * Created by sagar on 10/30/2015.
 */

import edu.iu.se.trafficruler.Signal.ActionType;

/**
 * represents traffic signal type
 */
public enum Signal {
    Green, Stop, Yield, StopForChildren, StopForPedestrians, SchoolCrossing , NoTurnOnRed;
    //KeepLeft, KeepRight, LeftOnly, RightOnly, TwowayStreet

    public String getImageName() {
        String imageName = "go_signal.png";
        switch (this) {
            case Green:
                imageName = "go_signal.png";
                break;
            case Stop:
                imageName = "stop_signal.png";
                break;
            case Yield:
                imageName = "yield_signal.png";
                break;
            case StopForChildren:
                imageName = "stop_children_signal.png";
                break;
            case StopForPedestrians:
                imageName = "stop_ped_signal.png";
                break;
            case SchoolCrossing:
                imageName = "stop_school_signal.png";
                break;
//            case TwowayStreet:
//                imageName = "two_way_street.png";
//                break;
//            case KeepLeft:
//                imageName = "keep_left.png";
//                break;
//            case KeepRight:
//                imageName = "keep_right.png";
//                break;
//            case LeftOnly:
//                imageName = "left_only.png";
//                break;
//            case RightOnly:
//                imageName = "right_only.png";
//                break;
            case NoTurnOnRed:
                imageName = "no_turn.png";
                break;
        }

        return imageName;
    }

    public ActionType getActionType() {

        ActionType actionType = ActionType.Stop;

        switch (this) {
            case Stop:
            case Yield:
            case StopForChildren:
            case StopForPedestrians:
            case NoTurnOnRed:
                actionType = ActionType.Stop;
                break;
            case SchoolCrossing:
                actionType = ActionType.Slow;
                break;
//            case TwowayStreet:
//                actionType = ActionType.RightWay;
//                break;
//            case KeepLeft:
//                actionType = ActionType.LeftWay;
//                break;
//            case KeepRight:
//                actionType = ActionType.RightWay;
//                break;
//            case LeftOnly:
//                actionType = ActionType.LeftTurn;
//                break;
//            case RightOnly:
//                actionType = ActionType.RightTurn;
//                break;
            case Green:
                actionType = ActionType.Go;
                break;
        }

        return actionType;
    }
}