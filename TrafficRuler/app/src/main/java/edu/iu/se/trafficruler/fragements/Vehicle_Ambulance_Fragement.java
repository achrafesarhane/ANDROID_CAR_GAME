package edu.iu.se.trafficruler.fragements;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v4.app.Fragment;
import android.os.Bundle;
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

/**
 * Created by Sruthi on 10/25/2015.
 */
public class Vehicle_Ambulance_Fragement extends Fragment {
    Button btn_Amb;
    TextView txt_diswar;
    TextView txt_Points;

    public static Vehicle_Ambulance_Fragement newInstance() {
        Vehicle_Ambulance_Fragement  fragment = new Vehicle_Ambulance_Fragement();

        return fragment;
    }

    public Vehicle_Ambulance_Fragement() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.vehicle_ambulance, container, false);


        btn_Amb = (Button)rootView.findViewById(R.id.btn_Amb);
        txt_diswar = (TextView) rootView.findViewById(R.id.txt_diswar);
        txt_Points = (TextView) rootView.findViewById(R.id.txt_Points);
        txt_Points.setText(String.valueOf( Global.Points));

        btn_Amb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    OnAmbClick(v);

                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        });
        if (Global.Points < 100){
            btn_Amb.setEnabled(false);
            txt_diswar.setText("To unlock please score more than 100 points");
        }
        else{
            btn_Amb.setEnabled(true);
            txt_diswar.setEnabled(false);
        }
        return rootView;
    }

    public void OnAmbClick(View view) throws SQLException {

        //DATABASE HANDLING
        //DatabaseHandler db = new DatabaseHandler(getActivity());
        //loginDataBaseAdapter=new LoginDataBaseAdapter(getActivity());
        //loginDataBaseAdapter=loginDataBaseAdapter.open();
        //loginDataBaseAdapter.setvehicletype(userName, password);


        Intent goToChoosePlayer;
        goToChoosePlayer = new Intent(getActivity(),Choose_Player_Activity.class);
        UserSelection.setVehicleType(UserSelection.VehicleType.Ambulance);
        startActivity(goToChoosePlayer);
        this.getActivity().finish();
    }

}
