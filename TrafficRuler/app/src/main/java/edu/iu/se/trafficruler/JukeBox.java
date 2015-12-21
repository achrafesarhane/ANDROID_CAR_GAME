package edu.iu.se.trafficruler;

/**
 * Created by Sruthi on 10/30/2015.
 */

import android.app.Dialog;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class JukeBox extends AppCompatActivity {
    Button btn_Browse;
    Button btn_Up;
    Button btn_Play;
    Button btn_Stop;
    Button btn_Next;
    Button btn_Back;
    ToggleButton tbtn_Shuffle;
    TextView textFolder;

    public static int mu_pos=0;
    Random rno = new Random ();
    public static int is_shuffle=0;


    String KEY_TEXTPSS = "TEXTPSS";
    static final int CUSTOM_DIALOG_ID = 0;
    ListView dialog_ListView;
    ListView showFiles;


    File root;
    public static File curFolder;



    private List<String> fileList = new ArrayList<String>();
    //private List<String> getFiles = new ArrayList<String>();

    ArrayAdapter<String> show_Files_adaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        show_Files_adaptor = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Global.getFiles);

        setContentView(R.layout.activity_juke_box);

        showFiles = (ListView) findViewById(R.id.showFiles);
        showFiles.setAdapter(show_Files_adaptor);
        registerForContextMenu(showFiles);




        btn_Browse = (Button) findViewById(R.id.btn_Browse);
        btn_Browse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(CUSTOM_DIALOG_ID);
            }
        });

        tbtn_Shuffle = (ToggleButton) findViewById(R.id.tbtn_Shuffle);
        tbtn_Shuffle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    is_shuffle=1;
                } else {
                    is_shuffle=0;
                }
            }
        });

        btn_Back = (Button) findViewById(R.id.btn_Back);
        btn_Back.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(getApplicationContext(),.class);
                finish();
                //startActivity(intent);
            }
        });


        btn_Play = (Button) findViewById(R.id.btn_Play);
        btn_Play.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                //ListView showFiles = (ListView) findViewById(R.id.showFiles);
                //showFiles.setAdapter(show_Files_adaptor);
                //while(mu_pos < getFiles.size()) {
                //Toast.makeText(getApplicationContext(),getFiles.get(position).toString(),Toast.LENGTH_SHORT).show();

                if (Global.getFiles.size() == 0)
                    return;

                if (is_shuffle == 1){
                    int temp = rno.nextInt(Global.getFiles.size()-1) ;
                    if (temp == mu_pos  )
                        if ( temp < Global.getFiles.size())
                            mu_pos = ++temp;
                        else mu_pos = 0 ;
                    else mu_pos = temp;
                    //Log.e("Play ran: ",String.valueOf(mu_pos));
                }

                Global.mediaPlayer = MediaPlayer.create(getApplicationContext(), Uri.fromFile(new File(Global.getFiles.get(mu_pos).toString())));
                Global.mediaPlayer.start();


                Global.mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        //Log.e("IS it waiting ", String.valueOf(mu_pos));

                        if (is_shuffle == 1){
                            int temp = rno.nextInt(Global.getFiles.size()-1) ;
                            if (temp == mu_pos  )
                                if ( temp < Global.getFiles.size()-1)
                                    mu_pos = ++temp;
                                else mu_pos = 0 ;
                            else mu_pos = temp;
                            //Log.e("Play ran: ",String.valueOf(mu_pos));
                            //Log.e("Play Next ran: ",String.valueOf(mu_pos));
                        }else if (mu_pos < Global.getFiles.size()-1) mu_pos++;
                        else mu_pos=0;
                        //mediaPlayer = MediaPlayer.create(getApplicationContext(), Uri.fromFile(new File(getFiles.get(mu_pos).toString())));
                        try {
                            //Log.e("URI" , MusicPlayer.getFiles.get(mu_pos).toString());
                            Global.mediaPlayer.reset();
                            Global.mediaPlayer.setDataSource(getApplicationContext(),Uri.fromFile(new File(Global.getFiles.get(mu_pos).toString())));
                            Global.mediaPlayer.prepare();
                            Global.mediaPlayer.start();
                            //Global.mediaPlayer.seekTo((Global.mediaPlayer.getDuration()-5*1000));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }


                });
                // }

            }

        });



        btn_Stop = (Button) findViewById(R.id.btn_Stop);
        btn_Stop.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Global.mediaPlayer.stop();
            }
        });


        btn_Next = (Button) findViewById(R.id.btn_Next);
        btn_Next.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                try {
                    if (is_shuffle == 1){
                        int temp = rno.nextInt(Global.getFiles.size()) ;
                        if (temp == mu_pos  )
                            if ( temp < Global.getFiles.size()-1)
                                mu_pos = ++temp;
                            else mu_pos = 0 ;
                        else mu_pos = temp;
                        //Log.e("Play ran: ",String.valueOf(mu_pos));
                    }else if (mu_pos < Global.getFiles.size()-1) mu_pos++;
                    else mu_pos=0;

                    //Log.e("URI" , MusicPlayer.getFiles.get(mu_pos).toString());
                    Global.mediaPlayer.reset();
                    Global.mediaPlayer.setDataSource(getApplicationContext(),Uri.fromFile(new File(Global.getFiles.get(mu_pos).toString())));
                    Global.mediaPlayer.prepare();
                    Global.mediaPlayer.start();
                    //mediaPlayer.seekTo((mediaPlayer.getDuration()-5*1000));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        root = new File(Environment.getExternalStorageDirectory().getAbsolutePath());
        curFolder = root;

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if (v.getId()  == R.id.showFiles){
            AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
            menu.setHeaderTitle("Do you really want to delete?");
            menu.add(Menu.NONE,0,0,"Delete");
        }

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        int menuItemIndex = info.position;

        String menu = "Delete";

        Global.getFiles.remove(menuItemIndex);
        show_Files_adaptor.notifyDataSetChanged();

        return true;
    }



    @Override
    protected Dialog onCreateDialog(int id) {

        Dialog dialog = null;

        switch (id) {
            case CUSTOM_DIALOG_ID:
                dialog = new Dialog(JukeBox.this);
                dialog.setContentView(R.layout.activity_browse_files);
                dialog.setTitle("Custom Dialog");
                dialog.setCancelable(true);
                dialog.setCanceledOnTouchOutside(true);

                textFolder = (TextView) dialog.findViewById(R.id.folder);
                btn_Up = (Button) dialog.findViewById(R.id.btn_Up);
                btn_Up.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.e("HERE",curFolder.getParentFile().toString());
                        ListDir(curFolder.getParentFile());
                    }
                });



                dialog_ListView = (ListView) dialog.findViewById(R.id.dialoglist);
                dialog_ListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        File selected = new File(fileList.get(position));
                        if(selected.isDirectory()) {
                            ListDir(selected);
                        } else {


                            if (Global.getFiles.contains(selected.getAbsolutePath()))
                                Toast.makeText(getApplicationContext(),"Song already added ",Toast.LENGTH_LONG).show();
                            else {
                                Toast.makeText(getApplicationContext(), selected.toString() + " selected",
                                        Toast.LENGTH_LONG).show();
                                Global.getFiles.add(selected.getAbsolutePath().toString());
                            }

                            Log.e("List Size", String.valueOf(Global.getFiles.size()));

                            show_Files_adaptor.notifyDataSetChanged();

//                            showFiles.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                                @Override
//                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                                    Toast.makeText(getApplicationContext(),getFiles.get(position).toString(),Toast.LENGTH_SHORT).show();
//                                    mediaPlayer = MediaPlayer.create(getApplicationContext(), Uri.fromFile(new File(getFiles.get(position).toString())));
//                                    mediaPlayer.start();
//                                }
//                            });


                            dismissDialog(CUSTOM_DIALOG_ID);
                        }
                    }
                });

                break;
        }
        return dialog;
    }




    @Override
    protected void onPrepareDialog(int id, Dialog dialog) {
        super.onPrepareDialog(id, dialog);
        switch (id) {
            case CUSTOM_DIALOG_ID:
                //Log.e("CurPath=",String.valueOf(curFolder.listFiles().length));
                ListDir(curFolder);
                break;
        }
    }

    void ListDir(File f) {
        Log.e("Root=",root.toString());
        if(f.equals(root)) {

            btn_Up.setEnabled(false);
        } else {
            btn_Up.setEnabled(true);
        }

        curFolder = f;
        Log.e("F Path=", f.getPath().toString());
        textFolder.setText(f.getAbsolutePath());
        Log.e("Length of F=", String.valueOf(f.list()));
        //try {
        File[] files = f.listFiles();
        fileList.clear();

        for(File file : files) {
            fileList.add(file.getPath());
        }
//        }
//        catch (Exception e)
//        {
//            Log.e("TEST", "Hrere");
//        }


        ArrayAdapter<String> directoryList = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, fileList);
        dialog_ListView.setAdapter(directoryList);
    }
}
