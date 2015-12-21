package edu.iu.se.trafficruler.fragements;
import android.content.Intent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;

import edu.iu.se.trafficruler.R;
import edu.iu.se.trafficruler.Settings_Options_Activity;
//import edu.iu.se.trafficruler.R;
//import edu.iu.se.trafficruler.Setting_Options_Activity;

/**
 * A placeholder fragment containing a simple view.
 */
public class SelectSettingsOptionsFragement extends Fragment{

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
  //  Button button;
    public final static String EXTRA_MESSAGE = "edu.iu.se.trafficruler.MESSAGE";
    public static SelectSettingsOptionsFragement newInstance() {
        SelectSettingsOptionsFragement fragment = new SelectSettingsOptionsFragement();

        return fragment;
    }

    public SelectSettingsOptionsFragement() {
    }


    /** Called when the user clicks the Send button */


 @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.settings_fragement, container, false);
       // addListenerOnButton();

      //  button = (Button)rootView.findViewById(R.id.button2);
    /* android:onClick="sendMessage1" THIS WAS ADED IN THE XML

    button.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             sendMessage1(v);
         }
     });*/

     return rootView;
    }

   /* public void sendMessage1(View view)
    {
        // Do something in response to button
        Intent intent;
        intent = new Intent(getActivity(),edu.iu.se.trafficruler.Settings_Options_Activity.class);
        //EditText editText = (EditText)view.findViewById(R.id.edit_message);
     //   String message = editText.getText().toString();
       // intent.putExtra(EXTRA_MESSAGE, message);

        startActivity(intent);


    }*/

    }