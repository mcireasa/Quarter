package com.mcireasa.quizzapp.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class DatabaseController extends SQLiteOpenHelper implements DatabaseConstants {
    private static DatabaseController controller;

    public static DatabaseController getInstance(Context context){
        if(controller == null){
            synchronized (DatabaseController.class){
                if(controller == null){
                    controller = new DatabaseController(context);
                }
            }
        }

        return controller;
    }
    private DatabaseController(@Nullable Context context) {

        super(context, DATABASE_NAME,
                null,
                DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_USERS);
        db.execSQL(CREATE_TABLE_TESTS);
        db.execSQL(CREATE_TABLE_CATEGORIES);
        db.execSQL(CREATE_TABLE_CATEGORIES_TESTS);
        db.execSQL(CREATE_TABLE_MY_TESTS);
        db.execSQL(CREATE_TABLE_QUESTIONS);
        db.execSQL(CREATE_TABLE_ANSWERS);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(DROP_TABLE_USERS);
        db.execSQL(DROP_TABLE_TESTS);
        db.execSQL(DROP_TABLE_CATEGORIES);;
        db.execSQL(DROP_TABLE_MY_TESTS);
        db.execSQL(DROP_TABLE_CATEGORIES);
        db.execSQL(DROP_TABLE_QUESTION);
        db.execSQL(DROP_TABLE_ANSWER);
        db.execSQL(DROP_TABLE_CATEGORIES_TESTS);

        onCreate(db);
    }



}
