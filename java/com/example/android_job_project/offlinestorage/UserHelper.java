package com.example.android_job_project.offlinestorage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Dell on 30-04-2018.
 */

public class UserHelper extends SQLiteOpenHelper {
    public static final String DBNAME = "mydb";
    public static final String TABLENAME = "user";
    public static final int VERSION = 1;
    public static final String ID = "id";
    public static final String USERNAME = "Username";
    public static final String PASSWORD = "Password";


    public UserHelper(Context context) {
        super(context, DBNAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String Create = "CREATE TABLE " + TABLENAME + "("
                + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + USERNAME + " TEXT, "
                + PASSWORD + " TEXT)";

        Log.i("query============>>",Create);
        db.execSQL(Create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLENAME);
        onCreate(db);
    }
}
