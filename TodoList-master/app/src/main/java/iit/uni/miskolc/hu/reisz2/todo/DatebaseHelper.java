package iit.uni.miskolc.hu.reisz2.todo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class DatebaseHelper extends SQLiteOpenHelper {

    public DatebaseHelper(Context context) {
        super(context, Contract.DB_NAME, null, Contract.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + Contract.TaskEntry.TABLE + " ( " +
                Contract.TaskEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Contract.TaskEntry.COL_TASK_TITLE + " TEXT NOT NULL);";

        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Contract.TaskEntry.TABLE);
        onCreate(db);
    }
}
