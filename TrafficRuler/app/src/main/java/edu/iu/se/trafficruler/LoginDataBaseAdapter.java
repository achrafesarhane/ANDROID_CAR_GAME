package edu.iu.se.trafficruler;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.ListView;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**accessories_type;
 int tuneup_type;
 int upgrade_type;
 int acceleration_type;
 int color;
 int decals;
 int vinyls;
 * Created by Sruthi on 10/28/2015.
 */
public class LoginDataBaseAdapter {
    static final String DATABASE_NAME = "TrafficRule.db";
    static final int DATABASE_VERSION = 1;
    public static final int NAME_COLUMN = 1;
    // TODO: Create public field for each column in your table.
    // SQL Statement to create a new database.
    static final String DATABASE_CREATE = "create table "+"LOGIN"+
            "( " +"ID"+" integer primary key autoincrement,"+ "USERNAME  text,PASSWORD text,VEHICLE_TYPE integer,PLAYER_TYPE integer,HAIR_TYPE integer," +
            "OUTFIT_TYPE integer,ACCESSORIES_TYPE integer,TUNEUP_TYPE integer,UPGRADE_TYPE integer,ACCELERATION_TYPE integer,COLOR integer,DECALS integer,VINYLS integer); ";
    static final String Table_HighScores = "create table SCORES( ID integer primary key autoincrement,USERNAME  text,SCORE integer); ";
    // Variable to hold the database instance
    public SQLiteDatabase db;
    // Context of the application using the database.
    private final Context context;
    // Database open/upgrade helper
    private DataBaseHelper dbHelper;

    public  LoginDataBaseAdapter(Context _context)
    {
        context = _context;
        dbHelper = new DataBaseHelper(context, DATABASE_NAME, null, DATABASE_VERSION);

    }
    public  LoginDataBaseAdapter open() throws SQLException
    {
        db = dbHelper.getWritableDatabase();
        return this;
    }
    public void close()
    {
        db.close();
    }

    public  SQLiteDatabase getDatabaseInstance()
    {
        return db;
    }

    public void insertEntry(String userName,String password)
    {
        ContentValues newValues = new ContentValues();
        // Assign values for each row.
        newValues.put("USERNAME", userName);
        newValues.put("PASSWORD", password);

        // Insert the row into your table
        db.insert("LOGIN", null, newValues);
        ///Toast.makeText(context, "Reminder Is Successfully Saved", Toast.LENGTH_LONG).show();
    }

    public void insertScore(String userName,int score)
    {
        ContentValues newValues = new ContentValues();
        // Assign values for each row.
        newValues.put("USERNAME", userName);
        newValues.put("SCORE", score);

        // Insert the row into your table
        db.insert("SCORES", null, newValues);
        ///Toast.makeText(context, "Reminder Is Successfully Saved", Toast.LENGTH_LONG).show();
    }



    public int deleteEntry(String UserName)
    {
        //String id=String.valueOf(ID);
        String where="USERNAME=?";
        int numberOFEntriesDeleted= db.delete("LOGIN", where, new String[]{UserName}) ;
        // Toast.makeText(context, "Number fo Entry Deleted Successfully : "+numberOFEntriesDeleted, Toast.LENGTH_LONG).show();
        return numberOFEntriesDeleted;
    }

    public void getScores()
    {
        Cursor  cursor = db.rawQuery("select * from SCORES", null);
        Cursor getval = db.rawQuery("SELECT COUNT(SCORE) FROM SCORES",null);
        int total = getval.getCount();
//        String username[] = new String[total];
//        String score[] = new String[total];
//        int count=0;
        if (cursor .moveToFirst()) {

            while (cursor.isAfterLast() == false) {
                Log.e("USERNAME : ", cursor.getString(cursor.getColumnIndex("USERNAME")));
                Log.e("SCORE :", cursor.getString(cursor.getColumnIndex("SCORE")));
                cursor.moveToNext();
//                count++;
            }
        }

        cursor.close();

    }

    public String getSinlgeEntry(String userName)
    {
        Cursor cursor=db.query("LOGIN", null, " USERNAME=?", new String[]{userName}, null, null, null);
        if(cursor.getCount()<1) // UserName Not Exist
        {
            cursor.close();
            return "NOT EXIST";
        }
        cursor.moveToFirst();
        String password= cursor.getString(cursor.getColumnIndex("PASSWORD"));
        cursor.close();
        return password;
    }
    public void  updateEntry(String userName,String password)
    {
        // Define the updated row content.
        ContentValues updatedValues = new ContentValues();
        // Assign values for each row.
        updatedValues.put("USERNAME", userName);
        updatedValues.put("PASSWORD", password);

        String where="USERNAME = ?";
        db.update("LOGIN", updatedValues, where, new String[]{userName});
    }
    public int getvehicletype(String userName){
        Cursor cursor=db.query("LOGIN", null, " USERNAME=?", new String[]{userName}, null, null, null);
        if(cursor.getCount()<1) // UserName Not Exist
        {
            cursor.close();
            return 0;
        }
        cursor.moveToFirst();
        int  vehicle_type= cursor.getInt(cursor.getColumnIndex("VEHICLE_TYPE"));
        cursor.close();
        return vehicle_type;

    }
    public void setvehicletype(String userName,int  vtype)
    {
        ContentValues updatedValues = new ContentValues();
        // Assign values for each row.
        updatedValues.put("VEHICLE_TYPE", vtype);


        String where="USERNAME = ?";
        db.update("LOGIN", updatedValues, where, new String[]{userName});

    }

