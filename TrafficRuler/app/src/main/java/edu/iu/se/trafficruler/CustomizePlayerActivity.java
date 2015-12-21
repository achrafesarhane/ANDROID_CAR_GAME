package edu.iu.se.trafficruler;

/**
 * Created by Sruthi on 10/26/2015.
 */
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import edu.iu.se.trafficruler.fragements.CustomizePlayerLeftFragement;
import edu.iu.se.trafficruler.fragements.CustomizePlayerRight;
import edu.iu.se.trafficruler.fragements.CustomizePlayerRight2;
import edu.iu.se.trafficruler.fragements.CustomizePlayerRight3;
import edu.iu.se.trafficruler.fragements.CustomizePlayerRightFemale;
import edu.iu.se.trafficruler.fragements.CustomizePlayerRightFemale2;
import edu.iu.se.trafficruler.fragements.CustomizePlayerRightFemale3;

public class CustomizePlayerActivity extends FragmentActivity  {

    Button btuneengine;
    Button upgradehandle;
    Button acceleration;
    CustomizePlayerRight rightFrag1;
    CustomizePlayerRight2 rightFrag2;
    CustomizePlayerRight3 rightFrag3;

    CustomizePlayerRightFemale rightFrag1F;
    CustomizePlayerRightFemale2 rightFrag2F;
    CustomizePlayerRightFemale3 rightFrag3F;
    int value=100;

    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragmented_layout);
       //Intent intent = getIntent();
        value = getIntent().getExtras().getInt("Pressed");


        System.out.println("PRESSED:"+value);
        CustomizePlayerLeftFragement leftFrag=new CustomizePlayerLeftFragement();
        if(value==1)
        {

            rightFrag1= new CustomizePlayerRight();
            rightFrag2  = new CustomizePlayerRight2();
            rightFrag3  = new CustomizePlayerRight3();
            FragmentManager manager=getSupportFragmentManager();

            FragmentTransaction transaction=manager.beginTransaction();
            transaction.add(R.id.My_Container_1_ID, leftFrag, "Frag_Top_tag");
            transaction.add(R.id.My_Container_2_ID, rightFrag1, "Frag_second_tag");
            transaction.add(R.id.My_Container_3_ID, rightFrag2, "Frag_third_tag");
            transaction.add(R.id.My_Container_4_ID, rightFrag3, "Frag_fourth_tag");


            transaction.commit();
        }
        else if(value==0)
        {/*FEMALE PART*/
            rightFrag1F= new CustomizePlayerRightFemale();
            rightFrag2F  = new CustomizePlayerRightFemale2();
            rightFrag3F  = new CustomizePlayerRightFemale3();
            FragmentManager manager=getSupportFragmentManager();

            FragmentTransaction transaction=manager.beginTransaction();
            transaction.add(R.id.My_Container_1_ID, leftFrag, "Frag_Top_tag");
            transaction.add(R.id.My_Container_2_ID, rightFrag1F, "Frag_second_tag");
            transaction.add(R.id.My_Container_3_ID, rightFrag2F, "Frag_third_tag");
            transaction.add(R.id.My_Container_4_ID, rightFrag3F, "Frag_fourth_tag");


            transaction.commit();
        }
        /*DEFAULT MALE*/
        else {
            FragmentManager manager = getSupportFragmentManager();

            FragmentTransaction transaction = manager.beginTransaction();
            transaction.add(R.id.My_Container_1_ID, leftFrag, "Frag_Top_tag");
            transaction.add(R.id.My_Container_2_ID, rightFrag1, "Frag_second_tag");
            transaction.add(R.id.My_Container_3_ID, rightFrag2, "Frag_third_tag");
            transaction.add(R.id.My_Container_4_ID, rightFrag3, "Frag_fourth_tag");


            transaction.commit();
        }

    }


    public void OnPlayerClick(View view) {
        FrameLayout layout2,layout3,layout4;
        layout2= (FrameLayout)findViewById(R.id.My_Container_2_ID);
        layout3= (FrameLayout)findViewById(R.id.My_Container_3_ID);
        layout4= (FrameLayout)findViewById(R.id.My_Container_4_ID);
        switch(view.getId())
        {
            case R.id.hair:
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
            case R.id.outfits:

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
            case R.id.accessories:
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
}
