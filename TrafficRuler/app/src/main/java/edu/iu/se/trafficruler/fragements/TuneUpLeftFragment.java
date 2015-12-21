package edu.iu.se.trafficruler.fragements;

/**
 * Created by Sruthi & vikrant on 10/30/2015.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import edu.iu.se.trafficruler.R;
import edu.iu.se.trafficruler.WareHouseActivity;

public class TuneUpLeftFragment extends Fragment {

    Button bback2;
    public static TuneUpLeftFragment newInstance() {
        TuneUpLeftFragment fragment = new TuneUpLeftFragment();
        return fragment;
    }

    public TuneUpLeftFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tune_up_options_fragment, container, false);
        /********************************************/
        bback2 = (Button)rootView.findViewById(R.id.backbuttontune);
        bback2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnBackClickTune(v);
            }
        });

        /*****************************/
        return rootView;
    }
    public void OnBackClickTune(View view) {

        Intent goToSelectTuneup;
        goToSelectTuneup = new Intent(getActivity(),WareHouseActivity.class);
        startActivity(goToSelectTuneup);
    }
}

