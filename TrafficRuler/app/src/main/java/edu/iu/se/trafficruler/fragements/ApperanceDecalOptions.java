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
public class ApperanceDecalOptions extends Fragment{

    public static ApperanceDecalOptions newInstance() {
        ApperanceDecalOptions fragment = new ApperanceDecalOptions();
        return fragment;
    }

    public ApperanceDecalOptions() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.apperance_decals_options, container, false);
        return rootView;
    }
}
