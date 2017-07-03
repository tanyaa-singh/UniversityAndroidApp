package com.example.lenovo.dtu;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Lenovo on 26-07-2016.
 */
public class DBHandler extends SQLiteOpenHelper {

    private static final int TABLE_VERSION=1;
    private static final String DATABASE_NAME="students.db";
    private static final String TABLE_NAME="login";
    private static final String COL_1="_id";
    private static final String COL_2="name";
    private static final String COL_3="course";
    private static final String COL_4="phone";
    private static final String COL_5="email";
    private static final String COL_6="password";

    public DBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context,DATABASE_NAME, factory,TABLE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        String query=" CREATE TABLE "+ TABLE_NAME + "(" +
                COL_1 + " INTEGER PRIMARY KEY AUTOINCREMENT " +
                COL_2 + " TEXT " +
                COL_3 + " TEXT " +
                COL_4 + " TEXT " +
                COL_5 + " TEXT " +
                COL_6 + " TEXT " +
                ");";

        db.execSQL(query);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABL IF EXIST " + TABLE_NAME);
        onCreate(db);

    }

    public void add(Data name,Data course,Data phone, Data email,Data password){
        ContentValues values=new ContentValues();
        SQLiteDatabase db=getWritableDatabase();
        values.put(COL_2,name.getName());
        values.put(COL_3,course.getCourse());
        values.put(COL_4,phone.getPhone());
        values.put(COL_5,email.getEmail());
        values.put(COL_6,password.getPassword());
        db.insert(TABLE_NAME,null,values);
        db.close();
    }

    public String getName(String email){
        String name="";
        SQLiteDatabase db=getWritableDatabase();
        String query="SELECT * FROM "+ TABLE_NAME + " WHERE " +COL_5 + "=\"" + email + "\";";
        Cursor c=db.rawQuery(query,null);

        name=c.getString(c.getColumnIndex(COL_2));
        db.close();
        return name;

    }
}
