import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbOpenHelper {
    public static final String DATABASE_NAME = "entrybook.db";
    public static final int DATABASE_VERSION = 1;
    public static SQLiteDatabase mDB;
    private  DatabaseHelper mDBHelper;
    private Context mCtx;

    private  class DatabaseHelper extends SQLiteOpenHelper{
        public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            sqLiteDatabase.execSQL(DataBases.CreateDB._CREATE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+DataBases.CreateDB._TABLENAME);
            onCreate(sqLiteDatabase);
        }
    }
    DbOpenHelper(Context context){
        this.mCtx = context;
    }
    DbOpenHelper open() throws SQLException{
        mDBHelper = new DatabaseHelper(mCtx, DATABASE_NAME, null,DATABASE_VERSION);
        return this;
    }
    public void close(){
        mDB.close();
    }
}
