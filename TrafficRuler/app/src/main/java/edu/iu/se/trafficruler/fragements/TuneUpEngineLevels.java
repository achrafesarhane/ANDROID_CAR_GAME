package edu.iu.se.trafficruler.fragements;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.iu.se.trafficruler.R;
/**
 * Created by Sruthi on 10/30/2015.
 */
public class TuneUpEngineLevels extends Fragment {

    public static TuneUpEngineLevels newInstance() {
        TuneUpEngineLevels fragment = new TuneUpEngineLevels();
        return fragment;
    }

    public TuneUpEngineLevels() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tune_up_engine_levels, container, false);
        return rootView;
    }


}
