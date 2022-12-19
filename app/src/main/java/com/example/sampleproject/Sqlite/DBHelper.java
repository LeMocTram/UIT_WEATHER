package com.example.sampleproject.Sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.sampleproject.Model.Asset;

public class DBHelper extends SQLiteOpenHelper {
    public static final int DB_VERSION = 1;
    public static final String DB_NAME ="VALUES_ASSET";
    public static final String TABLE_VALUES = "TABLE_VALUES_ASSET";
    //
    public static final String KEY_ID = "id";
    public static final String KEY_NAME = "name";
    public static final String KEY_DATE = "date";
    public static final String KEY_HUMIDITY = "humidity";
    public static final String KEY_WINDSPEED = "windSpeed";
    public static final String KEY_TEMPERATURE = "temperature";
    public static final String KEY_WINDDIRECTION = "windDirection";





    public DBHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
                String CREATE_VALUES_TABLE = "CREATE TABLE "+
                        TABLE_VALUES + "("
                        +KEY_ID +"INTEGER PRIMARY KEY," + KEY_NAME +"TEXT,"
                        +KEY_HUMIDITY +"FLOAT,"+ KEY_TEMPERATURE +"FLOAT,"
                        +KEY_WINDSPEED+"FLOAT,"+KEY_WINDDIRECTION+"FLOAT,"
                        +KEY_DATE+"TEXT"+")";
                db.execSQL(CREATE_VALUES_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_VALUES);
        // Create tables again
        onCreate(db);
    }
    public void insertAsset(Asset asset){
        SQLiteDatabase db = this.getWritableDatabase();
        String nullColumnHack = null;
        ContentValues values = new ContentValues();
        if (asset.getId() != "1") {
            values.put(KEY_ID, asset.getId());
            values.put(KEY_NAME, asset.getName());
            values.put(KEY_HUMIDITY, asset.attributes.humidity.getValue());
            values.put(KEY_TEMPERATURE, asset.attributes.temperature.getValue());
            values.put(KEY_WINDDIRECTION, asset.attributes.windDirection.getValue());
            values.put(KEY_WINDSPEED, asset.attributes.windSpeed.getValue());



            db.insert(TABLE_VALUES, nullColumnHack, values);
        }
        db.close();
    }
}
