package edu.iu.se.trafficruler.fragements;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.sql.SQLException;

import edu.iu.se.trafficruler.Choose_Player_Activity;
import edu.iu.se.trafficruler.Global;
import edu.iu.se.trafficruler.R;
import edu.iu.se.trafficruler.UserOptions.UserSelection;

import static edu.iu.se.trafficruler.MainActivity.loginDataBaseAdapter;

//import edu.iu.se.trafficruler.R;
//import edu.iu.se.trafficruler.DatabaseHandler;


/**
 * Created by Sruthi on 10/25/2015.
 */
public class Vehicle_Bicycle_Fragement extends Fragment {



    //LoginDataBaseAdapter loginDataBaseAdapter;
    TextView txt_Points;
    Button bcycle;


    public static Vehicle_Bicycle_Fragement newInstance() {
        return new Vehicle_Bicycle_Fragement();
    }

    public Vehicle_Bicycle_Fragement() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView;
        rootView = inflater.inflate(R.layout.vehicle_bicycle, container, false);

        txt_Points = (TextView) rootView.findViewById(R.id.txt_Points);
        txt_Points.setText(String.valueOf( Global.Points));

/********************************************/
        bcycle = (Button)rootView.findViewById(R.id.ImageButton02);
        bcycle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    OnBicycleClick(v);

                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        });

        /*****************************/

        return rootView;
    }

    public void OnBicycleClick(View view) throws SQLException {

        //DATABASE HANDLING
        //DatabaseHandler db = new DatabaseHandler(getActivity());
        //loginDataBaseAdapter=new LoginDataBaseAdapter(getActivity());
        //loginDataBaseAdapter=loginDataBaseAdapter.open();
        //loginDataBaseAdapter.setvehicletype(userName, password);
        String t=loginDataBaseAdapter.getSinlgeEntry("srameshv");

        Intent goToChoosePlayer;
        goToChoosePlayer = new Intent(getActivity(),Choose_Player_Activity.class);
        UserSelection.setVehicleType(UserSelection.VehicleType.Cycle);
        startActivity(goToChoosePlayer);
        this.getActivity().finish();
    }

}
