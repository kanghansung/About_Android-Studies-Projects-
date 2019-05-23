package com.example.checkmate;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;

public class DBHepler extends SQLiteOpenHelper {

    ArrayList<FolderItem> folderItemArrayList = new ArrayList<>();
    ArrayList<TodoItem> todoItemArrayList = new ArrayList<>();
    ArrayList<MemoItem> memoItemArrayList = new ArrayList<>();

    public DBHepler(Context context, String name, SQLiteDatabase.CursorFactory factory , int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //폴더를 담을 데이블
        String sql = "create table folderTable (_id integer, folderName text primary key not null, date text)";
        //폴더 안의 할 일을 적는 테이블
        String sql2 = "create table todoTable (folderName text, todoName text, date text primary key not null)";
        String sql3 = "create table memoTable (_id integer primary key autoincrement, todoTable text, listName text, date text)";
        db.execSQL(sql);
        db.execSQL(sql2);
        db.execSQL(sql3);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String sql="drop table if exists folderTable";
        String sql2="drop table if exists todoTable";
        String sql3="drop table if exists memoTable";
        db.execSQL(sql);
        db.execSQL(sql2);
        db.execSQL(sql3);
        onCreate(db);

    }

    public void insertMemoList(String todoName, String memoName, String date){
        SQLiteDatabase db = getWritableDatabase();
        String sql = "INSERT INTO memoTable VALUES('"+todoName+"', '"+memoName+"', '"+date+"');";
        db.execSQL(sql);
        db.close();
    }
    public void deleteMemoList(String memoName)
    {
        SQLiteDatabase db = getWritableDatabase();
        String sql = "DELETE FROM memoTable WHERE memoName='"+memoName+"';";
        db.execSQL(sql);
        db.close();
    }
    public ArrayList<MemoItem> getMemoItemArrayList(String todoName){
        SQLiteDatabase db = getReadableDatabase();
        memoItemArrayList.clear();

        Cursor cursor = db.rawQuery("SELECT * FROM memoTable WHERE todoTable='"+todoName+"'", null);
        while(cursor.moveToNext())
        {
            memoItemArrayList.add(new MemoItem(cursor.getString(0), cursor.getString(1)));
        }


        return memoItemArrayList;
    }


    public void insertFolder(String folderName){
        SQLiteDatabase db = getWritableDatabase();
        String sql = "INSERT INTO folderTable VALUES(null, '"+folderName+ "', null);";
        db.execSQL(sql);
        db.close();
    }
    public void insertFolder(String folderName, Date date){
        SQLiteDatabase db = getWritableDatabase();
        String sql = "INSERT INTO folderTable VALUES(null, '"+folderName+"', '"+date+"');";
        db.execSQL(sql);
        db.close();
    }
    public void insertTodo(String todoName, String folderName, String date){
        SQLiteDatabase db = getWritableDatabase();
        String sql = "INSERT INTO todoTable VALUES('"+folderName+"', '"+todoName+"', '"+date+"');";
        db.execSQL(sql);
        db.close();
    }
    public void deleteTodo(String todoName){
        SQLiteDatabase db = getWritableDatabase();
        String sql = "DELETE FROM todoTable WHERE todoName='"+todoName+"';";
        db.execSQL(sql);
        db.close();
    }

    public void update(String folderName){

    }

    public void deleteFolder(String folderName){
        SQLiteDatabase db = getWritableDatabase();
        String sql = "DELETE FROM folderTable WHERE folderName = '"+folderName+"';";
        db.execSQL(sql);
    }

    public ArrayList<String> getFolderNamesArrayResult(){
        SQLiteDatabase db = getReadableDatabase();
        ArrayList<String> folderNamesList = new ArrayList<>();

        Cursor cursor = db.rawQuery("SELECT * FROM folderTable", null);
        while(cursor.moveToNext()){
            folderNamesList.add(cursor.getString(1));
        }
        cursor.close();
        return folderNamesList;
    }

    public ArrayList<FolderItem> getFolderItemArrayListResult(){
        SQLiteDatabase db = getReadableDatabase();
        folderItemArrayList.clear();

        Cursor cursor = db.rawQuery("SELECT * FROM folderTable", null);
        while(cursor.moveToNext()){
            folderItemArrayList.add(new FolderItem(cursor.getString(1)));
        }

        return folderItemArrayList;
    }
    //해당 폴더에 관한 내용만 뿌리는걸로 변경 한 내용이 밑. 위는 그냥.
    public ArrayList<TodoItem> getTodoItemArrayListResult(){
        SQLiteDatabase db = getReadableDatabase();
        todoItemArrayList.clear();

        Cursor cursor = db.rawQuery("SELECT * FROM todoTable", null);
        while(cursor.moveToNext()){
            todoItemArrayList.add(new TodoItem(cursor.getString(0), cursor.getString(1), cursor.getString(2)));
        }

        return todoItemArrayList;
    }
    public ArrayList<TodoItem> getTodoItemArrayListResult(String folderName){
        SQLiteDatabase db = getReadableDatabase();
        todoItemArrayList.clear();

        Cursor cursor = db.rawQuery("SELECT * FROM todoTable WHERE folderName = '"+folderName+"';", null);
        while(cursor.moveToNext()){
            todoItemArrayList.add(new TodoItem(cursor.getString(0), cursor.getString(1), cursor.getString(2)));
        }

        return todoItemArrayList;
    }

    //폴더테이벌 디비 조회
    public String getStringFolderResult(){

        String result = "";
        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM folderTable", null);
        while(cursor.moveToNext()){
            result += cursor.getString(0)
                    + "|"
                    + cursor.getString(1)
                    + "-폴더 이름"
                    + cursor.getString(2)
                    + "-날짜 \n";
        }

        return result;
    }
    public String getStringTodoResult(){
        String result = "";
        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM todoTable", null);
        while(cursor.moveToNext()){
            result += cursor.getString(0)
                    + "-폴더이름 |"
                    + cursor.getString(1)
                    + "-투두이름 |"
                    + cursor.getString(2)
                    + "-날짜\n";
        }

        return result;
    }

    public void todoUpdateDate(String todoName, String newDate){
        SQLiteDatabase db = getWritableDatabase();
        String sql = "UPDATE todoTable SET date='"+newDate+"' WHERE todoName ='"+todoName+"'";

        db.execSQL(sql);
        db.close();
    }

    public void dropTable(String tableName)
    {
        SQLiteDatabase db = getWritableDatabase();
        String sql = "delete from '"+tableName+"'";
        db.execSQL(sql);

    }
    public int foldersCount(){
        return folderItemArrayList.size();
    }

    public int todosCount(){
        return todoItemArrayList.size();
    }
}
