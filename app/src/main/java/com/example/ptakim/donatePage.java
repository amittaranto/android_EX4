package com.example.ptakim;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class donatePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate_page);
    }

    public void add_money(View view) {
        SharedPreferences sp = getSharedPreferences("donations", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        TextView et =  findViewById(R.id.donateInput);
        TextView tv = findViewById(R.id.donationOverall);
        String donation = et.getText().toString();
        try {
            float d = Float.parseFloat(donation);
            d += sp.getFloat("donations",0);
            editor.putFloat("donations", d);
            editor.apply();
            tv.setText(Float.toString(sp.getFloat("donations",0)));
        } catch (NumberFormatException | NullPointerException nfe) {
            return;
        }

    }
}
