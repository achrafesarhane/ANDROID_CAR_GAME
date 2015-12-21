package edu.iu.se.trafficruler;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.SQLException;

public class MainActivity extends AppCompatActivity {

   Button btnSignIn,btnSignUp;
    Button btn_Quit;

    public static LoginDataBaseAdapter  loginDataBaseAdapter;
   boolean success=false;
    private SectionsPagerAdapter mSectionsPagerAdapter;


    private ViewPager mViewPager;
    String u1="USEFUL";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        // create a instance of SQLite Database
        loginDataBaseAdapter=new LoginDataBaseAdapter(this);
        try {
            loginDataBaseAdapter=loginDataBaseAdapter.open();
        } catch (SQLException e) {
            e.printStackTrace();
        }



        // Get The Reference Of Buttons
        btnSignIn=(Button)findViewById(R.id.buttonSignIN);
        btnSignUp=(Button)findViewById(R.id.buttonSignUP);

       btnSignUp.setOnClickListener(new View.OnClickListener() {
           public void onClick(View v) {
                // TODO Auto-generated method stub
                /// Create Intent for SignUpActivity  abd Start The Activity
              Intent intentSignUP=new Intent(getApplicationContext(),SignupActivity.class);
              startActivity(intentSignUP);
         }
     });
        Intent intent = getIntent();
        btn_Quit = (Button) findViewById(R.id.btn_Quit);
        btn_Quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),AfterLogin.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                finish();
                android.os.Process.killProcess(android.os.Process.myPid());
            }
        });


    }
    public void signIn(View V)
    {
        final Dialog dialog = new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.login);
        dialog.setTitle("Login");

        // get the References of views
        final  EditText editTextUserName=(EditText)dialog.findViewById(R.id.editTextUserNameToLogin);
        final EditText editTextPassword=(EditText)dialog.findViewById(R.id.editTextPasswordToLogin);

        Button btnSignIn = (Button)dialog.findViewById(R.id.buttonSignIn);

        // Set On ClickListener
        btnSignIn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // get The User name and Password
                String userName = editTextUserName.getText().toString();
                String password = editTextPassword.getText().toString();

                // fetch the Password form database for respective user name
                String storedPassword = loginDataBaseAdapter.getSinlgeEntry(userName);

                // check if the Stored password matches with  Password entered by user
                if (password.equals(storedPassword)) {
                    Toast.makeText(MainActivity.this, "Congrats: Login Successfull", Toast.LENGTH_LONG).show();


                    dialog.dismiss();
                    Intent goTOAfterLogin =new Intent(getApplicationContext() ,MainMenu.class);
                    //goTOAfterLogin.putExtra("User_Name",userName);
                    Global.UserName = userName;
                    Global.Points=0;
                    startActivity(goTOAfterLogin);
                    finish();
                }
//                else {
//                    success = true;
//
//                    Toast.makeText(MainActivity.this, "User Name or Password does not match", Toast.LENGTH_LONG).show();
//
//                }
            }
        });

        dialog.show();
//        if(success)
//        {
//            System.out.println("REACHED");
//            Intent goTOAfterLogin =new Intent(this ,AfterLogin.class);
//            startActivity(goTOAfterLogin);
//        }

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
    public void OnWareHouseButtonClick1(View view) {

      /*  Intent getNameScreenIntent=new Intent(this,SecondScreen.class);
        final int result=1;

        getNameScreenIntent.putExtra("callingActivity", "MainActivity");
        //startActivity(getNameScreenIntent);
        startActivityForResult(getNameScreenIntent, result);
*/

        //final int result=1;

        Intent gotToWareHouse=new Intent(this,WareHouseActivity.class);

        //sendBob.putExtra("humanBob",bob);
        startActivity(gotToWareHouse);
    }




    public void OnWareHouseButtonClick(View view) {

      /*  Intent getNameScreenIntent=new Intent(this,SecondScreen.class);
        final int result=1;

        getNameScreenIntent.putExtra("callingActivity", "MainActivity");
        //startActivity(getNameScreenIntent);
        startActivityForResult(getNameScreenIntent, result);
    */
        //final int result=1;

       Intent gotToWareHouse=new Intent(this,Vehicle_Adapter_Activity.class);

        //sendBob.putExtra("humanBob",bob);
        startActivity(gotToWareHouse);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Close The Database
     //   loginDataBaseAdapter.close();
    }

}
