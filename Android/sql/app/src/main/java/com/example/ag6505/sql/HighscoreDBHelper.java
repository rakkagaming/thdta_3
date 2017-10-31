package com.example.ag6505.sql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by tsroax on 06/09/15.
 */
public class HighscoreDBHelper extends SQLiteOpenHelper {
    public static final String TABLE_NAME = "highscore";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_POINTS = "points";

    private static final String DATABASE_NAME = "highscore.db";
    private static final int DATABASE_VERSION = 1;

    // Database creation sql statement
    private static final String DATABASE_CREATE =
            "create table " + TABLE_NAME + "(" +
                    COLUMN_ID + " text not null primary key, " +
                    COLUMN_NAME + " text not null, " +
                    COLUMN_POINTS + " integer);";

    public HighscoreDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(HighscoreDBHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
