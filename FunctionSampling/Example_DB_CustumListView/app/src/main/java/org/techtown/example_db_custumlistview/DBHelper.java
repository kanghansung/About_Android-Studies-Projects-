package org.techtown.example_db_custumlistview;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context,String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, name, factory, version);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE SHOP( _id INTEGER PRIMARY KEY AUTOINCREMENT, nameShop TEXT, place1 TEXT, kindOfShop TEXT, place2 TEXT);");
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public void insert(String nameShop, String place1, String kindOfShop, String place2){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("INSERT INTO SHOP VALUES(null, '"+nameShop+"', '"+place1+"', '"+kindOfShop+"', '"+place2+"');");
        db.close();
    }

    //삭제를 이름이 겹칠 수도 있어서 인자값 하나 더받으려햇는데 필요하면 말좀.
    public void delete(String nameShop){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM SHOP WHERE nameShop='"+nameShop+"';");
        db.close();
    }

    public void update(String nameShop, String place1, String kindOfShop, String place2) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("UPDATE SHOP SET place1 = '" + place1 + "' WHERE nameShop = '" + nameShop + "';");
        db.execSQL("UPDATE SHOP SET place2 = '" + place2 + "' WHERE nameShop = '" + nameShop + "';");
        db.execSQL("UPDATE SHOP SET kindOfShop = '" + kindOfShop + "' WHERE nameShop = '" + nameShop + "';");
        db.close();
    }

    public ArrayList<String> getNameShop(){
        SQLiteDatabase db = getReadableDatabase();
        ArrayList<String> name = new ArrayList<String>(50);
        int order=0;

        Cursor cursor = db.rawQuery("SELECT * FROM SHOP", null);
        while(cursor.moveToNext())
        {
            String abc = cursor.getString(1);
            name.add(abc);
        }

        return name;
    }

    public ArrayList<String> getPlace1(){
        SQLiteDatabase db = getReadableDatabase();
        ArrayList<String> place1 = new ArrayList<String>(50);
        int order = 0;

        Cursor cursor = db.rawQuery("SELECT * FROM SHOP", null);
        while(cursor.moveToNext())
        {
            String abc = cursor.getString(2);
            place1.add(abc);
        }
        return place1;
    }

    public ArrayList<String> getKindOfShop(){
        SQLiteDatabase db = getReadableDatabase();
        ArrayList<String> kindOfShop = new ArrayList<String>(50);
        int order = 0;

        Cursor cursor = db.rawQuery("SELECT * FROM SHOP", null);
        while (cursor.moveToNext())
        {
            String abc = cursor.getString(3);
            kindOfShop.add(abc);
        }
        return kindOfShop;
    }

    public ArrayList<String> getPlace2(){
        SQLiteDatabase db = getReadableDatabase();
        ArrayList<String> place2 = new ArrayList<>(50);
        int order = 0;

        Cursor cursor = db.rawQuery("SELECT * FROM SHOP", null);
        while (cursor.moveToNext())
        {
            String abc = cursor.getString(4);
            place2.add(abc);
        }
        return place2;
    }

    public int getSize(){
        SQLiteDatabase db = getReadableDatabase();
        int size=0;

        Cursor cursor = db.rawQuery("SELECT * FROM SHOP", null);
        while(cursor.moveToNext())
        {
            size +=1;
        }

        return size;
    }

    //혹여나 통으로 쓰는 데이터가 필요할 수 있으니.
    public String showAllData(){
        SQLiteDatabase db = getReadableDatabase();
        String result= "";

        Cursor cursor = db.rawQuery("SELECT * FROM SHOP", null);
        while(cursor.moveToNext())
        {
            result += "가게이름:" + cursor.getString(1)
                    + " " + "주소1:" + cursor.getString(2)
                    + " " + "종류:" + cursor.getString(3)
                    + " " + "주소2:" + cursor.getString(4)
                    + "\n";
        }
        return result;
    }
}
