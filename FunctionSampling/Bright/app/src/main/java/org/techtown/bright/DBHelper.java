package org.techtown.bright;

import android.app.PendingIntent;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.Random;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE BRIGHTENTRY (level TEXT, name TEXT, phone TEXT PRIMARY KEY, alpa TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public  void insert(String level, String name, String phone, String alpa){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("INSERT INTO BRIGHTENTRY VALUES('"+ level+"', '"+name+ "','"+phone+"','"+alpa+"');");
        db.close();
    }
    public void delete(String name){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM BRIGHTENTRY WHERE name='"+name+"';");
        db.close();
    }
    public void update(String name, String level, String phone, String alpa){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("UPDATE BRIGHTENTRY SET level ='"+level+"' WHERE name='"+name+"';");
        db.execSQL("UPDATE BRIGHTENTRY SET phone ='"+phone+"' WHERE name='"+name+"';");
        db.execSQL("UPDATE BRIGHTENTRY SET alpa ='"+alpa+"' WHERE name='"+name+"';");
        db.close();
    }
    public String showData(){
        SQLiteDatabase db = getReadableDatabase();
        String data = "";

        Cursor cursor = db.rawQuery("SELECT * FROM BRIGHTENTRY", null);
        while(cursor.moveToNext()){
            data += "임원:"
                    + cursor.getString(0)
                    + " | 이름:"
                    + cursor.getString(1)
                    + " | 핸드폰:"
                    + cursor.getString(2)
                    + " | 상세업무:"
                    + cursor.getString(3)
                    + "\n";
        }
        return  data;
    }
    public String showManagersName(String Level, String level){
        SQLiteDatabase db = getReadableDatabase();
        String names = "";

        Cursor cursor1 = db.rawQuery("SELECT * FROM BRIGHTENTRY WHERE level='"+level+"';", null);
        while(cursor1.moveToNext())
        {
            names += "이름: "
                    + cursor1.getString(1)
                    + "\n";
        }
        Cursor cursor2 = db.rawQuery("SELECT * FROM BRIGHTENTRY WHERE level='"+Level+"';",null);
        while(cursor2.moveToNext())
        {
            names += "이름: "
                    + cursor2.getString(1)
                    +"\n";
        }
        return names;
    }
    public String showMembersName(String Level, String level){
        SQLiteDatabase db = getReadableDatabase();
        String names= "";

        Cursor cursor1 = db.rawQuery("SELECT * FROM BRIGHTENTRY WHERE level='"+level+"';",null);
        while(cursor1.moveToNext())
        {
            names += "이름:"
                    + cursor1.getString(1)
                    + "\n";
        }
        Cursor cursor2 = db.rawQuery("SELECT * FROM BRIGHTENTRY WHERE level='"+Level+"';",null);
        while(cursor2.moveToNext())
        {
            names += "이름:"
                    + cursor2.getString(1)
                    +"\n";
        }
        return  names;
    }
    public String[] mixPersons(){
        int i=0;
        String[] persons = new String[50];
        SQLiteDatabase db = getReadableDatabase();
        Random random = new Random();
        Cursor cursor = db.rawQuery("SELECT * FROM BRIGHTENTRY", null);
        //배열초기화
        for(int k=0; k<persons.length;k++)
        {
            persons[k]="";
        }
        while(cursor.moveToNext())
        {
            persons[i] = cursor.getString(1);
            i++;
        }
        for (int j=0; j<50;j++)
        {
            String temp;
            int num=0;
            num = random.nextInt(50);
            if(persons[num]!="")
            {
                temp = persons[j];
                persons[j] = persons[num];
                persons[num] = temp;
            }
        }
        return persons;
    }
}