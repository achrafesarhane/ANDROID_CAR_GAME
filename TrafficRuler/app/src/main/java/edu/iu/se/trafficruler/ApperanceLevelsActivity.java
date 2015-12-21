package edu.iu.se.trafficruler;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import edu.iu.se.trafficruler.fragements.ApperanceColorLevels;
import edu.iu.se.trafficruler.fragements.ApperanceDecalOptions;
import edu.iu.se.trafficruler.fragements.ApperanceLeftFragment;
import edu.iu.se.trafficruler.fragements.ApperanceVinyls;
import edu.iu.se.trafficruler.fragements.ImproveAccelerationLevels;
import edu.iu.se.trafficruler.fragements.TuneUpEngineLevels;
import edu.iu.se.trafficruler.fragements.TuneUpLeftFragment;
import edu.iu.se.trafficruler.fragements.UpgradeHandlingLevels;


/**
 * Created by Sruthi on 10/30/2015.
 */
public class ApperanceLevelsActivity  extends FragmentActivity {

    Button btuneengine;
    Button upgradehandle;
    Button acceleration;

    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);

        Intent getFromappearanceleft=getIntent();
        setContentView(R.layout.fragmented_layout);
        Intent intent = getIntent();
        /**************************************************/
      /*  btuneengine=(Button) findViewById(R.id.tune_up_engine_button);
        upgradehandle=(Button) findViewById(R.id.upgrade_handling_button);
        acceleration=(Button) findViewById(R.id.improve_acceleration_button);
        btuneengine.setOnClickListener(myOnlyHandler);



        /****************************************************/

        ApperanceLeftFragment leftFrag = new ApperanceLeftFragment();
        ApperanceColorLevels rightFrag1 = new ApperanceColorLevels();
        ApperanceDecalOptions rightFrag2 = new ApperanceDecalOptions();
        ApperanceVinyls rightFrag3 = new ApperanceVinyls();


        FragmentManager manager = getSupportFragmentManager();

        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.My_Container_1_ID, leftFrag, "Apperance_Frag_Top_tag");
        transaction.add(R.id.My_Container_2_ID, rightFrag1, "Apperance_Frag_second_tag");
        transaction.add(R.id.My_Container_3_ID, rightFrag2, "Apperance_Frag_third_tag");
        transaction.add(R.id.My_Container_4_ID, rightFrag3, "Apperance_Frag_fourth_tag");


        transaction.commit();
    }


    public void OnDecalClickListener(View view) {

        Intent intent=new Intent(this,ShowResult.class);
        startActivity(intent);
    }



    public void OnApperanceOptionsClick(View view) {
        FrameLayout layout2,layout3,layout4;
        layout2= (FrameLayout)findViewById(R.id.My_Container_2_ID);
        layout3= (FrameLayout)findViewById(R.id.My_Container_3_ID);
        layout4= (FrameLayout)findViewById(R.id.My_Container_4_ID);
        switch(view.getId())
        {
            case R.id.color_button:
                if(layout2.getVisibility()==View.GONE) {
                    layout3.setVisibility(View.INVISIBLE);
                    layout4.setVisibility(View.INVISIBLE);
                    layout2.setVisibility(View.VISIBLE);
                }
                else if(layout2.getVisibility()==View.INVISIBLE){
                    layout3.setVisibility(View.INVISIBLE);
                    layout4.setVisibility(View.INVISIBLE);
                    layout2.setVisibility(View.VISIBLE);
                }
                else{
                    layout2.setVisibility(View.INVISIBLE);
                }
                break;
            case R.id.decals_button:

                if(layout3.getVisibility()==View.GONE) {
                    layout2.setVisibility(View.INVISIBLE);
                    layout4.setVisibility(View.INVISIBLE);
                    layout3.setVisibility(View.VISIBLE);
                }
                else if(layout3.getVisibility()==View.INVISIBLE){
                    layout2.setVisibility(View.INVISIBLE);
                    layout4.setVisibility(View.INVISIBLE);
                    layout3.setVisibility(View.VISIBLE);
                }
                else{
                    layout3.setVisibility(View.INVISIBLE);
                }
                break;
            case R.id.vinyl_button:
                if(layout4.getVisibility()==View.GONE) {
                    layout2.setVisibility(View.INVISIBLE);
                    layout3.setVisibility(View.INVISIBLE);
                    layout4.setVisibility(View.VISIBLE);
                }
                else if(layout4.getVisibility()==View.INVISIBLE){
                    layout2.setVisibility(View.INVISIBLE);
                    layout3.setVisibility(View.INVISIBLE);
                    layout4.setVisibility(View.VISIBLE);
                }
                else{
                    layout4.setVisibility(View.INVISIBLE);
                }
                break;
            default:
                Toast.makeText(this,"Not working",Toast.LENGTH_SHORT);
        }
    }


    public void OnColorClicked(View view) {

        Intent intent=new Intent(this, ShowResult.class);
        startActivity(intent);
    }

}