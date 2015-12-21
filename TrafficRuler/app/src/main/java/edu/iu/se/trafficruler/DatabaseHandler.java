/*package edu.iu.se.trafficruler;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sruthi on 10/27/2015.
 */
/*
public class DatabaseHandler extends SQLiteOpenHelper
{

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "PlayerDet";

    // Contacts table name
    private static final String TABLE_PLAYER = "Player1";

    // Contacts Table Columns names
    private static final String KEY_ID = "pid";
    private static final String KEY_NAME = "pname";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }





    public DatabaseHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public DatabaseHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_PLAYER + "("+ KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PLAYER);

        // Create tables again
        onCreate(db);
    }
    // Adding new contact
    public void addContact(PlayerDetails pdetails) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, pdetails.getName()); // Contact Name


        // Inserting Row
        db.insert(TABLE_PLAYER, null, values);
        db.close(); // Closing database connection
    }

    // Getting single contact
    public PlayerDetails getContact(int id) {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_PLAYER, new String[] { KEY_ID,
                        KEY_NAME }, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        PlayerDetails contact = new PlayerDetails(Integer.parseInt(cursor.getString(0)),cursor.getString(1));
        // return contact
        return contact;
    }

    // Getting All Contacts
    public List<PlayerDetails> getAllContacts() {
        List<PlayerDetails> contactList = new ArrayList<PlayerDetails>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_PLAYER;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                PlayerDetails contact = new PlayerDetails();
                contact.setID(Integer.parseInt(cursor.getString(0)));
                contact.setName(cursor.getString(1));

                // Adding contact to list
                contactList.add(contact);
            } while (cursor.moveToNext());
        }

        // return contact list
        return contactList;
    }

    // Getting contacts Count
    public int getContactsCount() {
        String countQuery = "SELECT  * FROM " + TABLE_PLAYER;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }
    // Updating single contact
    public int updateContact(PlayerDetails contact) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, contact.getName());


        // updating row
        return db.update(TABLE_PLAYER, values, KEY_ID + " = ?",
                new String[] { String.valueOf(contact.getID()) });
    }

    // Deleting single contact
    public void deleteContact(PlayerDetails contact) {SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_PLAYER, KEY_ID + " = ?",
                new String[] { String.valueOf(contact.getID()) });
        db.close();}
}
*/