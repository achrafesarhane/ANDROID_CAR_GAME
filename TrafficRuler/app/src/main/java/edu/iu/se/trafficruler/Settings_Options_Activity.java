package edu.iu.se.trafficruler;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import edu.iu.se.trafficruler.fragements.SelectSettingsOptionsFragement;

/**
 * Created by Sruthi on 10/25/2015.
 */
public class Settings_Options_Activity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Button bjuke;
    Spinner spinnerCategories;
/*    private Spinner spinner1, spinner2;
    Spinner spinnerCategories;
    TextView selVersion;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_options_activity);

        Intent intent = getIntent();

      /*  spinnerCategories = (Spinner) findViewById(R.id.poi_categories);
        spinnerCategories.setOnItemSelectedListener(this);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.planets_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinnerCategories.setAdapter(adapter);*/


       //  String message = intent.getStringExtra(edu.iu.se.trafficruler.fragements.SelectSettingsOptionsFragement.EXTRA_MESSAGE);

        /*TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(message);
        setContentView(textView);*/

    /*    String[] poiCategories = {"High", "Medium", "Low"};
        selVersion = (TextView) findViewById(R.id.selVersion);
        spinnerCategories = (Spinner) findViewById(R.id.poi_categories);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.planets_array,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        spinnerCategories.setAdapter(adapter);
        spinnerCategories.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
*/

    }
    public void backtoscreen(View view)
    {
        Intent goTo=new Intent(this,AfterLogin.class);
        startActivity(goTo);
    }

    public void gotoJuke(View view) {

      /*  Intent getNameScreenIntent=new Intent(this,SecondScreen.class);
        final int result=1;

        getNameScreenIntent.putExtra("callingActivity", "MainActivity");
        //startActivity(getNameScreenIntent);
        startActivityForResult(getNameScreenIntent, result);
*/

        //final int result=1;

        Intent goToJuke=new Intent(this,JukeBox.class);
        //sendBob.putExtra("humanBob",bob);
        startActivity(goToJuke);
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

  /*     public void onItemSelected(AdapterView<?> parent, View view,int pos, long id) {
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)


        spinnerCategories.setSelection(pos);
        String selState = (String) spinnerCategories.getSelectedItem();
        selVersion.setText("Selected Android OS:" + selState);
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }*/
  public void onItemSelected(AdapterView<?> parent, View view,
                             int pos, long id) {
      // An item was selected. You can retrieve the selected item using
      // parent.getItemAtPosition(pos) spinnerCategories.setSelection(pos);
      String selState = (String) spinnerCategories.getSelectedItem();

      System.out.println(selState);



  }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }

}