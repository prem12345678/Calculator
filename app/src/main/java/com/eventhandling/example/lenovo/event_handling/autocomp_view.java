package com.eventhandling.example.lenovo.event_handling;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

public class autocomp_view extends AppCompatActivity {

    AutoCompleteTextView auto;
    MultiAutoCompleteTextView mul;

    String str[] = {"abhishek","abhimanu","abhisham","billu","chirag","chkshu","dinesh","dolber","prem","nidhi","sheela"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autocomp_view);
        auto = findViewById(R.id.autoCompleteTextView1);
        mul = findViewById(R.id.multiautoCompleteTextView2);

        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,str);

        auto.setAdapter(adapter);
        auto.setThreshold(3);
        mul.setThreshold(3);
        mul.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
        mul.setAdapter(adapter);
    }
}
