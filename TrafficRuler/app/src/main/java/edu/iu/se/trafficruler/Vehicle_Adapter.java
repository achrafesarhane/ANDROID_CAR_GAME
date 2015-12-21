package edu.iu.se.trafficruler;


import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import edu.iu.se.trafficruler.fragements.Vehicle_Ambulance_Fragement;
import edu.iu.se.trafficruler.fragements.Vehicle_Bicycle_Fragement;
import edu.iu.se.trafficruler.fragements.Vehicle_Bike_Fragement;
import edu.iu.se.trafficruler.fragements.Vehicle_Car_Fragement;

/**
 * Created by Sruthi on 10/25/2015.
 */
public class Vehicle_Adapter extends FragmentPagerAdapter  {
    private static int NUM_ITEMS = 4;

    public Vehicle_Adapter(FragmentManager fm) {
        super(fm);
    }



    Map<Integer, Fragment> handlers = new HashMap<Integer, Fragment>();

    {
        handlers.put(0, Vehicle_Bicycle_Fragement.newInstance());
        handlers.put(1, Vehicle_Bike_Fragement.newInstance());
        handlers.put(2, Vehicle_Car_Fragement.newInstance());
        handlers.put(3, Vehicle_Ambulance_Fragement.newInstance());


    }
    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).

        //create selected view
        return handlers.get(position);

    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return NUM_ITEMS;
    }


}
