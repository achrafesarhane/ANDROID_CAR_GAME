package edu.iu.se.trafficruler.fragements;

/**
 * Created by Sruthi on 10/26/2015.
 */
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.iu.se.trafficruler.R;
public class CustomizePlayerRight extends Fragment{

    public static CustomizePlayerRight newInstance() {
        CustomizePlayerRight fragment = new CustomizePlayerRight();
        return fragment;
    }

    public CustomizePlayerRight() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.customizeplayerright, container, false);
        return rootView;
    }
}
