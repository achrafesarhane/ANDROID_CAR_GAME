package edu.iu.se.trafficruler;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

/**
 * Created by Sruthi on 10/30/2015.
 */
public class WareHouseActivity extends FragmentActivity{

    private WareHousePagerAdapter mWareHouseAdaptor;
    private ViewPager mViewPager;
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        Intent getFromApperance=getIntent();
        Intent getFromTune=getIntent();
        setContentView(R.layout.activity_main);


        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mWareHouseAdaptor = new WareHousePagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mWareHouseAdaptor);

        Intent intent = getIntent();

    }


    public void OnTuneUpClick(View view) {

        Intent gotoTuneUpActivity=new Intent(this,TuneEngineLevelsActivity.class);

        startActivity(gotoTuneUpActivity);
    }

    public void OnApperanceClick(View view) {

        Intent gotoApperanceLevelsActivity=new Intent(this,ApperanceLevelsActivity.class);

        startActivity(gotoApperanceLevelsActivity);
    }


}
