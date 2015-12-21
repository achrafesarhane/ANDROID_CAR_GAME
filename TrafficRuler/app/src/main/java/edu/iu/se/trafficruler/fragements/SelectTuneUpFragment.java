package edu.iu.se.trafficruler.fragements;

/**
 * Created by Sruthi on 10/30/2015.
 */
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import edu.iu.se.trafficruler.AfterLogin;
import edu.iu.se.trafficruler.R;
import edu.iu.se.trafficruler.WareHouseActivity;


public class SelectTuneUpFragment extends Fragment {
Button btuneselect;
    public static SelectTuneUpFragment newInstance() {
        SelectTuneUpFragment fragment = new SelectTuneUpFragment();
        return fragment;
    }
    public SelectTuneUpFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.tune_up_fragment, container, false);
        /********************************************/
        btuneselect = (Button)rootView.findViewById(R.id.backtuneupfrag);
        btuneselect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnBackSelect(v);
            }
        });

        /*****************************/
        return rootView;
    }
    public void OnBackSelect(View view) {

        Intent goToSelectTuneup;
        goToSelectTuneup = new Intent(getActivity(),AfterLogin.class);
        startActivity(goToSelectTuneup);
    }
}


