package edu.iu.se.trafficruler;

/**
 * Created by Sruthi on 10/30/2015.
 */


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.HashMap;
import java.util.Map;

import edu.iu.se.trafficruler.fragements.SelectAppearanceFragment;
import edu.iu.se.trafficruler.fragements.SelectTuneUpFragment;

public class WareHousePagerAdapter extends FragmentPagerAdapter {

    private static int NUM_ITEMS = 2;

    public WareHousePagerAdapter(FragmentManager fm) {
        super(fm);
    }


    Map<Integer, Fragment> handlers = new HashMap<Integer, Fragment>();

    {
        handlers.put(0, SelectTuneUpFragment.newInstance());
        handlers.put(1, SelectAppearanceFragment.newInstance());
    }


    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).

        //create selected view
        return handlers.get(position);
    }

    public int getCount() {
        // Show 2 total pages.
        return NUM_ITEMS;
    }



}
