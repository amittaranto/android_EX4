package com.example.ptakim;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class donatePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate_page);
    }

    public void add_money(View view) {
        EditText et =  findViewById(R.id.donateInput);
        String donation = et.getText().toString();
        try {
            double d = Double.parseDouble(donation);

        } catch (NumberFormatException | NullPointerException nfe) {
            return;
        }

    }
}
