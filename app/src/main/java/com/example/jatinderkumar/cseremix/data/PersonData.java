package com.example.jatinderkumar.cseremix.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.jatinderkumar.cseremix.data.PersonContract.PersonEntry;

public class PersonData extends SQLiteOpenHelper {
    public static final String DATABASE_NAME ="person";
    public static final int DATABASE_VERSION = 1;
    public PersonData(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_DATABASE = "CREATE TABLE "+ PersonEntry.TABLE_NAME+" ("+PersonEntry._ID +
                " INTEGER PRIMARY KEY AUTOINCREMENT,"+PersonEntry.PERSON_NAME+
                " TEXT NOT NULL,"+PersonEntry.PERSON_PHONE+" INTEGER );";
        db.execSQL(CREATE_DATABASE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
