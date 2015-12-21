package edu.iu.se.trafficruler;

import org.andengine.engine.handler.timer.ITimerCallback;
import org.andengine.engine.handler.timer.TimerHandler;

/**
 * Created by sagar on 10/29/2015.
 */
public class TimedScreenUpdateHandler extends TimerHandler{

    public TimedScreenUpdateHandler(float pTimerSeconds, ITimerCallback pTimerCallback) {
        super(pTimerSeconds, true, pTimerCallback);
    }

}
