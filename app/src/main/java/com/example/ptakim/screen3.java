package com.example.ptakim;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class screen3 extends AppCompatActivity {

    DBHelper db = null;
    ArrayList<Petek> peteks = new ArrayList<>();
    ListView listView= null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen3);
        listView = findViewById(R.id.wall);

        db = new DBHelper(this);


//        Cursor c = db.getReadableDatabase().rawQuery(Petek.SELECT_ALL,
//                null);
//
//        c.moveToFirst();
//        while(!c.isAfterLast()){
//            Petek p = new Petek(c);
//            peteks.add(p);
//            c.moveToNext();
//        }
//
//
//        listView.setAdapter(new ArrayAdapter<Petek>(
//                this,
//                android.R.layout.simple_list_item_1,
//                android.R.id.text1,
//                peteks
//        ));
        update();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent = new Intent(getApplicationContext(),update_petek.class);
                intent.putExtra("ID", peteks.get(position).id);
                startActivity(intent);
//                update();
            }
    });


        }

    public void update(){
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
}

    public void gotoadd(View view) {

        Intent intent = new Intent(getApplicationContext(),screen2.class);
        startActivity(intent);
    }
}
