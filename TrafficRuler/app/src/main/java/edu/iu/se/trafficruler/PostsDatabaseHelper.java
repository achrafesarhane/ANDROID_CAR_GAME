package edu.iu.se.trafficruler;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sruthi on 10/29/2015.
 */
public class PostsDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "postsDatabase";
    private static final int DATABASE_VERSION = 1;

    // Table Names
    private static final String TABLE_POSTS = "posts";


    // Post Table Columns
    private static final int KEY_POST_ID=0;
    private static final String KEY_POST_USERNAME="username";
    private static final String KEY_POST_PASSWORD="password";
    private static final int KEY_POST_VEHICLE_TYPE=0;
    private static final int KEY_POST_PLAYER_TYPE=0;
    private static final int KEY_POST_HAIR_TYPE=0;
    private static final int KEY_POST_OUTFIT_TYPE=0 ;
    private static final int KEY_POST_ACCESSORIES_TYPE=0;
    private static final int KEY_POST_TUNEUP_TYPE=0;
    private static final int KEY_POST_UPGRADE_TYPE=0;
    private static final int KEY_POST_ACCELERATION_TYPE=0;
    private static final int KEY_POST_COLOR=0;
    private static final int KEY_POST_DECALS=0;
    private static final int KEY_POST_VINYLS=0;    // Variable to

    private static final int KEY_POST_SCORES=0;
    private static final String TAG ="" ;
    //  private static final String TAG = ;

    private static PostsDatabaseHelper sInstance;

    public static synchronized PostsDatabaseHelper getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new PostsDatabaseHelper(context.getApplicationContext());
        }
        return sInstance;

    }
    private PostsDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    // Called when the database connection is being configured.
    // Configure database settings for things like foreign key support, write-ahead logging, etc.
    @Override
    public void onConfigure(SQLiteDatabase db) {
        super.onConfigure(db);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String  CREATE_POSTS_TABLE = "create table "+TABLE_POSTS+
                "( " +KEY_POST_ID+" integer primary key autoincrement,"+ KEY_POST_USERNAME+"text,"+KEY_POST_PASSWORD +"text,"+KEY_POST_SCORES+"integer"+")";


        db.execSQL(CREATE_POSTS_TABLE);

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            // Simplest implementation is to drop all old tables and recreate them
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_POSTS);
            onCreate(db);
        }
    }

    public int addPost(Post post)
    {
         SQLiteDatabase db = getWritableDatabase();
        db.beginTransaction();

        int userId =-1;

        try {
                   ContentValues values = new ContentValues();

                   values.put(String.valueOf(KEY_POST_ID),post.pid);
                    values.put(KEY_POST_USERNAME, post.username);
                    values.put(KEY_POST_PASSWORD, post.password);

                    // First try to update the user in case the user already exists in the database
                    // This assumes userNames are unique
                    int rows = db.update(TABLE_POSTS, values, KEY_POST_USERNAME + "= ?", new String[]{post.username});

                    // Check if update succeeded
                    if (rows == 1) {
                        // Get the primary key of the user we just updated
                        String usersSelectQuery = String.format("SELECT %s FROM %s WHERE %s = ?",
                                KEY_POST_ID, TABLE_POSTS, KEY_POST_USERNAME);
                        Cursor cursor = db.rawQuery(usersSelectQuery, new String[]{String.valueOf(post.username)});
                        try {
                            if (cursor.moveToFirst()) {
                                userId = cursor.getInt(0);
                                db.setTransactionSuccessful();
                            }
                        } finally {
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                        }
                    }
                } catch (Exception e) {
                    Log.d(TAG, "Error while trying to add or update user");
                } finally {
                    db.endTransaction();
                }
                return userId;
            }
    // Get all posts in the database
    public String  getUserName()
    {
        String POSTS_SELECT_QUERY =
                String.format("SELECT * FROM %s WHERE %S ",
                        TABLE_POSTS);

        return "";
    }
           public List<Post> getAllPosts()
           {
                List<Post> posts = new ArrayList<>();

                // SELECT * FROM POSTS
                // LEFT OUTER JOIN USERS
                // ON POSTS.KEY_POST_USER_ID_FK = USERS.KEY_USER_ID
                String POSTS_SELECT_QUERY =
                        String.format("SELECT * FROM %s ",
                                TABLE_POSTS);

                // "getReadableDatabase()" and "getWriteableDatabase()" return the same object (except under low
                // disk space scenarios)
                SQLiteDatabase db = getReadableDatabase();
                Cursor cursor = db.rawQuery(POSTS_SELECT_QUERY, null);
                try {
                    if (cursor.moveToFirst()) {
                        do {
                            Post newUser = new Post();
                            newUser.username = cursor.getString(cursor.getColumnIndex(KEY_POST_USERNAME));
                            newUser.pid = cursor.getString(cursor.getColumnIndex(String.valueOf(KEY_POST_ID)));


                            posts.add(newUser);
                        } while(cursor.moveToNext());
                    }
                } catch (Exception e) {
                    Log.d(TAG, "Error while trying to get posts from database");
                } finally {
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                }
                return posts;
            }

//UPDATE SCORES

    public int updateUserProfilePicture(Post user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(String.valueOf(KEY_POST_SCORES), user.SCORES);

        // Updating profile picture url for user with that userName
        return db.update(TABLE_POSTS, values, KEY_POST_USERNAME + " = ?",
                new String[] { String.valueOf(user.username) });
    }



        // Delete all posts and users in the database
        public void deleteAllPostsAndUsers() {
            SQLiteDatabase db = getWritableDatabase();
            db.beginTransaction();
            try {
                // Order of deletions is important when foreign key relationships exist.
                db.delete(TABLE_POSTS, null, null);

                db.setTransactionSuccessful();
            } catch (Exception e) {
                Log.d(TAG, "Error while trying to delete all posts and users");
            } finally {
                db.endTransaction();
            }
        }





}
