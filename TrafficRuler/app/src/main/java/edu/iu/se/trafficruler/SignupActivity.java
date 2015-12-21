package edu.iu.se.trafficruler;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.SQLException;

/**
 * Created by Sruthi on 10/28/2015.
 */
public class SignupActivity extends AppCompatActivity {
    EditText editTextUserName,editTextPassword,editTextConfirmPassword;
    Button btnCreateAccount;
boolean success=false;
    LoginDataBaseAdapter loginDataBaseAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        // get Instance  of Database Adapter
        loginDataBaseAdapter=new LoginDataBaseAdapter(this);
        try {
            loginDataBaseAdapter=loginDataBaseAdapter.open();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Get Refferences of Views
        editTextUserName=(EditText)findViewById(R.id.editTextUserName);
        editTextPassword=(EditText)findViewById(R.id.editTextPassword);
        editTextConfirmPassword=(EditText)findViewById(R.id.editTextConfirmPassword);

        btnCreateAccount=(Button)findViewById(R.id.buttonCreateAccount);
        btnCreateAccount.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub

                String userName = editTextUserName.getText().toString();
                String password = editTextPassword.getText().toString();
                String confirmPassword = editTextConfirmPassword.getText().toString();

                // check if any of the fields are vaccant
                if (userName.equals("") || password.equals("") || confirmPassword.equals("")) {
                    Toast.makeText(getApplicationContext(), "Field Vaccant", Toast.LENGTH_LONG).show();
                    return;
                }
                // check if both password matches
                if (!password.equals(confirmPassword)) {
                    Toast.makeText(getApplicationContext(), "Password does not match", Toast.LENGTH_LONG).show();
                    return;
                } else {
                    // Save the Data in Database
                    loginDataBaseAdapter.insertEntry(userName, password);
                    Toast.makeText(getApplicationContext(), "Account Successfully Created ", Toast.LENGTH_LONG).show();
                    success = true;
                    Global.UserName = userName;
                    Global.Points=0;
                    Intent goTOAfterLogin = new Intent(getApplicationContext(), MainMenu.class);
                    startActivity(goTOAfterLogin);
                    finish();

                }
            }
        });

        if(success)
        { Toast.makeText(getApplicationContext(), "ONE AND ONLY", Toast.LENGTH_LONG).show();
            System.out.println("REACHED");
            Intent goTOAfterLogin =new Intent(this ,MainMenu.class);
            startActivity(goTOAfterLogin);
            finish();
        }
    }


   @Override
   protected void onDestroy() {
        // TODO Auto-generated method stub
        System.out.print("SDSJKFAKFB");
        super.onDestroy();

        loginDataBaseAdapter.close();
    }


}
