package edu.iu.se.trafficruler.fragements;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import edu.iu.se.trafficruler.AfterLogin;
import edu.iu.se.trafficruler.R;

/**
 * Created by Sruthi on 10/30/2015.
 */
public class SelectAppearanceFragment extends Fragment {
    Button bappselect;
    public static SelectAppearanceFragment newInstance() {
        SelectAppearanceFragment fragment = new SelectAppearanceFragment();
        return fragment;
    }

    public SelectAppearanceFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.appearance_fragment, container, false);
        /********************************************/
        bappselect = (Button)rootView.findViewById(R.id.backappfrag);
        bappselect.setOnClickListener(new View.OnClickListener() {
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
