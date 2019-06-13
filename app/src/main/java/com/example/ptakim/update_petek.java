package com.example.ptakim;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class update_petek extends AppCompatActivity {
    DBHelper db = null;
    int id = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_petek);
        db = new DBHelper(this);
        Intent intent = getIntent();
        id = intent.getIntExtra("ID",0);
    }

    public void update_petek(View view) {
        EditText editText = (EditText)findViewById(R.id.updateInput);

        String content= "'" + editText.getText().toString() + "'";
        Context context = getApplicationContext();

        String editCMD = "UPDATE " + Petek.TABLE_NAME +
                " SET content=" + content + " WHERE id="+ id +"";
        Toast.makeText(context, id + "", 15).show();
        Cursor c  = db.getReadableDatabase().rawQuery(editCMD,null);
        c.moveToFirst();
        c.close();
        Intent intent = new Intent(getApplicationContext(),screen3.class);
        startActivity(intent);
    }
}
