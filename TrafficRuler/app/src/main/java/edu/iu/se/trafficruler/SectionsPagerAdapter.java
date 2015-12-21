package edu.iu.se.trafficruler;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.HashMap;
import java.util.Map;

import edu.iu.se.trafficruler.fragements.LoginFragement;
import edu.iu.se.trafficruler.fragements.SelectCarOptionsFragement;
import edu.iu.se.trafficruler.fragements.SelectSettingsOptionsFragement;
import edu.iu.se.trafficruler.fragements.SelectWarehouseOptionsFragement;

/**
 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {
    private static int NUM_ITEMS = 3;

    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    Map<Integer, Fragment> handlers = new HashMap<Integer, Fragment>();

    {
        //handlers.put(0, LoginFragement.newInstance());
        handlers.put(0, SelectCarOptionsFragement.newInstance());
        handlers.put(1, SelectWarehouseOptionsFragement.newInstance());
        handlers.put(2, SelectSettingsOptionsFragement.newInstance());
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
        // Show 4 total pages.
        return NUM_ITEMS;
    }
}
