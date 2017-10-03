package com.example.android.pets.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.android.pets.data.PetContract.PetEntry;
/**
 * Created by summi on 15-07-2017.
 */
public class PetDbHelper extends SQLiteOpenHelper{

    public static final String LOG_TAG = PetDbHelper.class.getSimpleName();

    /**Name of the database file*/
    private static final String DATABASE_NAME = "shelter.db";

    /*Database version. If we change the database schema, we must increment the database version*/
    private static final int DATABASE_VERSION = 1;

    public PetDbHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /*
    This is called when the database is created for the first time.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_PETS_TABLE = "CREATE TABLE " + PetEntry.TABLE_NAME + "(" +
                PetEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                PetEntry.COLUMN_PET_NAME + " TEXT NOT NULL, " +
                PetEntry.COLUMN_PET_BREED + " TEXT, " +
                PetEntry.COLUMN_PET_GENDER + " INTEGER NOT NULL, " +
                PetEntry.COLUMN_PET_WEIGHT + " INTEGER NOT NULL DEFAULT 0)";
        db.execSQL(SQL_CREATE_PETS_TABLE);
    }

    /*
    This is called when the database needs to be upgraded.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
