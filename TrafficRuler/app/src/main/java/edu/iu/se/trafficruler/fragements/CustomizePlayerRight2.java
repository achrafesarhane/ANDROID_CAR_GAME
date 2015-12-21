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
public class CustomizePlayerRight2 extends Fragment{

    public static CustomizePlayerRight2 newInstance() {
        CustomizePlayerRight2 fragment = new CustomizePlayerRight2();
        return fragment;
    }

    public CustomizePlayerRight2() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.customizeplayerright2, container, false);
        return rootView;
    }
}
