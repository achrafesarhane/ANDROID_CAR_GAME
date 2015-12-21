package edu.iu.se.trafficruler.fragements;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.iu.se.trafficruler.R;

/**
 * Created by Sruthi on 10/28/2015.
 */
public class CustomizePlayerRightFemale3 extends Fragment
{
        public static CustomizePlayerRightFemale3 newInstance() {
            CustomizePlayerRightFemale3 fragment = new CustomizePlayerRightFemale3();
            return fragment;
        }

        public CustomizePlayerRightFemale3() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.customizeplayerrightfemale3, container, false);
            return rootView;
        }
    }


