package edu.iu.se.trafficruler.fragements;

/**
 * Created by Sruthi on 10/30/2015.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.iu.se.trafficruler.R;

/**
 * Created by Vikrant Kaushal on 10/26/2015.
 */
public class ApperanceColorLevels extends Fragment {

    public static ApperanceColorLevels newInstance() {
        ApperanceColorLevels fragment = new ApperanceColorLevels();
        return fragment;
    }

    public ApperanceColorLevels() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.apperance_color_levels, container, false);
        return rootView;
    }

}
