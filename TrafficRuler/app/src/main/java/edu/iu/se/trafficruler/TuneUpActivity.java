package edu.iu.se.trafficruler;

/**
 * Created by Sruthi on 10/30/2015.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Toast;

/**
 * Created by Vikrant Kaushal on 10/25/2015.
 */
public class TuneUpActivity extends Activity{

    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.tune_up_options_fragment);
        Intent intent = getIntent();
    }


    public void OnTuneEngineClick(View view) {

        Toast.makeText(this,"Hello",Toast.LENGTH_SHORT);

        Intent gotoTuneUpActivity=new Intent(this,TuneEngineLevelsActivity.class);

        startActivity(gotoTuneUpActivity);
    }


}
