package com.example.ptakim;


import android.database.Cursor;

public class Petek {
    public int id;
    public String content;

    public Petek(){}
    public Petek(int id, String content) {
        this.id = id;
        this.content = content;
    }

    public static String TABLE_NAME = "peteks";
    public static String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + " (id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "content TEXT)";

    public Petek(Cursor c) {
        id = c.getInt(0);
        content = c.getString(1);
    }

    public String getSQLInsertString(){
        return "INSERT INTO " + TABLE_NAME +
                " (content) VALUES('" + content + "')";
    }

    public static String SELECT_ALL =
            "SELECT * FROM " + TABLE_NAME;

    public String toString(){
        return id + " , " +  content;
    }
}
