package com.example.ptakim;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class addPetek extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_petek);
    }

    public void add_petek(View view){
        EditText content_input = findViewById(R.id.contentInput);
        EditText title_input = findViewById(R.id.titleInput);
        Intent intent = new Intent(getApplicationContext(),screen2.class);
        intent.putExtra("CONTENT",content_input.getText().toString());
        intent.putExtra("TITLE",title_input.getText().toString());
        startActivity(intent);
    }
}