    /*PLAYER TYPE*/

    public int getPlayertype(String userName){
        Cursor cursor=db.query("LOGIN", null, " USERNAME=?", new String[]{userName}, null, null, null);
        if(cursor.getCount()<1) // UserName Not Exist
        {
            cursor.close();
            return 0;
        }
        cursor.moveToFirst();
        int  vehicle_type= cursor.getInt(cursor.getColumnIndex("PLAYER_TYPE"));
        cursor.close();
        return vehicle_type;

    }
    public void setPlayertype(String userName,int  vtype)
    {
        ContentValues updatedValues = new ContentValues();
        // Assign values for each row.
        updatedValues.put("PLAYER_TYPE", vtype);


        String where="USERNAME = ?";
        db.update("LOGIN", updatedValues, where, new String[]{userName});


    }



    public int gethairtype(String userName){
        Cursor cursor=db.query("LOGIN", null, " USERNAME=?", new String[]{userName}, null, null, null);
        if(cursor.getCount()<1) // UserName Not Exist
        {
            cursor.close();
            return 0;
        }
        cursor.moveToFirst();
        int  vehicle_type= cursor.getInt(cursor.getColumnIndex("HAIR_TYPE"));
        cursor.close();
        return vehicle_type;

    }
    public void sethairtype(String userName,int  vtype)
    {
        ContentValues updatedValues = new ContentValues();
        // Assign values for each row.
        updatedValues.put("HAIR_TYPE", vtype);


        String where="USERNAME = ?";
        db.update("LOGIN", updatedValues, where, new String[]{userName});


    }




    public int getoutfittype(String userName){
        Cursor cursor=db.query("LOGIN", null, " USERNAME=?", new String[]{userName}, null, null, null);
        if(cursor.getCount()<1) // UserName Not Exist
        {
            cursor.close();
            return 0;
        }
        cursor.moveToFirst();
        int  vehicle_type= cursor.getInt(cursor.getColumnIndex("OUTFIT_TYPE"));
        cursor.close();
        return vehicle_type;

    }
    public void setoutfittype(String userName,int  vtype)
    {
        ContentValues updatedValues = new ContentValues();
        // Assign values for each row.
        updatedValues.put("OUTFIT_TYPE", vtype);


        String where="USERNAME = ?";
        db.update("LOGIN", updatedValues, where, new String[]{userName});


    }




    public int getaccessoriesttype(String userName){
        Cursor cursor=db.query("LOGIN", null, " USERNAME=?", new String[]{userName}, null, null, null);
        if(cursor.getCount()<1) // UserName Not Exist
        {
            cursor.close();
            return 0;
        }
        cursor.moveToFirst();
        int  vehicle_type= cursor.getInt(cursor.getColumnIndex("ACCESSORIES_TYPE"));
        cursor.close();
        return vehicle_type;

    }
    public void setaccessoriesttype(String userName,int  vtype)
    {
        ContentValues updatedValues = new ContentValues();
        // Assign values for each row.
        updatedValues.put("ACCESSORIES_TYPE", vtype);


        String where="USERNAME = ?";
        db.update("LOGIN", updatedValues, where, new String[]{userName});


    }




    public int gettuneuptype(String userName){
        Cursor cursor=db.query("LOGIN", null, " USERNAME=?", new String[]{userName}, null, null, null);
        if(cursor.getCount()<1) // UserName Not Exist
        {
            cursor.close();
            return 0;
        }
        cursor.moveToFirst();
        int  vehicle_type= cursor.getInt(cursor.getColumnIndex("TUNEUP_TYPE"));
        cursor.close();
        return vehicle_type;

    }
    public void settuneuptype(String userName,int  vtype)
    {
        ContentValues updatedValues = new ContentValues();
        // Assign values for each row.
        updatedValues.put("TUNEUP_TYPE", vtype);


        String where="USERNAME = ?";
        db.update("LOGIN", updatedValues, where, new String[]{userName});


    }


