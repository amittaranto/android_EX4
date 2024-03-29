package com.example.ptakim;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class screen2 extends AppCompatActivity {

    DBHelper db = null;
    ArrayList<Petek> peteks = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen2);
        Intent intent = getIntent();
        String cont = intent.getStringExtra("CONTENT");
        String tit = intent.getStringExtra("TITLE");
        db = new DBHelper(this);
        ListView listView= findViewById(R.id.ptakim);

        Cursor c = db.getReadableDatabase().rawQuery(Petek.SELECT_ALL,
                null);

        c.moveToFirst();
        while(!c.isAfterLast()){
            Petek p = new Petek(c);
            peteks.add(p);
            c.moveToNext();
        }


        listView.setAdapter(new ArrayAdapter<Petek>(
                this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                peteks
        ));


        if(cont!=null && tit!=null){
            insertPetek(cont, tit);
        }

    }

    public void addPetek(View view) {
        Intent intent = new Intent(getApplicationContext(),addPetek.class);
        startActivity(intent);
    }

    public void insertPetek(String petek_content, String petek_title){
        int id = get_last_element_id();
        Context context = getApplicationContext();
        Toast toast = Toast.makeText(context, id+ "", 3);
        toast.show();
        Petek petek = new Petek(id, petek_content, petek_title);
        db.getWritableDatabase().execSQL(petek.getSQLInsertString());
        peteks.add(petek);
    }


    public int get_last_element_id(){
        String cmd = "SELECT MAX(id) FROM " + Petek.TABLE_NAME;
        Cursor c = db.getReadableDatabase().rawQuery(cmd,null);

        if(c == null){
            return 1;
        }
        c.moveToFirst();
        int last_id = c.getInt(0);
        return ++last_id;
    }


    public void edit_screen_redirect(View view) {
        Intent intent = new Intent(getApplicationContext(),screen3.class);
        startActivity(intent);

    }

    public void don_move(View view){
        Intent intent = new Intent(getApplicationContext(),donatePage.class);
        startActivity(intent);
    }
}
