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
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

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

        update();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Petek ptk = peteks.get(position);
                long l_petek = ptk.is_editable();
                //Toast.makeText(screen3.this,Long.toString(l_petek),6).show();
                int days = 2;
                if( days<=2 ) {
                    Intent intent = new Intent(getApplicationContext(), update_petek.class);
                    intent.putExtra("ID", peteks.get(position).id);
                    startActivity(intent);
                }
                else{
                    ptk.status = "received";
                    Toast.makeText(screen3.this, "Older than two days.", 3);
                }
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

    public void goto_add(View view) {

        Intent intent = new Intent(getApplicationContext(),screen2.class);
        startActivity(intent);
    }

    public void goto_donations(View view) {
        Intent intent = new Intent(getApplicationContext(),donatePage.class);
        startActivity(intent);
    }
}
