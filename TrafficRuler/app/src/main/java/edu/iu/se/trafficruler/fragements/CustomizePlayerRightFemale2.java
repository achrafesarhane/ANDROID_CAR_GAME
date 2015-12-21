package edu.iu.se.trafficruler.fragements;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.iu.se.trafficruler.R;

/**
 * Created by Sruthi on 10/28/2015.
 */
public class CustomizePlayerRightFemale2 extends Fragment {
    public static CustomizePlayerRightFemale2 newInstance() {
        CustomizePlayerRightFemale2 fragment = new CustomizePlayerRightFemale2();
        return fragment;
    }

    public CustomizePlayerRightFemale2() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.customizeplayerrightfemale2, container, false);
        return rootView;
    }
}
