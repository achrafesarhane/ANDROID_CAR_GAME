package edu.iu.se.trafficruler.fragements;
import android.support.v4.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.iu.se.trafficruler.R;

/**
     * A placeholder fragment containing a simple view.
     */
    public class LoginFragement extends Fragment {

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static LoginFragement newInstance() {
            LoginFragement fragment = new LoginFragement();
            return fragment;
        }

        public LoginFragement() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.login_fragement, container, false);
            return rootView;
        }
    }