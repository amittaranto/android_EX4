package com.example.ptakim;


import android.database.Cursor;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Petek {
    public int id;
    public String title;
    public String content;
    public boolean status;
    public long dateInMills;

    public Petek(){}
    public Petek(int id, String content, String title) {
        this.id = id;
        this.content = content;
        this.title = title;
        dateInMills = Calendar.getInstance().getTimeInMillis();
        status = true;
    }

    public static String TABLE_NAME = "peteks";
    public static String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + " (id INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT, content TEXT)";

    public Petek(Cursor c) {
        id = c.getInt(0);
        content = c.getString(1);
    }

    public String getSQLInsertString(){
        return "INSERT INTO " + TABLE_NAME +
                " (title, content) VALUES('" + title + "', '" + content + "')";
    }

    public static String SELECT_ALL =
            "SELECT * FROM " + TABLE_NAME;

    public String toString(){
        return id + ", "+ title + ", " +  content;
    }
}
