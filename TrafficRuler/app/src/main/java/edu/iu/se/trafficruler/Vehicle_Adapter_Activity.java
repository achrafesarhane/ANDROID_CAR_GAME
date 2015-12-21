package edu.iu.se.trafficruler;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.style.LeadingMarginSpan;
import android.view.View;
import android.widget.RelativeLayout;

import java.sql.SQLException;


/**
 * Created by Sruthi on 10/25/2015.
 */
public class Vehicle_Adapter_Activity extends FragmentActivity{


        private Vehicle_Adapter mVechicleAdaptor;
        private ViewPager mViewPager;

        protected void onCreate(Bundle savedInstanceState)
        {
                super.onCreate(savedInstanceState);
               setContentView(R.layout.activity_main);



           /* if(score>=10) {


                /***************************************************
                RelativeLayout rl1 = (RelativeLayout) findViewById(R.id.);
                rl1.setVisibility(View.INVISIBLE);
                RelativeLayout rl2 = (RelativeLayout) findViewById(R.id.rl2);
                rl2.setVisibility(View.VISIBLE);
                **************************************************/
                // Create the adapter that will return a fragment for each of the three
                // primary sections of the1 activity.
            //}
            mVechicleAdaptor = new Vehicle_Adapter(getSupportFragmentManager());

            // Set up the ViewPager with the sections adapter.
            mViewPager = (ViewPager) findViewById(R.id.container);
            mViewPager.setAdapter(mVechicleAdaptor);

            Intent intent = getIntent();
            Intent getintentfromchoose=getIntent();

        }

    public void OnBackButtonClick(View view) {

      /*  Intent getNameScreenIntent=new Intent(this,SecondScreen.class);
        final int result=1;

        getNameScreenIntent.putExtra("callingActivity", "MainActivity");
        //startActivity(getNameScreenIntent);
        startActivityForResult(getNameScreenIntent, result);
*/

        //final int result=1;

        Intent goToCarFragment=new Intent(this,AfterLogin.class);
                //sendBob.putExtra("humanBob",bob);
        startActivity(goToCarFragment);
    }

        public void OnTuneUpClick(View view) {

            // Intent gotToWareHouse=new Intent(this,SelectTupeUpEngine.class);

            //startActivity(gotToWareHouse);
        }


    }

