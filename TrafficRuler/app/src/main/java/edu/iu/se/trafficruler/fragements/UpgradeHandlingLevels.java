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
public class UpgradeHandlingLevels extends Fragment {

    public static UpgradeHandlingLevels newInstance() {
        UpgradeHandlingLevels fragment = new UpgradeHandlingLevels();
        return fragment;
    }

    public UpgradeHandlingLevels() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.upgrade_handling, container, false);
        return rootView;
    }
}

