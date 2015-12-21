package edu.iu.se.trafficruler.fragements;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.iu.se.trafficruler.R;

/**
 * Created by Sruthi on 10/30/2015.
 */
public class ImproveAccelerationLevels extends Fragment {

    public static ImproveAccelerationLevels newInstance() {
        ImproveAccelerationLevels fragment = new ImproveAccelerationLevels();
        return fragment;
    }

    public ImproveAccelerationLevels() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.improve_acceleration, container, false);
        return rootView;
    }
}
