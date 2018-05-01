package com.example.android_job_project.offlinestorage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dell on 30-04-2018.
 */

public class UserDao {

    private UserHelper userHelper;
    Context context;
    private SQLiteDatabase sqLiteDatabase;

    public UserDao(Context context) {
        this.context = context;
        userHelper = new UserHelper(context);
    }

    public long insertData(User user) {

        sqLiteDatabase = userHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(UserHelper.USERNAME, user.getUsername());
        values.put(UserHelper.PASSWORD, user.getPassword());
        long result = sqLiteDatabase.insert(UserHelper.TABLENAME, null, values);
        return result;
    }

    public List<User> selectData() {
        List<User> users = new ArrayList<User>();
        sqLiteDatabase = userHelper.getWritableDatabase();
        String s = "SELECT * FROM " + UserHelper.TABLENAME + "";

        Cursor cursor = sqLiteDatabase.rawQuery(s, null);
        if (cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                do {
                    User user = new User();
                    user.setId(cursor.getInt(0));
                    user.setUsername(cursor.getString(1));
                    user.setPassword(cursor.getString(2));
                    users.add(user);

                } while (cursor.moveToNext());

                cursor.close();
            } else {
                cursor.close();
                return new ArrayList<User>();
            }
        }

        return users;
    }




     public User findUser(User user){
        UserHelper userHelper=new UserHelper(context);
        SQLiteDatabase sqLiteDatabase=userHelper.getWritableDatabase();

         String sql = "SELECT * FROM " + UserHelper.TABLENAME + " WHERE "
                 +UserHelper.USERNAME+ "='"+user.getUsername()+"' and "
                 +UserHelper.PASSWORD+ "='"+user.getPassword()+"'";


         Cursor cursor=sqLiteDatabase.rawQuery(sql,null);
         User user1=new User();
         if(cursor!=null){
             if(cursor.moveToFirst()){

                 user1.setUsername(cursor.getString(1));
                 user1.setPassword(cursor.getString(2));
                 cursor.close();
             }
             else{
                 user1=null;
             }
             sqLiteDatabase.close();

         }
         return user1;
     }


/*
    public String searchPass(String name){
        UserHelper userHelper=new UserHelper(context);
        SQLiteDatabase db = userHelper.getReadableDatabase();
        String query = "select * from " + UserHelper.TABLENAME;
        Cursor cursor = db.rawQuery(query, null);
        String a, b;
        b = "not found";
        if (cursor.moveToFirst()) {
            do {
                a = cursor.getString(0);
                if(a.equals(UserHelper.USERNAME)){
                    b=cursor.getString(1);
                    break;
                }
            }
            while (cursor.moveToNext());
        }
        return b;
    }*/
}
