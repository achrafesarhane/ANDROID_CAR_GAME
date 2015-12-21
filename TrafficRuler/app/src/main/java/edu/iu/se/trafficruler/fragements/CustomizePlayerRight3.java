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
public class CustomizePlayerRight3 extends Fragment{

    public static CustomizePlayerRight3 newInstance() {
        CustomizePlayerRight3 fragment = new CustomizePlayerRight3();
        return fragment;
    }

    public CustomizePlayerRight3() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.customizeplayerright3, container, false);
        return rootView;
    }
}
