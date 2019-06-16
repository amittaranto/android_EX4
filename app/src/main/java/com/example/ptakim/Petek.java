package com.example.ptakim;


import android.database.Cursor;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Petek {
    public int id;
    public String title;
    public String content;
    public String status;
    public long date;

    public Petek(){}
    public Petek(int id, String content, String title) {
        this.id = id;
        this.content = content;
        this.title = title;
        this.date = Calendar.getInstance().getTimeInMillis();
        this.status = "sent";
    }

    public static String TABLE_NAME = "peteks";
    public static String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + " (id INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT, content TEXT)";

    public Petek(Cursor c) {
        id = c.getInt(0);
        title = c.getString(1);
        content = c.getString(2);
    }

    public String getSQLInsertString(){
        return "INSERT INTO " + TABLE_NAME +
                " (title, content) VALUES('" + title + "', '" + content + "')";
    }

    public long is_editable(){
        long diff = Calendar.getInstance().getTimeInMillis() - this.date;
        diff =  diff / (1000*60*60*24);
        if(diff < 2)
            this.status = "received";
        return diff;
    }

    public static String SELECT_ALL =
            "SELECT * FROM " + TABLE_NAME;

    public String toString(){
        return "id: " + id + ", title: "+ title + ", content: " +  content;
    }
}
