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
public class CustomizePlayerRightFemale extends Fragment {
    public static CustomizePlayerRight newInstance() {
        CustomizePlayerRight fragment = new CustomizePlayerRight();
        return fragment;
    }

    public CustomizePlayerRightFemale() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.customizeplayerrightfemale, container, false);
        return rootView;
    }
}




