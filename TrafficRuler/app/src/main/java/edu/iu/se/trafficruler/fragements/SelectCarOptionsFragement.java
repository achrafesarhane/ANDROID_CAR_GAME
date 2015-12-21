package edu.iu.se.trafficruler.fragements;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.iu.se.trafficruler.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class SelectCarOptionsFragement extends Fragment {

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static SelectCarOptionsFragement newInstance() {
        SelectCarOptionsFragement fragment = new SelectCarOptionsFragement();
        return fragment;
    }

    public SelectCarOptionsFragement() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.car_fragement, container, false);
        return rootView;
    }
}