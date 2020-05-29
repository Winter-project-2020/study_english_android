package org.jby.studyenglish;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class CalendarDatabaseHandler extends SQLiteOpenHelper {
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "Event";

    // table name
    private static final String TABLE_NAME = "Events";

    public CalendarDatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        // Category table create query
        String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME +
                "(" + "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "kindoftest TEXT," +
                "day TEXT," +
                "time TEXT," +
                "supplies TEXT," +
                "place TEXT)";
        db.execSQL(CREATE_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

        // Create tables again
        onCreate(db);
    }

    /**
     * Inserting new data into table
     * */
    public void insertData(String kindoftest, String day, String time, String supplies, String place){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues addRowValue = new ContentValues();
        addRowValue.put("kindoftest", kindoftest);
        addRowValue.put("day", day);
        addRowValue.put("time", time);
        addRowValue.put("supplies", supplies);
        addRowValue.put("place", place);

        // Inserting Row
        db.insert(TABLE_NAME, null, addRowValue);
        db.close(); // Closing database connection
    }

    /**
     * Getting all datas
     * returns list of items
     * */
    public List<String> getAllitems(){
        List<String> items = new ArrayList<String>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                items.add(cursor.getString(2));
            } while (cursor.moveToNext());
        }

        // closing connection
        cursor.close();
        db.close();

        // returning lables
        return items;
    }
}
