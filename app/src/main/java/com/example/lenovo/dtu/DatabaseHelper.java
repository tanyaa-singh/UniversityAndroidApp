package com.example.lenovo.dtu;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper{
    public static final String Database_Name="univ.db";
    public static final String Table_Name="Login";
    public static final String Col_1 = "_id";
    public static final String Col_2 ="name";
    public static final String Col_3 ="course";
    public static final String Col_4 ="phone";
    public static final String Col_5="email";
    public static final String Col_6="password";


    final String createTable=
        " create table " + Table_Name +
        "( _id integer primary key autoincrement ,   " +
        "name text,course text,phone text,email text,password text)";



static SQLiteDatabase db;


public DatabaseHelper(Context context){
        super(context,Database_Name,null,1);

        }

@Override
public void onCreate(SQLiteDatabase db)
        {
        db.execSQL(createTable);
        }

@Override
public void onUpgrade
        (SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST" + Table_Name);
        onCreate(db);
        }
public boolean insertData(String name,String course,String phone,String email,String password)
        {
        db= this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Col_2,name);
        contentValues.put(Col_3,course);
        contentValues.put(Col_4,phone);
        contentValues.put(Col_5,email);
        contentValues.put(Col_6,password);
        long result = db.insert(Table_Name,null,
        contentValues);
        if (result == -1 )
        return false;
        else
        return true;
        }
public Cursor getAllData(){
        db= this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " +
        Table_Name , null);
        return res;
        }
    public boolean updateData(String id,String name,
        String email, String password ){
        db= this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Col_1,id);
        contentValues.put(Col_2,name);
        contentValues.put(Col_3,email);
        contentValues.put(Col_4, password);
        db.update(Table_Name, contentValues,
        "_ID = ?", new String[]{id});
        db.close();
        return true;
        }
    public String check(String userName)
        {
            Cursor cursor=db.query(Table_Name, null, " email=?", new String[]{userName}, null, null, null);
            if(cursor.getCount()<1) // UserName Not Exist
            {
                cursor.close();
                return "NOT EXIST";
            }
            cursor.moveToFirst();
            String password= cursor.getString(cursor.getColumnIndex("password"));
            cursor.close();
            return password;
        }

    public String getName(String email){
        String name="";
        SQLiteDatabase db=getWritableDatabase();
        String query="SELECT * FROM "+ Table_Name + " WHERE " +Col_5 + "=\"" + email + "\";";
        Cursor c=db.rawQuery(query,null);

        name=c.getString(c.getColumnIndex(Col_2));
        db.close();
        return name;

    }

        }
