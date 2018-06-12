package com.eventhandling.example.lenovo.event_handling;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class spinner_activity extends Activity implements AdapterView.OnItemSelectedListener {

    Spinner sp;
    TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_activity);
        sp=(Spinner)findViewById(R.id.sp1);
        sp.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        TextView t=(TextView)view;
        Toast.makeText(this, t.getText(),Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Toast.makeText(this,"you have not selected", Toast.LENGTH_LONG).show();

    }
}
