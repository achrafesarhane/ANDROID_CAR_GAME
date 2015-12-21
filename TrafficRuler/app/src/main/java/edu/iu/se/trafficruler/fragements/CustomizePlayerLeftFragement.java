package edu.iu.se.trafficruler.fragements;

/**
 * Created by Sruthi on 10/26/2015.
 */
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import edu.iu.se.trafficruler.Choose_Player_Activity;
import edu.iu.se.trafficruler.CustomizePlayerActivity;
import edu.iu.se.trafficruler.R;

public class CustomizePlayerLeftFragement extends Fragment {
    Button bback;
    public static CustomizePlayerLeftFragement newInstance() {
        CustomizePlayerLeftFragement fragment = new CustomizePlayerLeftFragement();
        return fragment;
    }

    public CustomizePlayerLeftFragement() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.customizeplayerleft, container, false);
        /********************************************/
        bback = (Button)rootView.findViewById(R.id.backbuttoncustom);
        bback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnBackClick(v);
            }
        });

        /*****************************/
        return rootView;
    }
    public void OnBackClick(View view) {

        Intent goToCustomizePlayer;
        goToCustomizePlayer = new Intent(getActivity(),Choose_Player_Activity.class);
        startActivity(goToCustomizePlayer);
    }
}


