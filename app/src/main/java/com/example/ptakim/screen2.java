package com.example.ptakim;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class screen2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen2);
        TextView t = findViewById(R.id.test);
        Intent intent = getIntent();
        String cont = intent.getStringExtra("CONTENT");
        DBHelper db = new DBHelper(this);

        if(cont.equals("")){
            insertPetek(cont,db);
        }


    }

    public void addPetek(View view) {
        Intent intent = new Intent(getApplicationContext(),addPetek.class);
        startActivity(intent);
    }

    public void insertPetek(String petek_content, DBHelper db){
        Petek petek = new Petek(1000,petek_content);
        db.getWritableDatabase().execSQL(petek.getSQLInsertString());
    }
}
