package edu.iu.se.trafficruler.fragements;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import edu.iu.se.trafficruler.Choose_Player_Activity;
import edu.iu.se.trafficruler.Global;
import edu.iu.se.trafficruler.R;
import edu.iu.se.trafficruler.UserOptions.UserSelection;

/**
 * Created by Sruthi on 10/25/2015.
 */
public class Vehicle_Bike_Fragement extends Fragment {
    Button bbike;
    TextView txt_Points;
    public static Vehicle_Bike_Fragement newInstance() {
        Vehicle_Bike_Fragement fragment = new Vehicle_Bike_Fragement();
        return fragment;
    }

    public Vehicle_Bike_Fragement() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.vehicle_bike, container, false);


        txt_Points = (TextView) rootView.findViewById(R.id.txt_Points);
        txt_Points.setText(String.valueOf( Global.Points));

        /********************************************/
        bbike = (Button)rootView.findViewById(R.id.ImageButton03);
        bbike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnBikeClick(v);
            }
        });

        /*****************************/

        return rootView;
    }
    public void OnBikeClick(View view) {

        Intent goToChoosePlayer;
        goToChoosePlayer = new Intent(getActivity(),Choose_Player_Activity.class);
        UserSelection.setVehicleType(UserSelection.VehicleType.Bike);
        //sendBob.putExtra("humanBob",bob);
        startActivity(goToChoosePlayer);
    }

}
