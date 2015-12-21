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

import edu.iu.se.trafficruler.ApperanceLevelsActivity;
import edu.iu.se.trafficruler.Choose_Player_Activity;
import edu.iu.se.trafficruler.R;
import edu.iu.se.trafficruler.WareHouseActivity;

/**
 * Created by Vikrant Kaushal on 10/26/2015.
 */
public class ApperanceLeftFragment extends Fragment {

    Button bback1;
    public static ApperanceLeftFragment newInstance() {
        ApperanceLeftFragment fragment = new ApperanceLeftFragment();
        return fragment;
    }

    public ApperanceLeftFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.appearance_left_fragment, container, false);
        /********************************************/
        bback1 = (Button)rootView.findViewById(R.id.vikback);
        bback1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnBackClickApp(v);
            }
        });

        /*****************************/

        return rootView;
    }
    public void OnBackClickApp(View view) {

        Intent goToSelectTuneup;
        goToSelectTuneup = new Intent(getActivity(),WareHouseActivity.class);
        startActivity(goToSelectTuneup);
    }
}
