package com.example.ptakim;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void login(View view) {
        EditText user = (EditText)findViewById(R.id.username);
        EditText pass = (EditText)findViewById(R.id.password);

        Context context = getApplicationContext();

        if(user.getText().toString().equals("a")&& pass.getText().toString().equals("a")) {
            Intent intent = new Intent(getApplicationContext(),screen2.class);
            startActivity(intent);
        }
        else{
            Toast toast = Toast.makeText(context, "Wrong Input", 100);
            toast.show();
        }
    }

}
