package edu.iu.se.trafficruler;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;


/**
 * Created by Vikrant Kaushal on 10/29/2015.
 */
public class ShowResult extends FragmentActivity {

    Button button;
    ImageView vinyl,decal,show_head,show_body;
    TextView scoreText,pointesScored;
    FrameLayout frame;
    LoginDataBaseAdapter loginDataBaseAdapter=new LoginDataBaseAdapter(this);
    SignupActivity signupActivity=new SignupActivity();

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_result);


        int selectedcar=1;
        int selectedDecal=1;
        int selectedVinyl=1;

        String finalCar="decals_"+selectedcar;
        String finalDecal="decals_"+selectedDecal;
        String finalVinyl="decals_"+selectedVinyl;

        frame= (FrameLayout) findViewById(R.id.background);
        vinyl = (ImageView) findViewById(R.id.show_vinyl);
        decal = (ImageView) findViewById(R.id.show_decal);
        show_head=(ImageView) findViewById(R.id.show_head);
        show_body=(ImageView) findViewById(R.id.show_body);
        scoreText=(TextView) findViewById(R.id.scoreText);
        pointesScored=(TextView) findViewById(R.id.pointsScored);


      /*  int playerType=loginDataBaseAdapter.getPlayertype(signupActivity.uName);
        int vehicleType=loginDataBaseAdapter.getvehicletype(signupActivity.uName);
        int accelerationType=loginDataBaseAdapter.getaccelerationtype(signupActivity.uName);
        int accessoriesType=loginDataBaseAdapter.getaccessoriesttype(signupActivity.uName);
        int colorType=loginDataBaseAdapter.getcolor(signupActivity.uName);
        int decalType=loginDataBaseAdapter.getdecals(signupActivity.uName);
        int hairType=loginDataBaseAdapter.gethairtype(signupActivity.uName);
        int outfitType=loginDataBaseAdapter.getoutfittype(signupActivity.uName);
        int tuneupType=loginDataBaseAdapter.gettuneuptype(signupActivity.uName);
        int vinylType=loginDataBaseAdapter.getvinyls(signupActivity.uName);
        int upgradeType=loginDataBaseAdapter.getupgradetype(signupActivity.uName);
*/

        String str="abc";


/*
        frame.setBackgroundResource(R.drawable.car_+"1");
        vinyl.setImageResource(R.drawable.vinyl_2);
        decal.setImageResource(R.drawable.decals_1);
        show_head.setImageResource(R.mipmap.head1);
        show_body.setImageResource(R.mipmap.girlhead1);

*/


        Intent intent = getIntent();


    }


    public void gotToMainMenu(View view) {

        Intent intent = new Intent(getApplicationContext(),MainMenu.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        //finish();

        show_head=(ImageView) findViewById(R.id.show_head);

        show_head.setImageResource(R.mipmap.head3);
        //int id=getResources().getIdentifier("edu.iu.se.trafficruler:drawable/","vinyl_2",);



        String name="download";

        Context context = MyApplication.getContext();


        decal= (ImageView)findViewById(R.id.show_decal);

        //String fnm = "cat"; //  this is image file name
        String PACKAGE_NAME = getApplicationContext().getPackageName();
        //int imgId = getResources().getIdentifier(PACKAGE_NAME+":mipmap-hdpi/"+name , null, null);
        int imgId = ShowResult.this.getResources().getIdentifier("acc2" , "drawable",ShowResult.this.getPackageName());
        //int imgId1 = getResources().getIdentifier("acc1" , "drawable",PACKAGE_NAME);
        try {
            int resourceId = R.drawable.class.getDeclaredField("decal_2").getInt(null);
            System.out.println("Fix :: "+resourceId);
        }catch(Exception ex)
        {
            System.out.println("Exception :: "+ex);
        }
        System.out.println("IMG ID :: "+imgId);
        //  System.out.println("IMG ID :: "+imgId1);
        System.out.println("PACKAGE_NAME :: "+PACKAGE_NAME);
//    Bitmap bitmap = BitmapFactory.decodeResource(getResources(),imgId);
        //  decal.setImageBitmap(BitmapFactory.decodeResource(getResources(),imgId));


        // String uri = "@drawable/myresource";  // where myresource.png is the file
        // extension removed from the String

        /*int imageResource = getResources().getIdentifier(name, null, getPackageName());

        decal= (ImageView)findViewById(R.id.show_decal);
        Drawable res = getResources().getDrawable(imageResource);
        decal.setImageDrawable(res);
*/



        // int resourceId = context.getResources().getIdentifier(name, "drawable", MyApplication.getContext().getPackageName());
        //int resourceId = getResources().getIdentifier(name, "drawable", "edu.iu.se.trafficruler");


        //System.out.println("ResourceId :"+resourceId);

        //frame.setBackgroundResource(R.drawable.car_3);
        //vinyl.setImageResource(R.drawable.vinyl_2);

        //rohisasi@indiana.edu

    }

}

