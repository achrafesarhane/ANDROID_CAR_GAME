package edu.iu.se.trafficruler.fragements;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.iu.se.trafficruler.R;

/**
 * Created by Vikrant Kaushal on 10/26/2015.
 */
public class ApperanceVinyls extends Fragment {

    public static ApperanceVinyls newInstance() {
        ApperanceVinyls fragment = new ApperanceVinyls();
        return fragment;
    }

    public ApperanceVinyls() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.apperance_vinyl_levels, container, false);
        return rootView;
    }
}
