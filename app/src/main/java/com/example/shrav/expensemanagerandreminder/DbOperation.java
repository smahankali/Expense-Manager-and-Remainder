package com.example.shrav.expensemanagerandreminder;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 *
 * @author Shrav

 *purpose: This is the class for creation and handling the database object
 *
 */
public class DbOperation extends SQLiteOpenHelper {

    /**
     * Represent the DATABASE VERSION
     */
    private static final int DATABASE_VERSION = 1;

    /**
     * Represent the DATABASE NAME
     */
    private static final String DATABASE_NAME = "Expenses";

    /**
     *Represent the our first table name
     */
    protected static final String FIRST_TABLE_NAME = "Expense_Payment";

    /**
     *Represent the our second table name
     */
    protected static final String SECOND_TABLE_NAME = "Payment_Reminder";


    /**
     * The constructor of the class
     * @param context represent the context object
     */
    public DbOperation(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        //Log.d("Database Operation","DataBase Created Successfully.");
    }

    /**
     * Create the database or if exists return a handle to it
     * @param db represent the database object in SQLite Database
     */
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table if not exists " + FIRST_TABLE_NAME + " ( ID integer primary key autoincrement, Name Text not null,PayDate Text not null, Amt REAL not null, Exp Text, ImageLink Text)");
        //Log.d("Database Operation","Second Table Created Successfully.");
        db.execSQL("create table if not exists " + SECOND_TABLE_NAME + " ( ID integer primary key autoincrement, Name Text not null," +
                "PayDueDate Text, Amt REAL not null, Comments Text,EntryDate Text not null)");
    }


    /**
     * Alter the database if the requested version is newer than before
     * @param db represent the database object in SQLite Database
     * @param oldVersion represent an int value for the old version
     * @param newVersion represent an int value for the new version
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