    public int getupgradetype(String userName){
        Cursor cursor=db.query("LOGIN", null, " USERNAME=?", new String[]{userName}, null, null, null);
        if(cursor.getCount()<1) // UserName Not Exist
        {
            cursor.close();
            return 0;
        }
        cursor.moveToFirst();
        int  vehicle_type= cursor.getInt(cursor.getColumnIndex("UPGRADE_TYPE"));
        cursor.close();
        return vehicle_type;

    }
    public void setupgradetype(String userName,int  vtype)
    {
        ContentValues updatedValues = new ContentValues();
        // Assign values for each row.
        updatedValues.put("UPGRADE_TYPE", vtype);


        String where="USERNAME = ?";
        db.update("LOGIN", updatedValues, where, new String[]{userName});


    }





    public int getaccelerationtype(String userName){
        Cursor cursor=db.query("LOGIN", null, " USERNAME=?", new String[]{userName}, null, null, null);
        if(cursor.getCount()<1) // UserName Not Exist
        {
            cursor.close();
            return 0;
        }
        cursor.moveToFirst();
        int  vehicle_type= cursor.getInt(cursor.getColumnIndex("ACCELERATION_TYPE"));
        cursor.close();
        return vehicle_type;

    }
    public void setaccelerationtype(String userName,int  vtype)
    {
        ContentValues updatedValues = new ContentValues();
        // Assign values for each row.
        updatedValues.put("ACCELERATION_TYPE", vtype);


        String where="USERNAME = ?";
        db.update("LOGIN", updatedValues, where, new String[]{userName});


    }

    public int getcolor(String userName){
        Cursor cursor=db.query("LOGIN", null, " USERNAME=?", new String[]{userName}, null, null, null);
        if(cursor.getCount()<1) // UserName Not Exist
        {
            cursor.close();
            return 0;
        }
        cursor.moveToFirst();
        int  vehicle_type= cursor.getInt(cursor.getColumnIndex("COLOR"));
        cursor.close();
        return vehicle_type;

    }
    public void setcolor(String userName,int  vtype)
    {
        ContentValues updatedValues = new ContentValues();
        // Assign values for each row.
        updatedValues.put("COLOR", vtype);


        String where="USERNAME = ?";
        db.update("LOGIN", updatedValues, where, new String[]{userName});


    }



    public int getdecals(String userName){
        Cursor cursor=db.query("LOGIN", null, " USERNAME=?", new String[]{userName}, null, null, null);
        if(cursor.getCount()<1) // UserName Not Exist
        {
            cursor.close();
            return 0;
        }
        cursor.moveToFirst();
        int  vehicle_type= cursor.getInt(cursor.getColumnIndex("DECALS"));
        cursor.close();
        return vehicle_type;

    }
    public void setdecals(String userName,int  vtype)
    {
        ContentValues updatedValues = new ContentValues();
        // Assign values for each row.
        updatedValues.put("DECALS", vtype);


        String where="USERNAME = ?";
        db.update("LOGIN", updatedValues, where, new String[]{userName});


    }

    public int getvinyls(String userName){
        Cursor cursor=db.query("LOGIN", null, " USERNAME=?", new String[]{userName}, null, null, null);
        if(cursor.getCount()<1) // UserName Not Exist
        {
            cursor.close();
            return 0;
        }
        cursor.moveToFirst();
        int  vehicle_type= cursor.getInt(cursor.getColumnIndex("VINYLS"));
        cursor.close();
        return vehicle_type;

    }
    public void setvinyls(String userName,int  vtype)
    {
        ContentValues updatedValues = new ContentValues();
        // Assign values for each row.
        updatedValues.put("VINYLS", vtype);


        String where="USERNAME = ?";
        db.update("LOGIN", updatedValues, where, new String[]{userName});


   }

    public List<Leaderboard> getAllScore()
    {
        List<Leaderboard> leaderboard = new ArrayList<Leaderboard>();
        // Select All Query
        //
        // String selectQuery = "SELECT SCORE FROM LOGIN";
//        Cursor cursor=db.query("LOGIN", new String[]{"SCORE"}, null, null, null, null, null);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from SCORES order by score desc LIMIT 10",null);


        // Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list

        if (cursor.moveToFirst()) {
            do {
                String username = cursor.getString(cursor.getColumnIndex("USERNAME"));
                int score = cursor.getInt(cursor.getColumnIndex("SCORE"));

                leaderboard.add(new Leaderboard(username,score));


            } while (cursor.moveToNext());

        }

        // close inserting data from database
        db.close();
        // return contact list
        return leaderboard;


    }

/*
    public void setvehicletype() {
        ContentValues updatedValues = new ContentValues();
        // Assign values for each row.
        updatedValues.put("VEHICLE_TYPE", vtype);


        String where="USERNAME = ?";
        db.update("LOGIN", updatedValues, where, new String[]{userName});

    }*/
}

class Leaderboard {
    private String username;
    private int score;

    public Leaderboard(String username, int score) {
        this.username = username;
        this.score = score;
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}

