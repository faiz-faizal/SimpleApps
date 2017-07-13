package com.example.faiz_faizal.simpleapps.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.media.MediaCodecInfo;

import com.example.faiz_faizal.simpleapps.model.User;

/**
 * Created by faiz-faizal on 7/11/2017.
 */

public class Database extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "UserManger.db";
    public static final String TABLE_USER = "user";
    public static final String COLUMN_USER_ID = "user_id";
    public static final String COLUMN_USER_NAME= "user_name";
    public static final String COLUMN_USER_USERNAME = "user_username" ;
    public static final String COLUMN_USER_PHONE= "user_phone";
    public static final String COLUMN_USER_PASSWORD = "user_password" ;

    private String CREATE_USER_TABLE = "CREATE TABLE" + TABLE_USER + "(" + COLUMN_USER_ID + "INTEGER NUMBER KEY AUTOINCREMENT," + COLUMN_USER_USERNAME + "TEXT," +
            COLUMN_USER_NAME +"TEXT," + COLUMN_USER_PASSWORD + "TEXT," + ")";

     private String DROP_USER_TABLE = "DROP TABLE IF EXISTS" + TABLE_USER;

    public Database( Context context){
        super( context, DATABASE_NAME ,null ,DATABASE_VERSION);
    }

    //overide
    public void onCreate(SQLiteDatabase db){
        db.execSQL(CREATE_USER_TABLE);
    }
    //overide
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL(DROP_USER_TABLE);
        onCreate(db);
    }

    public void addUser( User user){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_NAME,user.getUsername());
        values.put(COLUMN_USER_USERNAME, user.getUsername());
        values.put(COLUMN_USER_PASSWORD, user.getPassword());

            db.insert(TABLE_USER, null, values);
            db.close();




    }

    public boolean checkUser(String username){
        String[] column = { COLUMN_USER_USERNAME
        };

        SQLiteDatabase db = this.getWritableDatabase();
        String selection = COLUMN_USER_USERNAME + "= ?";
        String[] selectionArgs = {username};

        Cursor cursor = db.query(TABLE_USER,
                column,
                selection,
                selectionArgs,
                null,
                null,
                null);
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();

        if(cursorCount > 0){
            return true;

        }
        return false;
    }

    public boolean checkUser(String username, String password){
        String[] column = { COLUMN_USER_USERNAME
        };

        SQLiteDatabase db = this.getWritableDatabase();
        String selection = COLUMN_USER_USERNAME + "= ?" + "AND" + COLUMN_USER_PASSWORD + "=?";
        String[] selectionArgs = {username,password};

        Cursor cursor = db.query(TABLE_USER,
                column,
                selection,
                selectionArgs,
                null,
                null,
                null);
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();

        if(cursorCount > 0){
            return true;

        }
        return false;
    }


}
