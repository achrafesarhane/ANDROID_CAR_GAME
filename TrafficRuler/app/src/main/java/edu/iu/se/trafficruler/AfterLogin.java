package edu.iu.se.trafficruler;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

/**
 * Created by Sruthi on 10/28/2015.
 */
public class AfterLogin extends AppCompatActivity {

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
       // loginDataBaseAdapter

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void OnWareHouseButtonClick(View view) {

        Intent gotToWareHouse=new Intent(this,Vehicle_Adapter_Activity.class);
        startActivity(gotToWareHouse);
        finish();
    }
    public  void OnSettingsButtonClick(View view)
    {
        Intent gotToWareHouse1=new Intent(this,Settings_Options_Activity.class);
        startActivity(gotToWareHouse1);


    }

    public void OnWareHouseButtonClick1(View view) {

      /*  Intent getNameScreenIntent=new Intent(this,SecondScreen.class);
        final int result=1;

        getNameScreenIntent.putExtra("callingActivity", "MainActivity");
        //startActivity(getNameScreenIntent);
        startActivityForResult(getNameScreenIntent, result);
*/

        //final int result=1;

        Intent gotToWareHouse1=new Intent(this,WareHouseActivity.class);

        //sendBob.putExtra("humanBob",bob);
        startActivity(gotToWareHouse1);
    }


}
