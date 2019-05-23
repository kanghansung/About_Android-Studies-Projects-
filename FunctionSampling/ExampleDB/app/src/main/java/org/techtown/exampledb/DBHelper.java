package org.techtown.exampledb;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE BRIGHTENTRY ( _id INTEGER PRIMARY KEY AUTOINCREMENT, level TEXT, name TEXT, phone TEXT, alpa TEXT);");
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public  void insert(String level, String name, String phone, String alpa){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("INSERT INTO BRIGHTENTRY VALUES(null, '"+ level+"',"+name+"',"+phone+"',"+alpa+"');");
        db.close();
    }
//     ,"+create_at+"'
    public void update(String name, String level, String alpa){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("UPDATE BRIGHTENTRY SET alpa ="+alpa +"level ="+level + "WHERE name="+name+";");
        db.close();
    }
    public void delete(String name){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM BRIGHTENTRY WHERE name ='"+name+"';");
        db.close();
    }
    public String getResult() {
        SQLiteDatabase db = getReadableDatabase();
        String result = "";

        Cursor cursor = db.rawQuery("SELECT * FROM BRIGHTENTRY", null);
        while(cursor.moveToNext()){
            result += cursor.getString(0)
                    + " | 임원여부:"
                    + cursor.getString(1)
                    + " |  이름:"
                    + cursor.getString(2)
                    + " | 핸드폰:"
                    + cursor.getString(3)
                    + " | 세부업무:"
                    + cursor.getString(4)
                    + " \n";
        }
        return result;
    }
}
