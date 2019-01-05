package com.mcireasa.quizzapp.database;

import java.security.KeyRep;

public interface DatabaseConstants {


    String DATABASE_NAME = "quarter.db";
    int DATABASE_VERSION = 2;


    String USERS = "USERS";
    String USERS_ID = "id_user";
    String NAME = "name";
    String EMAIL = "email";
    String PASSWORD = "password";
    String TYPE = "type";

    String CREATE_TABLE_USERS = "CREATE TABLE " + USERS
            + " ( " + USERS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            NAME + " TEXT, " +
            EMAIL + " TEXT, " +
            PASSWORD + " TEXT, " +
            TYPE + " INTEGER);";


    String DROP_TABLE_USERS = "DROP TABLE IF EXISTS "
            + USERS+ ";";


    String TESTS = "TESTS";

    String TESTS_ID = "id_test";
    String NAME_TEST = "name_test";
    String ACTIVE = "active";
    String PUBLIC = "public";
    String COD_ACCES = "cod_acces";
    String NUMBER_ACCES = "number_acces";
    String TIME_ACTIVE = "time_active";
    String TIME = "time";
    String REVERSE = "reverse";


    String CREATE_TABLE_TESTS = "CREATE TABLE " + TESTS
            + " ( " + TESTS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
            NAME_TEST + " TEXT, " +
            ACTIVE + " BOOLEAN, " +
            PUBLIC + " BOOLEAN, " +
            COD_ACCES + " TEXT, " +
            NUMBER_ACCES + " INTEGER, " +
            TIME_ACTIVE + " DATE, " +
            TIME  + " INTEGER, " +
            REVERSE + " BOOLEAN); " ;

    String DROP_TABLE_TESTS = "DROP TABLE IF EXISTS "
            + TESTS+ ";";

    String CATEGORIES = "CATEGORIES";
    String CATEGORIES_ID = "id_category";
    String CATEGORY_NAME = "category_name";
    String USER_ID = "user_id";


    String CREATE_TABLE_CATEGORIES = "CREATE TABLE " + CATEGORIES
            + " ( " + CATEGORIES_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
            USER_ID + " INTEGER, "+
            CATEGORY_NAME + " TEXT);";


    String CATEGORIES_TESTS = "CATEGORIES_TESTS";
    String CT_ID= "id_ct";
    String CATEGORY_ID = "category_id";
    String TYPE_ACCES = "type_acces";
    String TEST_ID = "test_id";



    String CREATE_TABLE_CATEGORIES_TESTS = "CREATE TABLE " + CATEGORIES_TESTS
            + " ( " + CT_ID +  " INTEGER PRIMARY KEY AUTOINCREMENT, "+
            CATEGORY_ID + " INTEGER, " +
            TEST_ID + " INTEGER, " +
            TYPE_ACCES + " BOOLEAN);";


    String DROP_TABLE_CATEGORIES = "DROP TABLE IF EXISTS "
            + CATEGORIES+ ";";

    String MY_TESTS = "MY_TESTS";
    String MT_ID = "id_mt";
    String SCORE = "score";
    String TIMES_SUBMITTED = "times_submitted";
    String TIME_DID = "time_did";


    String CREATE_TABLE_MY_TESTS = "CREATE TABLE " + MY_TESTS
            + " ( " + MT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
            USER_ID + " INTEGER, "+
            TEST_ID + " INTEGER, "+
            SCORE + " INTEGER, "+
            TIMES_SUBMITTED + " INTEGER, "+
            TIME_DID + " INTEGER);";

    String DROP_TABLE_MY_TESTS = "DROP TABLE IF EXISTS "
            + MY_TESTS+ ";";

    String QUESTIONS = "QUESTIONS";
    String QUESTION_ID = "id_question";
    String QUESTION_TEXT = "sentence";
    String QUESTION_TYPE = "type";

    String CREATE_TABLE_QUESTIONS = "CREATE TABLE " + QUESTIONS
            + " ( " + QUESTION_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
            QUESTION_TEXT + " TEXT, " +
            SCORE + " INTEGER, " +
            TIME + " INTEGER " +
            TEST_ID + " INTEGER, "+
            QUESTION_TYPE + "  TEXT);";









}
