package mah.thdta3.robin.android.assignment1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by robin on 18/09/2017.
 */

public class UserDBHelper extends SQLiteOpenHelper {

    public static final String TABLE_NAME = "users";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_USERNAME = "username";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_SURNAME = "surname";
    public static final String COLUMN_PASSWORD = "password";

    public static final String DATABASE_NAME = "user.db";
    public static final int DATABASE_VERSION = 1;

    public static final String DATABASE_CREATE = "create table " + TABLE_NAME
            + "(" + COLUMN_ID + " integer primary key autoincrement, "
            + COLUMN_USERNAME + " text not null, "
            + COLUMN_NAME + " text not null, "
            + COLUMN_SURNAME + " text not null, "
            + COLUMN_PASSWORD + " text not null)";

    public UserDBHelper(Context context){
        super(context, DATABASE_NAME,null,DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(UserDBHelper.class.getName(),"Upgrading database from version " + oldVersion + " to " +newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
